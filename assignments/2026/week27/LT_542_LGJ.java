// LT - 542 matrix
// BFS
// https://leetcode.com/problems/01-matrix/

class Solution {
    int[] dr = {0, 1, 0, -1};
    int[] dc = {1, 0, -1, 0};

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        Queue<int[]> q = new ArrayDeque<>();
        int[][] distance = new int[m][n];

        // 아직 방문하지 않은 1은 -1로 표시
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (mat[r][c] == 0) {
                    q.offer(new int[]{r, c});
                    distance[r][c] = 0;
                } else {
                    distance[r][c] = -1;
                }
            }
        }

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cr = cur[0];
            int cc = cur[1];

            for (int i = 0; i < 4; i++) {
                int nr = cr + dr[i];
                int nc = cc + dc[i];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                // 이미 거리가 결정된 칸
                if (distance[nr][nc] != -1) {
                    continue;
                }

                distance[nr][nc] = distance[cr][cc] + 1;
                q.offer(new int[]{nr, nc});
            }
        }

        return distance;
    }
}