# PGM 87694 - 아이템 줍기
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87694

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]
ddx = [1, -1, 0, 0, 1, -1, 1, -1]
ddy = [0, 0, 1, -1, 1, 1, -1, -1]

def solution(rectangle, characterX, characterY, itemX, itemY):

    grid = [[0 for _ in range(102)] for _ in range(102)]
    for rec in rectangle:
        sx, sy, ex, ey = 2*rec[0], 2*rec[1], 2*rec[2], 2*rec[3]
        for i in range(sx, ex+1):
            for j in range(sy, ey+1):
                grid[i][j] = 1

    # 직사각형 외곽만 색칠해서 내부에 색칠되지 않은 부분을 찾아낸다.
    queue = deque()
    # 좌표는 1부터 시작하므로, [0, 0]은 적절한 시작점이 된다.
    queue.append([0, 0])
    visited = [[0 for _ in range(102)] for _ in range(102)]
    visited[0][0] = 1

    while queue:
        node = queue.popleft()
        a, b = node[0], node[1]

        for i in range(4):
            x, y = a + dx[i], b + dy[i]
            if 0 <= x < 102 and 0 <= y < 102 and not visited[x][y] and not grid[x][y]:
                visited[x][y] = 1
                queue.append([x, y])
    
    # 외부가 아닌데 색칠되지 않은 부분을 칠해준다.
    for i in range(102):
        for j in range(102):
            if not visited[i][j] and not grid[i][j]:
                grid[i][j] = 1

    # 외곽라인만 찾는다. 외곽라인은 상하좌우대각선에 반드시 색칠되지 않은 부분이 있다.
    queue = deque()
    visited = [[0 for _ in range(102)] for _ in range(102)]
    queue.append([2*characterX, 2*characterY])
    visited[2*characterX][2*characterY] = 1

    while queue:
        node = queue.popleft()
        a, b = node[0], node[1]
        
        for i in range(4):
            x, y = a + dx[i], b + dy[i]

            if 0 <= x < 102 and 0 <= y < 102 and not visited[x][y] and grid[x][y]:
                flag = False
                for j in range(8):
                    x_, y_ = x + ddx[j], y + ddy[j]
                    if 0 <= x_ < 102 and 0 <= y_ < 102 and not grid[x_][y_]:
                        flag = True
                        break
                
                if flag:
                    visited[x][y] = 1
                    queue.append([x, y])
    
    grid = visited
    
    queue = deque()
    visited = [[0 for _ in range(102)] for _ in range(102)]
    queue.append([2*characterX, 2*characterY])
    visited[2*characterX][2*characterY] = 1
    answer = 0

    while queue:
        node = queue.popleft()
        a, b = node[0], node[1]
        step = visited[a][b]

        if a == 2*itemX and b == 2*itemY:
            answer = (step-1) // 2

        for i in range(4):
            x, y = a + dx[i], b + dy[i]

            if 0 <= x < 102 and 0 <= y < 102 and not visited[x][y] and grid[x][y]:
                visited[x][y] = step+1
                queue.append([x, y])

    return answer