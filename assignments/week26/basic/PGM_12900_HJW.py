# PGM 12900 - 2 x n 타일링
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12900

def solution(n):
    arr = [0] * 60001
    arr[1], arr[2] = 1, 2
    for i in range(3, n+1):
        arr[i] = (arr[i-1] + arr[i-2]) % 1000000007
    return arr[n]