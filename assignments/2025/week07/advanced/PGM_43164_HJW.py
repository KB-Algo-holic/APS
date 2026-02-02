# PGM 43164 - 여행경로
# 유형: DFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43164

def solution(tickets):

    answer = []
    target = [1] * len(tickets)
    def dfs(n):

        visited[n] = 1

        if len(element) == len(tickets):
            if visited == target:
                tmp = []
                tmp.append(tickets[element[0]][0])
                for ele in element:
                    tmp.append(tickets[ele][1])
                answer.append(tmp)                
            return
        
        

        for i in range(len(tickets)):
            if tickets[n][1] == tickets[i][0] and visited[i] == 0:
                element.append(i)
                dfs(i)
                visited[element.pop()] = 0
    
    for i in range(len(tickets)):
        if tickets[i][0] == 'ICN':
            visited = [0] * len(tickets)
            element = []
            element.append(i)
            dfs(i)
            element.pop()
    
    answer.sort()
    return answer[0]