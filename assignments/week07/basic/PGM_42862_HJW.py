# PGM 42862 - 체육복
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862

def solution(n, lost, reserve):
    answer = 0
    
    arr = [1] * (n+2)
    arr[0] = 0
    arr[n+1] = 0
    
    for l in lost:
        arr[l] = 0
    for r in reserve:
        arr[r] += 1
    
    for i in range(1, n+1):
        if arr[i] == 0:
            if arr[i-1] == 2:
                arr[i-1] -= 1
                arr[i] += 1
            elif arr[i+1] == 2:
                arr[i+1] -= 1
                arr[i] += 1
    
    for i in range(1, n+1):
        if arr[i]:
            answer += 1
            
    return answer