# PGM 12927 - 야근 지수
# 유형: 힙
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12927

import heapq

def solution(n, works):
    
    answer = 0
    heap = []
    for work in works:
        heapq.heappush(heap, -1 * work)
        
    for _ in range(n):
        Max = heapq.heappop(heap)
        
        if not Max:
            return 0
        
        Max += 1
        heapq.heappush(heap, Max)
    
    for work in heap:
        answer += work**2
    
    return answer