# PGM 12924 - 숫자의 표현
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12924

def solution(n):
    answer = 0
    
    arr = [0] * 10001
    for i in range(1, 10001):
        arr[i] = i*(i+1)//2
    for i in range(1, n+1):
        for j in range(i-1, -1, -1):
            if arr[i] - arr[j] == n:
                answer += 1
            if arr[i] - arr[j] > n:
                break
    
    return answer