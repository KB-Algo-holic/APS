# PGM 42627 - 디스크 컨트롤러
# 유형: 우선순위큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42627

from collections import deque
from heapq import heappush, heappop

def solution(jobs):
    answer = 0
    jobs.sort(key=lambda x:(x[0], x[1]))
    queue = deque(jobs)
    cnt = 0
    time = 0
    heap = []
    left = 0
    
    while queue or heap:
        while queue and queue[0][0] == time:
            job = queue.popleft()
            heappush(heap, [job[1], job[0], cnt])
            cnt += 1
        
        if not left and heap:
            job = heappop(heap)
            answer += job[0] + time - job[1]
            left = job[0]
        
        time += 1
        if left:
            left -= 1
        
    return answer//len(jobs)