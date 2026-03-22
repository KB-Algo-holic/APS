// PGM - 77485 행렬 테두리 회전하기
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/77485
// 빠진 곳을 채우는 느낌

import java.util.*;

class Solution {
    public int[] solution(int rows, int cols, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][cols];
        for (int r=0; r<rows; r++) {
            for (int c=0; c<cols; c++) {
                board[r][c] = r*cols+c+1;
            }
        }
        //System.out.println(Arrays.deepToString(board));

        for (int i = 0; i < queries.length; i++) {

            int sr = queries[i][0] - 1;
            int sc = queries[i][1] - 1;
            int er = queries[i][2] - 1;
            int ec = queries[i][3] - 1;

            int temp = board[sr][sc];
            int min = temp;

            // 1) 왼쪽 열 위로
            for (int r = sr; r < er; r++) {
                board[r][sc] = board[r + 1][sc];
                min = Math.min(min, board[r][sc]);
            }

            // 2) 아래 행 왼쪽으로
            for (int c = sc; c < ec; c++) {
                board[er][c] = board[er][c + 1];
                min = Math.min(min, board[er][c]);
            }

            // 3) 오른쪽 열 아래로
            for (int r = er; r > sr; r--) {
                board[r][ec] = board[r - 1][ec];
                min = Math.min(min, board[r][ec]);
            }

            // 4) 위 행 오른쪽으로
            for (int c = ec; c > sc + 1; c--) {
                board[sr][c] = board[sr][c - 1];
                min = Math.min(min, board[sr][c]);
            }
            board[sr][sc + 1] = temp;

            answer[i] = min;
        }

        return answer;
    }
}