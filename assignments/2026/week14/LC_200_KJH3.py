class Solution:
    def numIslands(self, grid: List[List[str]]) -> int:
        if not grid:
            return 0

        rows, cols = len(grid), len(grid[0])
        visited = set()
        islands = 0

        def bfs(r, c):
            queue = collections.deque()
            queue.append((r, c))
            visited.add((r, c))
            directions = [[1, 0], [-1, 0], [0, 1], [0, -1]]

            while queue:
                r, c = queue.popleft()
                for x, y in directions:
                    dr, dc = r + x, c + y
                    if dr in range(rows) and dc in range(cols) and grid[dr][dc] == '1' and (dr, dc) not in visited:
                        queue.append((dr, dc))
                        visited.add((dr, dc))

        for r in range(rows):
            for c in range(cols):
                if grid[r][c] == '1' and (r, c) not in visited:
                    bfs(r, c)
                    islands += 1

        return islands