import heapq

class Solution:
    def lastStoneWeight(self, stones: List[int]) -> int:
        if len(stones) == 1:
            return stones[0]

        weight = []

        for s in stones:
            heapq.heappush(weight, -s)

        while len(weight) > 1:
            x = -heapq.heappop(weight)
            y = -heapq.heappop(weight)

            if x == y:
                continue

            heapq.heappush(weight, -abs(x - y))

        return -weight[0] if len(weight) > 0 else 0