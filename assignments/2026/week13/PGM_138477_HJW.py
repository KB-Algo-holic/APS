# PGM 138477 - 명예의 전당 (1)
# 유형: 우선 순위 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/138477

from heapq import heappop, heappush

def solution(k, score):
    answer = []
    heap = []
    for s in score:
        if len(heap) < k:
            heappush(heap, s)
        else:
            if heap[0] < s:
                heappop(heap)
                heappush(heap, s)
        answer.append(heap[0])
    return answer