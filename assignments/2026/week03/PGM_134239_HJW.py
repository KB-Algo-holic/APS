# PGM 134239 - 우박수열 정적분
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/134239

def solution(k, ranges):
    answer = []
    
    graph = [k]
    while k != 1:
        if k%2:
            k *= 3
            k += 1
        else:
            k //= 2
        
        graph.append(k)
    
    N = len(graph)
    integral = []
    
    for i in range(N-1):
        integral.append((graph[i] + graph[i+1]) / 2)
    
    for r in ranges:
        a, b = r[0], N+r[1]-1
        if b < a:
            answer.append(-1)
        else:
            answer.append(sum(integral[a:b]))
    
    return answer