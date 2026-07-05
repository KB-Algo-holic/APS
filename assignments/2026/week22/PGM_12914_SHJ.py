# PGM 12914 - 멀리뛰기
# 유형: DP심화
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12914

def solution(n):
    MOD = 1234567
    
    a = 1
    b = 2
    
    if n == 1:
        return a
    if n == 2:
        return b
    
    for i in range(3, n + 1):
        a, b = b, (a + b) % MOD
    
    return b
