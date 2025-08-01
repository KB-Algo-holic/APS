# PGM 12945 - 피보나치 수
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12945

def solution(n):
    arr = [1] * n
    for i in range(2, n):
        arr[i] = (arr[i-1] + arr[i-2]) % 1234567
    return arr[n-1]