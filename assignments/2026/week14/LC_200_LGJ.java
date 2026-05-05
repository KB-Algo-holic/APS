// LC - 200 number of island
// DFS
// https://leetcode.com/problems/last-stone-weight/description/


// DFS 풀이 -> BFS보다 시간 효율 높음
class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        int answer = 0;

        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                // 땅('1')을 발견하면 DFS 시작
                if (grid[r][c] == '1') {
                    answer++;
                    dfs(grid, r, c, n, m);
                }
            }
        }
        return answer;
    }

    private void dfs(char[][] grid, int r, int c, int n, int m) {
        // 1. 범위를 벗어나거나 바다('0')라면 종료
        if (r < 0 || r >= n || c < 0 || c >= m || grid[r][c] == '0') {
            return;
        }

        // 2. 방문 처리: 다시 방문하지 않도록 '0'으로 변경
        grid[r][c] = '0';

        // 3. 상하좌우 재귀 호출
        dfs(grid, r + 1, c, n, m);
        dfs(grid, r - 1, c, n, m);
        dfs(grid, r, c + 1, n, m);
        dfs(grid, r, c - 1, n, m);
    }
}

// BFS
//class Solution {
//    public int numIslands(char[][] grid) {
//        int answer = 0;
//        // 상하좌우 네 방향으로 이어진 land 집합의 개수
//        int[] dr = {1, 0, -1, 0};
//        int[] dc = {0, 1, 0, -1};
//
//        int n = grid.length;
//        int m = grid[0].length;
//
//        boolean[][] visited = new boolean[n][m];
//
//        Queue<int[]> queue = new ArrayDeque<>();
//        // land를 찾아서 이어진 범위 확인
//        for (int r=0; r<n; r++) {
//            for (int c=0; c<m; c++) {
//                if (!visited[r][c] && grid[r][c] == '1') {
//                    answer ++; //최소 한개
//                    visited[r][c] = true;
//                    queue.offer(new int[] {r, c});
//                    // BFS
//                    while (!queue.isEmpty()) {
//                        int[] cur = queue.poll();
//                        for (int k=0; k<4; k++) {
//                            int nr = cur[0] + dr[k];
//                            int nc = cur[1] + dc[k];
//
//                            if (nr < 0 || nr >= n || nc < 0 || nc >= m) continue;
//                            if (grid[nr][nc] == '0' || visited[nr][nc]) continue;
//                            visited[nr][nc] = true;
//                            queue.offer(new int[] {nr, nc});
//                        }
//                    }
//
//                }
//            }
//        }
//
//        return answer;
//
//    }
//}