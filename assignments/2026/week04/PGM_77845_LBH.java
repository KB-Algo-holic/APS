// PGM 77845 - 행렬 테두리 회전하기
// 구현
// https://school.programmers.co.kr/learn/courses/30/lessons/77845

class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        // init
        int[][] board = new int[rows + 1][columns + 1];
        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                board[i][j] = (i - 1) * columns + j;
            }
        }

        for (int i = 0; i < queries.length; i++) {

            int x1 = queries[i][0];
            int y1 = queries[i][1];
            int x2 = queries[i][2];
            int y2 = queries[i][3];

            int temp = board[x1][y1];
            int min = temp;

            for (int r = x1; r < x2; r++) {
                board[r][y1] = board[r + 1][y1];
                min = Math.min(min, board[r][y1]);
            }

            for (int c = y1; c < y2; c++) {
                board[x2][c] = board[x2][c + 1];
                min = Math.min(min, board[x2][c]);
            }

            for (int r = x2; r > x1; r--) {
                board[r][y2] = board[r - 1][y2];
                min = Math.min(min, board[r][y2]);
            }

            for (int c = y2; c > y1 + 1; c--) {
                board[x1][c] = board[x1][c - 1];
                min = Math.min(min, board[x1][c]);
            }

            board[x1][y1 + 1] = temp;

            answer[i] = min;
        }

        return answer;
    }
}
