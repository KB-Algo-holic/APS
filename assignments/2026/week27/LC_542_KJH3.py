from collections import deque
class Solution:
    def updateMatrix(self, mat: List[List[int]]) -> List[List[int]]:
        def bfs(mat, visited, q):
            while q:
                x, y= q.popleft()
                for d in range(4):
                    nx, ny = x + dx[d], y + dy[d]
                    if 0<=nx<len(mat) and 0<=ny<len(mat[x]) and visited[nx][ny] == -1:
                        q.append((nx, ny))
                        visited[nx][ny] = visited[x][y]+1

        q = deque()
        dx = (0, 1, 0, -1)
        dy = (1, 0, -1, 0)
        visited = [[-1]*len(mat[i]) for i in range(len(mat))]
        for i in range(len(mat)):
            for j in range(len(mat[i])):
                if mat[i][j] == 0:
                    q.append((i, j))
                    visited[i][j] = 0
        bfs(mat, visited, q)
        return visited