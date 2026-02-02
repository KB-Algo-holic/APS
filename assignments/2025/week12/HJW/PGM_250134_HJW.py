# PGM 250134 - 수레 움직이기
# 유형: DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250134

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
answer = 0

def dfs(r, b, step, n, m, maze, visited_r, visited_b):
    
    global answer
    
    rx, ry, bx, by = r[0], r[1], b[0], b[1]
    
    if maze[rx][ry] == 3 and maze[bx][by] == 4:
        if not answer or step < answer:
            answer = step
        return
    
    if answer and step > answer:
        return
    
    if maze[rx][ry] != 3 and maze[bx][by] != 4:
        for i in range(4):
            rx_, ry_ = rx + dx[i], ry + dy[i]
            if 0 <= rx_ < n and 0 <= ry_ < m and not visited_r[rx_][ry_] and maze[rx_][ry_] != 5:
                visited_r[rx_][ry_] = 1
                for j in range(4):
                    bx_, by_ = bx + dx[j], by + dy[j]
                    if 0 <= bx_ < n and 0 <= by_ < m and not visited_b[bx_][by_] and maze[bx_][by_] != 5 and not (bx_ == rx_ and by_ == ry_):
                        if not (rx_ == bx and ry_ == by and bx_ == rx and by_ == ry):
                            visited_b[bx_][by_] = 1
                            dfs([rx_, ry_], [bx_, by_], step+1, n, m, maze, visited_r, visited_b)
                            visited_b[bx_][by_] = 0
                visited_r[rx_][ry_] = 0
    
    elif maze[rx][ry] == 3 and maze[bx][by] != 4:
        for i in range(4):
            x, y = bx + dx[i], by + dy[i]
            if 0 <= x < n and 0 <= y < m and not visited_b[x][y] and maze[x][y] != 5 and not (x == rx and y == ry):
                visited_b[x][y] = 1
                dfs([rx, ry], [x, y], step+1, n, m, maze, visited_r, visited_b)
                visited_b[x][y] = 0
    
    elif maze[rx][ry] != 3 and maze[bx][by] == 4:
        for i in range(4):
            x, y = rx + dx[i], ry + dy[i]
            if 0 <= x < n and 0 <= y < m and not visited_r[x][y] and maze[x][y] != 5 and not (x == bx and y == by):
                visited_r[x][y] = 1
                dfs([x, y], [bx, by], step+1, n, m, maze, visited_r, visited_b)
                visited_r[x][y] = 0

def solution(maze):
    
    global answer
    n, m = len(maze), len(maze[0])
    r, b = [], []
    for i in range(n):
        for j in range(m):
            if maze[i][j] == 1:
                r = [i, j]
                maze[i][j] = 0
            if maze[i][j] == 2:
                b = [i, j]
                maze[i][j] = 0
        if r and b:
            break
    visited_r = [[0 for _ in range(m)] for _ in range(n)]
    visited_b = [[0 for _ in range(m)] for _ in range(n)]
    visited_r[r[0]][r[1]] = 1
    visited_b[b[0]][b[1]] = 1
    dfs(r, b, 0, n, m, maze, visited_r, visited_b)
    return answer