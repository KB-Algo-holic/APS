# PGM 67259 - 경주로 건설
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67259

from collections import deque

dx = [1, 0, -1, 0]
dy = [0, 1, 0, -1]

def solution(board):
    answer = 0
    N = len(board)
    visited = [[[10**6 for _ in range(4)] for _ in range(N)] for _ in range(N)]
    queue = deque()
    if board[1][0] != 1:
        visited[1][0][0] = 100
        queue.append([1, 0, 0])
    if board[0][1] != 1:
        visited[0][1][1] = 100
        queue.append([0, 1, 1])
    
    while queue:
        node = queue.popleft()
        a, b, d = node[0], node[1], node[2]
        cost = visited[a][b][d]
        
        for i in range(4):
            x, y = a + dx[i], b + dy[i]
            new_cost = cost + 100
            
            if i != d:
                new_cost += 500
            
            if 0 <= x < N and 0 <= y < N and board[x][y] != 1 and visited[x][y][i] >= new_cost:
                visited[x][y][i] = new_cost
                queue.append([x, y, i])
    
    return min(visited[N-1][N-1])