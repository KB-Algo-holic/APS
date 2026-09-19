// LC 934 Shortest Bridge
// BFS - multi source
// https://leetcode.com/problems/shortest-bridge/description

class Solution {

    int[] dr = {1, 0, -1, 0};
    int[] dc = {0, 1, 0, -1};

    int n;
    boolean[][] visited;

    public int shortestBridge(int[][] grid) {

        n = grid.length;
        visited = new boolean[n][n];

        Queue<int[]> q = new ArrayDeque<>();

        // 1. 첫 번째 섬 찾기
        boolean found = false;

        for (int r = 0; r < n && !found; r++) {
            for (int c = 0; c < n; c++) {

                if (grid[r][c] == 1) {

                    markIsland(grid, r, c, q);
                    found = true;
                    break;
                }
            }
        }

        // 2. 첫 번째 섬 전체에서 동시에 BFS
        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // 같은 distance에 있는 좌표들을 한 번에 처리
            for (int s = 0; s < size; s++) {

                int[] cur = q.poll();

                for (int d = 0; d < 4; d++) {

                    int nr = cur[0] + dr[d];
                    int nc = cur[1] + dc[d];

                    if (nr < 0 || nr >= n ||
                            nc < 0 || nc >= n ||
                            visited[nr][nc]) {
                        continue;
                    }

                    // 두 번째 섬 발견
                    if (grid[nr][nc] == 1) {
                        return distance;
                    }

                    // 물로 확장
                    visited[nr][nc] = true;
                    q.offer(new int[]{nr, nc});
                }
            }

            distance++;
        }

        return -1;
    }

    private void markIsland(
            int[][] grid,
            int r,
            int c,
            Queue<int[]> q
    ) {

        Queue<int[]> islandQ = new ArrayDeque<>();

        islandQ.offer(new int[]{r, c});
        visited[r][c] = true;

        while (!islandQ.isEmpty()) {

            int[] cur = islandQ.poll();

            // 두 번째 BFS의 시작점
            q.offer(cur);

            for (int d = 0; d < 4; d++) {

                int nr = cur[0] + dr[d];
                int nc = cur[1] + dc[d];

                if (nr < 0 || nr >= n ||
                        nc < 0 || nc >= n ||
                        visited[nr][nc] ||
                        grid[nr][nc] == 0) {
                    continue;
                }

                visited[nr][nc] = true;
                islandQ.offer(new int[]{nr, nc});
            }
        }
    }
}