# LC 1046 - Last Stone Weight
# 유형: 우선 순위 큐
# 링크: https://leetcode.com/problems/last-stone-weight/

from heapq import heappush, heappop

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        heap = []
        for stone in stones:
            heappush(heap, -stone)
        
        while len(heap) > 1:
            y, x = -heappop(heap), -heappop(heap)
            if x == y:
                continue
            heappush(heap, -(y-x))
        
        if heap:
            return -heap[0]
        return 0