public class BOJ_14503_HSH {
    public static void main(String[] args) {
        BOJ_14503_HSH sol = new BOJ_14503_HSH();

        int result = sol.solution(3, 3, 1, new int[][]{
            {1, 1, 1},
            {1, 0, 1},
            {1, 1, 1}
        });

        System.out.println(result);
    }

    public int solution(int N, int M, int r, int[][] room) {
        int count = 0;
        int x = r;
        int y = 0;
        int direction = 0; // 북(0), 동(1), 남(2), 서(3)

        while (true) {
            if (room[x][y] == 0) {
                room[x][y] = 2; // 청소 완료 표시
                count++;
            }

            boolean cleaned = false;
            for (int i = 0; i < 4; i++) {
                direction = (direction + 3) % 4; // 왼쪽으로 회전
                int nx = x + dx[direction];
                int ny = y + dy[direction];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && room[nx][ny] == 0) {
                    x = nx;
                    y = ny;
                    cleaned = true;
                    break;
                }
            }

            if (!cleaned) {
                // 후진 시도
                int backDirection = (direction + 2) % 4;
                int bx = x + dx[backDirection];
                int by = y + dy[backDirection];

                if (bx >= 0 && bx < N && by >= 0 && by < M && room[bx][by] != 1) {
                    x = bx;
                    y = by;
                } else {
                    break; // 후진도 불가능하면 종료
                }
            }
        }

        return count;
    }

    private final int[] dx = {-1, 0, 1, 0}; // 북, 동, 남, 서
    private final int[] dy = {0, 1, 0, -1};
}