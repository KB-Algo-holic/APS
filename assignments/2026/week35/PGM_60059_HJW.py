# PGM 60059 - 자물쇠와 열쇠
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60059

def rotate(key, M):
    
    result = [[0 for _ in range(M)] for _ in range(M)]
    
    for i in range(M):
        for j in range(M):
            result[i][j] = key[M-j-1][i]
    
    return result

def move(key, N, M, x, y):
    
    size = 2*M + N - 2
    result = [[0 for _ in range(size)] for _ in range(size)]
    
    for i in range(M):
        for j in range(M):
            result[x+i][y+j] = key[i][j]
    
    crop = [[0 for _ in range(N)] for _ in range(N)]
    
    for i in range(N):
        for j in range(N):
            crop[i][j] = result[M-1+i][M-1+j]
    
    return crop

def check(lock, key, N):
    
    for i in range(N):
        for j in range(N):
            if lock[i][j] == key[i][j]:
                return False
    
    return True

def solution(key, lock):
    
    N = len(lock)
    M = len(key)
    
    for i in range(N+M-1):
        for j in range(N+M-1):
            moved_key = move(key, N, M, i, j)
            if check(lock, moved_key, N):
                return True
    key = rotate(key, M)
    
    
    for i in range(N+M-1):
        for j in range(N+M-1):
            moved_key = move(key, N, M, i, j)
            if check(lock, moved_key, N):
                return True
    key = rotate(key, M)
    
    
    for i in range(N+M-1):
        for j in range(N+M-1):
            moved_key = move(key, N, M, i, j)
            if check(lock, moved_key, N):
                return True
    key = rotate(key, M)
    
    
    for i in range(N+M-1):
        for j in range(N+M-1):
            moved_key = move(key, N, M, i, j)
            if check(lock, moved_key, N):
                return True
            
    return False