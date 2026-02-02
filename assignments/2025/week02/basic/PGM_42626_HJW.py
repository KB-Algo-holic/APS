# PGM 42626 - 더 맵게
# 유형: 우선순위큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626

import heapq

def check(heap, K):
    for food in heap:
        if food < K:
            return False
    return True

def solution(scoville, K):
    heap = []
    for food in scoville:
        heapq.heappush(heap, food)
    tmp = 0
    answer = 0
    while not check(heap, K):
        food1 = heapq.heappop(heap)
        food2 = heapq.heappop(heap)
        tmp = food1 + 2 * food2
        heapq.heappush(heap, tmp)
        answer += 1
        if len(heap) < 2 and not check(heap, K):
            answer = -1
            break
    return answer