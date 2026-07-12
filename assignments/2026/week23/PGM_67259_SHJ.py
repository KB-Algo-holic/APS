# PGM 67259 - 경주로 건설
# 유형: DEQUE
# https://school.programmers.co.kr/learn/courses/30/lessons/67259

from collections import deque

def solution(board):
    n = len(board)

    move = [
        (-1, 0),
        (1, 0),
        (0, -1),
        (0, 1)
    ]

    cost = [[[float('inf')] * 4 for _ in range(n)] for _ in range(n)]

    queue = deque()

    queue.append((0, 0, -1, 0))

    while queue:
        x, y, direction, current_cost = queue.popleft()

        for next_direction in range(4):
            nx = x + move[next_direction][0]
            ny = y + move[next_direction][1]

            if nx < 0 or nx >= n or ny < 0 or ny >= n:
                continue

            if board[nx][ny] == 1:
                continue

            next_cost = current_cost + 100

            if direction != -1 and direction != next_direction:
                next_cost += 500

            if cost[nx][ny][next_direction] > next_cost:
                cost[nx][ny][next_direction] = next_cost
                queue.append((nx, ny, next_direction, next_cost))

    return min(cost[n - 1][n - 1])
