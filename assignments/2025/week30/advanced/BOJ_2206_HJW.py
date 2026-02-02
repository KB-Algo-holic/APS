# BOJ 2206 - 벽 부수고 이동하기
# 유형: BFS
# 링크: https://www.acmicpc.net/problem/2206

from sys import stdin
from collections import deque

N, M = map(int, stdin.readline().rstrip().split(' '))

maps = [[] for _ in range(N)]

for i in range(N):
    tmp = stdin.readline().rstrip()
    for j in range(M):
        maps[i].append(tmp[j])

def bfs(map_):
    
    visited = [[0 for _ in range(M)] for __ in range(N)]
    queue = deque()
    queue.append([0, 0, 0, 1])
    visited[0][0] = 1
    answer = -1

    while queue:
        node = queue.popleft()
        x = node[0]
        y = node[1]
        did = node[2]
        time = node[3]

        if x == N-1 and y == M-1:
            answer = time
            break

        if x < N-1 and map_[x+1][y] == '0' and visited[x+1][y] == 0:
            queue.append([x+1, y, did, time + 1])
            if did == 0:
                visited[x+1][y] = 1
            else:
                visited[x+1][y] = 2
        elif x < N-1 and map_[x+1][y] == '0' and visited[x+1][y] == 2 and did == 0:
            queue.append([x+1, y, did, time + 1])
            visited[x+1][y] = 1
        
        elif x < N-1 and map_[x+1][y] == '1' and did == 0:
            queue.append([x+1, y, 1, time + 1])
            if did == 0:
                visited[x+1][y] = 1
            else:
                visited[x+1][y] = 2
        
        if y < M-1 and map_[x][y+1] == '0' and visited[x][y+1] == 0:
            queue.append([x, y+1, did, time + 1])
            if did == 0:
                visited[x][y+1] = 1
            else:
                visited[x][y+1] = 2
        
        elif y < M-1 and map_[x][y+1] == '0' and visited[x][y+1] == 2 and did == 0:
            queue.append([x, y+1, did, time + 1])
            visited[x][y+1] = 1
        
        elif y < M-1 and map_[x][y+1] == '1' and did == 0:
            queue.append([x, y+1, 1, time + 1])
            if did == 0:
                visited[x][y+1] = 1
            else:
                visited[x][y+1] = 2

        if x > 0 and map_[x-1][y] == '0' and visited[x-1][y] == 0:
            queue.append([x-1, y, did, time + 1])
            if did == 0:
                visited[x-1][y] = 1
            else:
                visited[x-1][y] = 2
        
        elif x > 0 and map_[x-1][y] == '0' and visited[x-1][y] == 2 and did == 0:
            queue.append([x-1, y, did, time + 1])
            visited[x-1][y] = 1
        
        elif x > 0 and map_[x-1][y] == '1' and did == 0:
            queue.append([x-1, y, 1, time + 1])
            if did == 0:
                visited[x-1][y] = 1
            else:
                visited[x-1][y] = 2

        if y > 0 and map_[x][y-1] == '0' and visited[x][y-1] == 0:
            queue.append([x, y-1, did, time + 1])
            if did == 0:
                visited[x][y-1] = 1
            else:
                visited[x][y-1] = 2
        
        elif y > 0 and map_[x][y-1] == '0' and visited[x][y-1] == 2 and did == 0:
            queue.append([x, y-1, did, time + 1])
            visited[x][y-1] = 1
        
        elif y > 0 and map_[x][y-1] == '1' and did == 0:
            queue.append([x, y-1, 1, time + 1])
            if did == 0:
                visited[x][y-1] = 1
            else:
                visited[x][y-1] = 2

    return answer

answer = bfs(maps)

print(answer)