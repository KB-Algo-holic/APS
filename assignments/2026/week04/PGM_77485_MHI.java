class Solution {

    public int[] solution(int rows, int columns, int[][] queries) {

        int[][] board = new int[rows][columns];

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < columns; c++) {
                board[r][c] = columns * r + c + 1;
            }
        }

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int sr = queries[i][0] - 1;
            int sc = queries[i][1] - 1;
            int er = queries[i][2] - 1;
            int ec = queries[i][3] - 1;

            answer[i] = rotation(sr, sc, er, ec, board);
        }

        return answer;
    }

    private int rotation(int sr, int sc, int er, int ec, int[][] board) {

        int minN = board[sr][sc];
        int erased1 = board[sr][sc];
        int erased2;

        for (int c = sc + 1; c <= ec; c++) {
            erased2 = board[sr][c];
            board[sr][c] = erased1;
            erased1 = erased2;
            minN = Math.min(minN, erased1);
        }

        for (int r = sr + 1; r <= er; r++) {
            erased2 = board[r][ec];
            board[r][ec] = erased1;
            erased1 = erased2;
            minN = Math.min(minN, erased1);
        }

        for (int c = ec - 1; c >= sc; c--) {
            erased2 = board[er][c];
            board[er][c] = erased1;
            erased1 = erased2;
            minN = Math.min(minN, erased1);
        }

        for (int r = er - 1; r >= sr; r--) {
            erased2 = board[r][sc];
            board[r][sc] = erased1;
            erased1 = erased2;
            minN = Math.min(minN, erased1);
        }

        return minN;
    }
}