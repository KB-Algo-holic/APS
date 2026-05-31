# PGM 87946 - 피로도
# 유형: 완전 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946

answer = 0
visited = []

def dfs(t, dungeons, cnt):
    
    global answer
    
    if cnt > answer:
        answer = cnt
    
    for i in range(len(dungeons)):
        if not visited[i] and t >= dungeons[i][0]:
            visited[i] = 1
            dfs(t-dungeons[i][1], dungeons, cnt+1)
            visited[i] = 0
            

def solution(k, dungeons):
    
    global answer, visited
    
    visited = [0] * len(dungeons)
    
    dfs(k, dungeons, 0)
    
    return answer