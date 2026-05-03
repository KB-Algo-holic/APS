# PGM 42626 - 더 맵게
# 유형: 우선순위 큐 
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42626


import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    count = 0
    
    while scoville[0] < K:
        if len(scoville) < 2:
            return -1
        
        first = heapq.heappop(scoville)
        second = heapq.heappop(scoville)
        
        mixed = first + second * 2
        heapq.heappush(scoville, mixed)
        count += 1
    
    return count
