public class PGM_169199_HSH {
    private static int[] dirX = { -1, 0, 1, 0 };
    private static int[] dirY = { 0, 1, 0, -1 };

    public static void main(String[] args) {

        PGM_169199_HSH sol = new PGM_169199_HSH();

        int result = sol.solution(new String[]{"...D..R.", ".D.G...", "....D..", "D....D.", "..D....", "....D.D", ".D....D", "...D...."});

        System.out.println(result);
    }

    public int solution(String[] board) {
        int startX = 0;
        int startY = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    startX = i;
                    startY = j;
                    break;
                }
            }
        }
        int sizeX = board.length;
        int totalSize = 0;
        for (String row : board) {
            totalSize += row.length();
        }

        boolean[][] visited = new boolean[sizeX][];
        for (int i = 0; i < sizeX; i++) {
            visited[i] = new boolean[board[i].length()];
        }
        int[][] queue = new int[totalSize][3];
        int front = 0;
        int rear = 0;

        queue[rear++] = new int[] { startX, startY, 0 };
        visited[startX][startY] = true;

        while (front < rear) {
            int[] current = queue[front++];
            int x = current[0];
            int y = current[1];
            int count = current[2];

            if (board[x].charAt(y) == 'G') {
                return count;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = x;
                int nextY = y;

                while (isMovable(nextX + dirX[i], nextY + dirY[i], board)) {
                    nextX += dirX[i];
                    nextY += dirY[i];
                }

                if (!visited[nextX][nextY]) {
                    visited[nextX][nextY] = true;
                    queue[rear++] = new int[] { nextX, nextY, count + 1 };
                }
            }
        }

        return -1;
    }

    private boolean isMovable(int x, int y, String[] board) {
        return x >= 0 && x < board.length
                && y >= 0 && y < board[x].length()
                && board[x].charAt(y) != 'D';
    }
}
