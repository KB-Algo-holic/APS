# LC 200 - Number of Islands
# 유형: BFS
# 링크: https://leetcode.com/problems/number-of-islands/

from collections import deque

class Solution:
    dx = [1, -1, 0, 0]
    dy = [0, 0, 1, -1]
    def numIslands(self, grid: List[List[str]]) -> int:
        answer = 0
        n, m = len(grid), len(grid[0])

        visited = [[0 for _ in range(m)] for _ in range(n)]

        for i in range(n):
            for j in range(m):
                if not visited[i][j] and grid[i][j] == '1':
                    answer += 1
                    queue = deque()
                    visited[i][j] == 1
                    queue.append([i, j])

                    while queue:
                        node = queue.popleft()

                        for k in range(4):
                            x, y = node[0] + self.dx[k], node[1] + self.dy[k]
                            if 0 <= x < n and 0 <= y < m and not visited[x][y] and grid[x][y] == '1':
                                visited[x][y] = 1
                                queue.append([x, y])
        
        return answer