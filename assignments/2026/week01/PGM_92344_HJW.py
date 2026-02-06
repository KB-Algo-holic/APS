# PGM 92344 - 파괴되지 않은 건물
# 유형: 완전 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/92344

def solution(board, skill):
    
    answer = 0
    N = len(board)
    M = len(board[0])
    
    acc = [[0 for _ in range(M+1)] for _ in range(N+1)]
    
    types = [0, -1, 1]
    for sk in skill:
        ty, r1, c1, r2, c2, degree = map(int, sk)
        acc[r1][c1] += degree * types[ty]
        acc[r1][c2+1] -= degree * types[ty]
        acc[r2+1][c1] -= degree * types[ty]
        acc[r2+1][c2+1] += degree * types[ty]
    
    for i in range(N):
        for j in range(1, M):
            acc[i][j] += acc[i][j-1]
    
    for j in range(M):
        for i in range(1, N):
            acc[i][j] += acc[i-1][j]
        
    for i in range(N):
        for j in range(M):
            board[i][j] += acc[i][j]
            if board[i][j] > 0:
                answer += 1
                
    return answer