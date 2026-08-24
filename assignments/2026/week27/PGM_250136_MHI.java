// PGM 250136 - 석유 시추
// dfs
// https://school.programmers.co.kr/learn/courses/30/lessons/250136

import java.util.*;

class Solution {
    static int[] dr = {0, 1, 0, -1};
    static int[] dc = {1, 0, -1, 0};

    public int solution(int[][] land) {

        int num = 2;
        HashMap<Integer, Integer> map = new HashMap<>();

        int rows = land.length;
        int cols = land[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                if (land[r][c] == 1) {
                    int cnt = makeNumber(land, r, c, num);

                    map.put(num, cnt);
                    num++;
                }
            }
        }

        int answer = 0;

        for (int c = 0; c < cols; c++) {

            HashSet<Integer> set = new HashSet<>();

            for (int r = 0; r < rows; r++) {
                if (land[r][c] > 1) {
                    set.add(land[r][c]);
                }
            }

            int sum = 0;

            for (int n : set) {
                sum += map.get(n);
            }

            answer = Math.max(answer, sum);
        }

        return answer;
    }

    static int makeNumber(int[][] land, int row, int col, int num) {

        ArrayDeque<int[]> stack = new ArrayDeque<>();

        stack.push(new int[]{row, col});
        land[row][col] = num;

        int cnt = 0;

        while (!stack.isEmpty()) {

            int[] cur = stack.pop();

            int r = cur[0];
            int c = cur[1];

            cnt++;

            for (int i = 0; i < 4; i++) {

                int nr = r + dr[i];
                int nc = c + dc[i];

                if (0 <= nr && nr < land.length &&
                        0 <= nc && nc < land[0].length &&
                        land[nr][nc] == 1) {

                    land[nr][nc] = num;

                    stack.push(new int[]{nr, nc});
                }
            }
        }

        return cnt;
    }
}