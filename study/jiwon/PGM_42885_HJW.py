# PGM 42885 - 구명보트
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42885

from collections import deque

def solution(people, limit):
    answer = 0
    people.sort()
    queue = deque(people)

    weight = 0
    while queue:
        if len(queue) >= 2:
            if queue[0] + queue[-1] <= limit:
                answer += 1
                queue.pop()
                queue.popleft()
            else:
                answer += 1
                queue.pop()

        else:
            answer += 1
            queue.pop()

    return answer