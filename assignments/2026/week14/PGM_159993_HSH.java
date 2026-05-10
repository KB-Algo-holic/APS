package week14;

import java.util.ArrayDeque;

public class PGM_159993_HSH {

    private static int dirX[] = { -1, 0, 1, 0 };
    private static int dirY[] = { 0, 1, 0, -1 };

    public static void main(String[] args) {
        // TODO Auto-generated method stub

        String[] maps = { "SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE" };

        int result = solution(maps);
        System.out.println(result);
    }

    public static int solution(String[] maps) {
        int answer = 0;
        int sx = 0; // 시작 좌표 x
        int sy = 0; // 시작 좌표 y
        int lx = 0; // 레버 좌표 x
        int ly = 0; // 레버 좌표 y
        int ex = 0; // 탈출구 좌표 x
        int ey = 0; // 탈출구 좌표 y
        int w = maps.length;
        int h = maps[0].length();

        char[][] board = new char[w][h];

        for (int i = 0; i < w; i++) {
            board[i] = maps[i].toCharArray();
            for (int j = 0; j < h; j++) {
                if (board[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }

                else if (board[i][j] == 'L') {
                    lx = i;
                    ly = j;
                }

                else if (board[i][j] == 'E') {
                    ex = i;
                    ey = j;
                }
            }
        }

        // 각자의 위치를 찾았다면 먼저 bfs를 통해서 시작 위치 -> 레버 위치로 이동
        int startToLever = bfs(board, sx, sy, lx, ly);
        if (startToLever == -1) {
            return -1;
        }
        // 레버 위치를 위에서 찾았다면 bfs를 통해서 레버 위치 -> 종료 위치로 이동
        int leverToExit = bfs(board, lx, ly, ex, ey);
        if (leverToExit == -1) {
            return -1;
        }

        answer = startToLever + leverToExit; // 두 경우를 합친 값이 최종 결과
        return answer;
    }

    private static int bfs(char[][] board, int sx, int sy, int tx, int ty) {
        int width = board.length; // 너비
        int height = board[0].length; // 높이
        boolean[][] visited = new boolean[width][height]; // 이미 지나간 곳인지 확인하기 위함
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        // 시작 위치를 큐에 넣기 -> 이동 횟수도 카운트 체크할 것
        queue.offer(new int[] { sx, sy, 0 });
        visited[sx][sy] = true; // 처음 시작 위치는 방문했습니다!
        // Queue가 비어 있지 않는 한 체크할 것
        while (!queue.isEmpty()) {
            int[] current = queue.poll(); // 현재 위치
            int x = current[0]; // 현재 위치에서의 x
            int y = current[1]; // 현재 위치에서의 y
            int count = current[2]; // 이동 횟차 처리

            // tx = targetX, ty = targetY
            if (x == tx && y == ty) {
                return count; // 현 위치가 타겟 위치라면 그동안 이동한 횟수는 반환하면 됨
            }

            // 방향 이동 (동서남북) = 네 가지 케이스
            for (int k = 0; k < 4; k++) {
                int nx = x + dirX[k]; // nextX = nx
                int ny = y + dirY[k]; // nextY = ny
                // 이동 가능한 범위를 먼저 설정할 것
                if ((nx >= 0) && (ny >= 0) && (nx < width) && (ny < height)) {
                    // X는 이동할 수 없음,, 그 외의 것은 이동 가능함
                    if (board[nx][ny] != 'X' && !visited[nx][ny]) {
                        visited[nx][ny] = true; // 이동 가능한 곳이라면 방문했다고 체크할
                        queue.offer(new int[] { nx, ny, count + 1 }); // 이동한 곳의 위치를 큐에 담고 대신 이동했으니 카운트도 하나 증가할 것
                    }
                }
            }
        }
        return -1;
    }
}
