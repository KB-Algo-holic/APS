def solution(n, times):
    answer = 0

    left = min(times)
    right = max(times) * n
    mid = 0
    while left <= right:
        mid = (left + right) // 2

        people = 0
        for time in times:
            people += mid // time

        if n <= people:
            right = mid - 1
            answer = mid

        elif n > people:
            left = mid + 1

    return answer