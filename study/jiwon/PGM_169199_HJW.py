# PGM 169199 - 리코쳇 로봇
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/169199

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def move(board, node, direction):
    
    N, M = len(board), len(board[0])
    a, b = node[0], node[1]
    
    while True:
        
        x, y = a + dx[direction], b + dy[direction]
        
        if not (0 <= x < N and 0 <= y < M and board[x][y] != "D"):
            return a, b
        
        a, b = x, y

def solution(board):
    
    answer = 0
    N, M = len(board), len(board[0])
    
    start = []
    for i in range(N):
        for j in range(M):
            if board[i][j] == "R":
                start = [i, j]
                break
        if start:
            break
    
    end = []
    for i in range(N):
        for j in range(M):
            if board[i][j] == "G":
                end = [i, j]
                break
        if end:
            break
    
    queue = deque()
    queue.append(start)
    visited = [[0 for _ in range(M)] for _ in range(N)]
    visited[start[0]][start[1]] = 1
    
    while queue:
        node = queue.popleft()
        step = visited[node[0]][node[1]]
        
        for i in range(4):
            x, y = move(board, node, i)
            if not visited[x][y]:
                visited[x][y] = step + 1
                queue.append([x, y])
    
    answer = visited[end[0]][end[1]] - 1
    
    return answer