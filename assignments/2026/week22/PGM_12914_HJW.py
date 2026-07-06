# PGM 12914 - 멀리 뛰기
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12914

def solution(n):
    arr = [0] * (n+1)
    arr[1] = 1
    if n >= 2:
        arr[2] = 2
    for i in range(3, n+1):
        arr[i] = (arr[i-2] + arr[i-1]) % 1234567
    answer = arr[n]
    return answer