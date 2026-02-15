# BOJ 15686 - 치킨 배달
# 유형: DFS
# 링크: https://www.acmicpc.net/problem/15686

from sys import stdin
input = stdin.readline

N, M = map(int, input().split())
maps = []

for _ in range(N):
    maps.append(list(map(int, input().split())))

houses = []
for i in range(N):
    for j in range(N):
        if maps[i][j] == 1:
            houses.append([i, j])

chickens = []
for i in range(N):
    for j in range(N):
        if maps[i][j] == 2:
            chickens.append([i, j])

answer = N ** 3

def findChickenDistance(chicken):
    
    result = 0

    for house in houses:
        x, y = house[0], house[1]

        Min = N ** 3
        for chick in chicken:
            a, b = chick[0], chick[1]

            if abs(x-a) + abs(y-b) < Min:
                Min = abs(x-a) + abs(y-b)
        
        result += Min
    
    return result

def chooseChicken(element, idx, depth, M, chickenlength):

    global answer

    if depth == M:
        tmp = findChickenDistance(element)
        if tmp < answer:
            answer = tmp
    
    if idx == chickenlength:
        return
    
    element.append(chickens[idx])
    chooseChicken(element, idx+1, depth+1, M, chickenlength)
    element.pop()
    chooseChicken(element, idx+1, depth, M, chickenlength)

chooseChicken([], 0, 0, M, len(chickens))

print(answer)