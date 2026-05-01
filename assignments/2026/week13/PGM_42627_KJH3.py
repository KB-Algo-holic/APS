import heapq

def solution(jobs):
    jobs.sort()

    wait_heap = []
    now = 0
    i = 0
    count = 0
    avg_time = 0

    while count < len(jobs):
        while i < len(jobs) and jobs[i][0] <= now:
            heapq.heappush(wait_heap, [jobs[i][1], jobs[i][0]])
            i += 1

        if wait_heap:
            duration, start = heapq.heappop(wait_heap)
            now += duration
            avg_time += (now - start)
            count += 1
        else:
            now = jobs[i][0]

    return avg_time // len(jobs)