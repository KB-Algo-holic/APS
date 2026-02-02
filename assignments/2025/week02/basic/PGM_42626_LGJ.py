# PGM 42626 - 더 맵게
# 유형: 우선순위 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626


import heapq

def solution(scoville, K):
    answer = 0
    heapq.heapify(scoville)
    
    while scoville[0] < K:
        if len(scoville) < 2:
            answer = -1
            return answer

        min_1 = heapq.heappop(scoville)
        min_2 = heapq.heappop(scoville)

        new = min_1 + min_2*2
        heapq.heappush(scoville, new)

        answer += 1
    return answer