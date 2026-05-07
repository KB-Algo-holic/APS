# LC 695 - Max Area of Island
# 유형: BFS
# 링크: https://leetcode.com/problems/max-area-of-island/

from collections import deque

class Solution:
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]

    def bfs(self, grid, visited, i, j, n, m):
        queue = deque()
        visited[i][j] = 1
        queue.append([i, j])
        step = 0

        while queue:
            step += 1
            node = queue.popleft()
            a, b = node[0], node[1]

            for i in range(4):
                x, y = a + self.dx[i], b + self.dy[i]

                if 0 <= x < n and 0 <= y < m and not visited[x][y] and grid[x][y]:
                    visited[x][y] = 1
                    queue.append([x, y])
        
        return step

    def maxAreaOfIsland(self, grid: List[List[int]]) -> int:
        answer = 0
        n, m = len(grid), len(grid[0])
        
        visited = [[0 for _ in range(m)] for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if not visited[i][j] and grid[i][j]:
                    res = self.bfs(grid, visited, i, j, n, m)

                    if res > answer:
                        answer = res
        
        return answer