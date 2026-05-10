# PGM 76503 - 모두 0으로 만들기
# 유형: DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/76503

import sys
sys.setrecursionlimit(10**6)

answer = 0

def dfs(idx, nodes, edge, visited):
    
    global answer
    
    visited[idx] = 1
    
    for x in edge[idx]:
        if not visited[x]:
            num = dfs(x, nodes, edge, visited)
            nodes[idx] += num
            
    res = nodes[idx]
    answer += abs(res)
    return res
    
    
def solution(a, edges):
    
    if sum(a) != 0:
        return -1
    
    size = len(a)
    visited = [0] * size
    edge = [[] for _ in range(size)]
    for x, y in edges:
        edge[x].append(y)
        edge[y].append(x)
    
    dfs(0, a, edge, visited)
    
    return answer