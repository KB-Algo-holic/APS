# PGM 43238 - 입국 심사
# 유형: 이분 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43238

def solution(n, times):

    start, end = 1, 1000000000 ** 2

    while start < end:
        mid = (start + end) // 2

        tmp = 0
        for time in times:
            tmp += mid // time
        
        if tmp >= n:
            end = mid
        
        else:
            start = mid + 1

    return start