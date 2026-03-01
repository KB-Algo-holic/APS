// PGM - 77485
// 구현 (시뮬레이션)
// https://school.programmers.co.kr/learn/courses/30/lessons/77485?language=java

import java.util.*;

class Solution {
    public int[] solution(int rows, int cols, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][cols];

        for (int i=0; i<rows; i++) {
            for (int j=0; j<cols; j++) {
                board[i][j] = cols * i + j + 1;
            }
        }

        //for (int i=0; i<rows; i++) System.out.println(Arrays.toString(board[i]));

        for (int qi = 0; qi < queries.length; qi++) {
            int[] query = queries[qi];
            int sr = query[0]-1, sc = query[1]-1, er = query[2]-1, ec = query[3]-1;

            // 회전 및 최솟값 비교를 위한 초기화
            int prev = board[sr][sc];
            int min = prev;

            // 회전
            // 1) 위 가로: (sr, sc+1..ec)  => 오른쪽으로 이동
            for (int c = sc + 1; c <= ec; c++) {
                int temp = board[sr][c];
                board[sr][c] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            // 2) 오른쪽 세로: (sr+1..er, ec) => 아래로 이동
            for (int r = sr + 1; r <= er; r++) {
                int temp = board[r][ec];
                board[r][ec] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            // 3) 아래 가로: (er, ec-1..sc) => 왼쪽으로 이동
            for (int c = ec - 1; c >= sc; c--) {
                int temp = board[er][c];
                board[er][c] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            // 4) 왼쪽 세로: (er-1..sr, sc) => 위로 이동
            for (int r = er - 1; r >= sr; r--) {
                int temp = board[r][sc];
                board[r][sc] = prev;
                prev = temp;
                min = Math.min(min, prev);
            }

            answer[qi] = min;
        }


        return answer;
    }
}