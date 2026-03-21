# BOJ 14503 - 로봇 청소기
# 유형: 구현
# 링크: https://www.acmicpc.net/problem/14503

from sys import stdin
input = stdin.readline

answer = 0
dx = [0, -1, 0, 1]
dy = [-1, 0, 1, 0]

N, M = map(int, input().rstrip().split())
x, y, direction = map(int, input().rstrip().split())
maps = []
for _ in range(N):
    maps.append(list(map(int, input().rstrip().split())))

while True:

    if maps[x][y] == 0:
        maps[x][y] = 2
        answer += 1
    
    for i in range(4):
        a, b = x + dx[(direction-i) % 4], y + dy[(direction-i) % 4]
        if maps[a][b] == 0:
            x, y = a, b
            direction = (((direction - i) % 4) - 1) % 4
            break
    
    else:
        a, b = x + dx[(direction - 1) % 4], y + dy[(direction - 1) % 4]
        if maps[a][b] != 1:
            x, y = a, b
        else:
            break

print(answer)