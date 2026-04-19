// PGM 172928 공원산책
// 시뮬레이션 ( 그래프 x)
// https://school.programmers.co.kr/learn/courses/30/lessons/172928?language=java


class Solution {
    public int[] solution(String[] park, String[] routes) {
        int h = park.length;
        int w = park[0].length();

        int x = 0, y = 0;

        // 시작 위치 찾기
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (park[i].charAt(j) == 'S') {
                    x = i;
                    y = j;
                }
            }
        }

        // 방향 벡터
        int[] dx = {-1, 1, 0, 0}; // N, S, W, E
        int[] dy = {0, 0, -1, 1};

        for (String route : routes) {
            String[] parts = route.split(" ");
            char dir = parts[0].charAt(0);
            int dist = Integer.parseInt(parts[1]);

            int nx = x;
            int ny = y;

            int d = 0;
            if (dir == 'N') d = 0;
            else if (dir == 'S') d = 1;
            else if (dir == 'W') d = 2;
            else if (dir == 'E') d = 3;

            boolean canMove = true;

            // 이동 가능 여부 먼저 체크
            for (int i = 0; i < dist; i++) {
                nx += dx[d];
                ny += dy[d];

                if (nx < 0 || ny < 0 || nx >= h || ny >= w ||
                        park[nx].charAt(ny) == 'X') {
                    canMove = false;
                    break;
                }
            }

            // 이동 가능하면 위치 갱신
            if (canMove) {
                x = nx;
                y = ny;
            }
        }

        return new int[]{x, y};
    }
}