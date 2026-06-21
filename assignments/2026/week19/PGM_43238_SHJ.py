# PGM 43238 - 입국심사
# 유형: 이분탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43238

def solution(n, times):
    left = 1
    right = min(times) * n
    answer = right

    while left <= right:
        mid = (left + right) // 2

        people = 0
        for time in times:
            people += mid // time

        if people >= n:
            answer = mid
            right = mid - 1
        else:
            left = mid + 1

    return answer
