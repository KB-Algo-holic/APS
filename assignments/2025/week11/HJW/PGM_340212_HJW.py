# PGM 340212 - 퍼즐 게임 챌린지
# 유형: 이진탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340212

def get_time(mid, diffs, times):
    time = 0
    for i in range(len(diffs)):
        if diffs[i] <= mid:
            time += times[i]
        else:
            time += (times[i-1] + times[i]) * (diffs[i] - mid) + times[i]
    return time

def solution(diffs, times, limit):
    
    start, end = 1, 10**15
    N = len(diffs)
    while start <= end:
        mid = (start + end) // 2
        time = get_time(mid, diffs, times)
            
        if limit < time:
            start = mid+1
        else:
            end = mid-1
    
    if (get_time(mid, diffs, times) > limit):
        mid += 1
    
    return mid