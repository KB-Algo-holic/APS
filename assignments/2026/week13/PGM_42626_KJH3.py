import heapq

def solution(scoville, K):
    answer = 0

    heapq.heapify(scoville)

    while scoville[0] < K:
        if len(scoville) < 2:
            return -1

        a, b = heapq.heappop(scoville), heapq.heappop(scoville)
        heapq.heappush(scoville, a + (b * 2))

        answer += 1

    return answer