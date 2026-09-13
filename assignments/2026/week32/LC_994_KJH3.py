from collections import deque


class Solution:
    def orangesRotting(self, grid: List[List[int]]) -> int:
        m, n = len(grid), len(grid[0])
        directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]
        minute = 0
        q = deque()
        cnt_fresh = 0
        # grid을 for문으로 돌면서 썩은애의 위치를 q에 넣는다
        for r in range(m):
            for c in range(n):
                if grid[r][c] == 2:
                    q.append((r, c))
                elif grid[r][c] == 1:
                    cnt_fresh += 1

        if cnt_fresh == 0:
            return 0

        while q:
            size = len(q)  # 현재 썩어있는 오렌지 수
            for _ in range(size):
                r, c = q.popleft()  # 현재 썩어있는 오렌지 한 번에 모두 처리

                for x, y in directions:
                    nr, nc = r + x, c + y

                    if 0 <= nr < m and 0 <= nc < n and grid[nr][nc] == 1:
                        grid[nr][nc] = 2
                        cnt_fresh -= 1
                        q.append((nr, nc))

            minute += 1

        if cnt_fresh != 0:
            return -1

        return minute - 1