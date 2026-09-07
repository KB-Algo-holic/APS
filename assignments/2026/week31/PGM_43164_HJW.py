# PGM 43164 - 여행경로
# 유형: DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43164

answer = ""

def dfs(idx, visited, res, tickets):
    
    global answer
    
    if sum(visited) == len(tickets):
        res.append(tickets[idx][1])
        result = ' '.join(res)
        if not answer:
            answer = result
        if result < answer:
            answer = result
        res.pop()
        return
    
    for i in range(len(tickets)):
        if not visited[i] and tickets[idx][1] == tickets[i][0]:
            visited[i] = 1
            res.append(tickets[i][0])
            dfs(i, visited, res, tickets)
            res.pop()
            visited[i] = 0

def solution(tickets):

    global answer
    
    for i in range(len(tickets)):
        if tickets[i][0] == "ICN":
            visited = [0] * len(tickets)
            res = []
            res.append("ICN")
            visited[i] = 1
            dfs(i, visited, res, tickets)
            
    return answer.split()