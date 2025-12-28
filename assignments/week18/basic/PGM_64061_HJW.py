# PGM 64061 - 크레인 인형뽑기 게임
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/64061

def solution(board, moves):

    N = len(board)
    
    queues = [[] for _ in range(N+1)]

    for i in range(N):
        for j in range(N):
            if board[j][i]:
                queues[i+1].append(board[j][i])
    results = []
    answer = 0

    for num in moves:
        if queues[num]:
            results.append(queues[num].pop(0))

            if len(results) >= 2 and results[-1] == results[-2]:
                results.pop()
                results.pop()
                answer += 2
    
    return answer