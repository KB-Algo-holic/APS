# PGM 42884 - 단속카메라
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42884

def solution(routes):
    answer = 0
    N = len(routes)
    visited = [0] * N
    routes.sort(key=lambda x:x[1])
    while sum(visited) != N:
        answer += 1
        for i in range(N):
            if not visited[i]:
                point = routes[i][1]
                break
        for i in range(N):
            if not visited[i] and routes[i][0] <= point <= routes[i][1]:
                visited[i] = 1
                
    return answer