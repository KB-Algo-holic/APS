// PGM - 181832 정수를 나선형으로..
// 시뮬레이션
// https://school.programmers.co.kr/learn/courses/30/lessons/181832

import java.util.*;

class Solution {
    public static int[][] solution(int n) {
        int[][] answer = new int[n][n];

        // 방향 배열
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        // 초기화
        int dir = 0;
        int r = 0;
        int c = 0;
        int num = 1;

        while (num <= n * n) {
            answer[r][c] = num++;

            int nr = r + dr[dir];
            int nc = c + dc[dir];

            if (nr < 0 || nc < 0 || nr >= n || nc >= n || answer[nr][nc] != 0) {
                dir = (dir + 1) % 4;
                nr = r + dr[dir];
                nc = c + dc[dir];
            }

            r = nr;
            c = nc;
        }

        return answer;
    }
}