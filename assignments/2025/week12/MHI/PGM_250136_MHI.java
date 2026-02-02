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
                if (land[r][c] > 1) set.add(land[r][c]);
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
        int cnt = 0;
        int rows = land.length;
        int cols = land[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{row, col});
        land[row][col] = num;
        cnt++;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int r = cur[0], c = cur[1];

            for (int i = 0; i < 4; i++) {
                int nR = r + dr[i];
                int nC = c + dc[i];
                if (nR >= 0 && nR < rows && nC >= 0 && nC < cols && land[nR][nC] == 1) {
                    land[nR][nC] = num;
                    cnt++;
                    queue.add(new int[]{nR, nC});
                }
            }
        }

        return cnt;
    }
}
