# LC 1845 - Seat Reservation Manager
# 유형: 우선 순위 큐
# 링크: https://leetcode.com/problems/seat-reservation-manager/

from heapq import heappush, heappop

class SeatManager:

    def __init__(self, n: int):
        self.heap = []
        for i in range(1, n+1):
            heappush(self.heap, i)

    def reserve(self) -> int:
        return heappop(self.heap)

    def unreserve(self, seatNumber: int) -> None:
        heappush(self.heap, seatNumber)


# Your SeatManager object will be instantiated and called as such:
# obj = SeatManager(n)
# param_1 = obj.reserve()
# obj.unreserve(seatNumber)