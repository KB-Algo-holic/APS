# PGM 81302 - 거리두기 확인하기
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/81302

from collections import deque

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def solution(places):
    answer = []
    for place in places:
        res = True
        for i in range(5):
            for j in range(5):
                if place[i][j] == "P":
                    queue = deque()
                    queue.append([i, j])
                    visited = [[0 for _ in range(5)] for _ in range(5)]
                    visited[i][j] = 1
                    
                    while queue:
                        node = queue.popleft()
                        a, b = node[0], node[1]
                        step = visited[a][b]
                        
                        if step > 3:
                            break
                        
                        if place[a][b] == "P" and 1 < step <= 3:
                            res = False
                            break
                        
                        for k in range(4):
                            x, y = a + dx[k], b + dy[k]
                            if 0 <= x < 5 and 0 <= y < 5 and not visited[x][y] and place[x][y] != "X":
                                visited[x][y] = step+1
                                queue.append([x, y])
                    
                    if not res:
                        break
                if not res:
                    break
            if not res:
                break
        answer.append(1 if res else 0)
                    
    return answer