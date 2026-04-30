# PGM 42626 - 더 맵게
# 유형: 우선순위 큐 min heap
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626
import heapq
def solution(scoville, K):
    answer = 0
    s = scoville
    heapq.heapify(s)
    while True:
        first = heapq.heappop(s)
        if first >=K:
            break
        if len(s) == 0:
            answer = -1;
            break
        second = heapq.heappop(s)
        composite = first + second * 2
        heapq.heappush(s, composite)
        answer = answer + 1
    
    return answer
    