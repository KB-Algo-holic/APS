# PGM 42628 - 이중우선순위큐
# 유형: 우선 순위 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42628

from heapq import heappush, heappop

def solution(operations):
    answer = [0, 0]
    heap = []
    
    for op in operations:
        c, num = op.split()
        num = int(num)
        
        if c == 'I':
            heappush(heap, num)
        
        else:
            if heap:
                if num == -1:
                    heappop(heap)
                else:
                    heap.remove(max(heap))
    
    if heap:
        answer = [max(heap), min(heap)]
        
    return answer