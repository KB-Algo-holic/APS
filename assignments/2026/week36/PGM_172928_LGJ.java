import java.util.*;

class Solution {
    // 동서남북
    int[] dr = {0, 0, 1, -1};
    int[] dc = {1, -1, 0, 0};

    public int[] solution(String[] park, String[] routes) {
        Map<String, Integer> map = new HashMap<>();
        map.put("E", 0);
        map.put("W", 1);
        map.put("S", 2);
        map.put("N", 3);

        int[] answer = new int[2];
        int h = park.length;
        int w = park[0].length();

        // 출발점 탐색
        for (int i=0; i<h; i++) {
            String row = park[i];
            for (int j=0; j<w; j++) {
                if (row.charAt(j) == 'S') {
                    answer[0] = i;
                    answer[1] = j;
                }
            }
        }
        System.out.println(Arrays.toString(answer));
        // 루트 이동
        for (String route: routes) {
            String[] dirs = route.split(" "); // 방향 + 거리

            int dir = map.get(dirs[0]); // 방향의 인덱스
            int dist = Integer.parseInt(dirs[1]); // 거리

            int cr = answer[0];
            int cc = answer[1];
            boolean isPossible = true; // 이동중 만난 경우

            // 방향에 따라 거리만큼 이동
            for (int i=0; i<dist; i++) {

                int nr = cr + dr[dir];
                int nc = cc + dc[dir];
                // 이동 중 장애물 만나면 false
                if (nr<0||nr>=h||nc<0||nc>=w|| park[nr].charAt(nc) == 'X') {
                    isPossible = false;
                    break;
                }
                cr = nr;
                cc = nc;

            }
            if (isPossible) {
                answer[0] = cr;
                answer[1] = cc;
            }
            System.out.println(Arrays.toString(answer));
        }

        return answer;
    }
}