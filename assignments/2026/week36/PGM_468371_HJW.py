# PGM 468371 - 노란불 신호등
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/468371

def solution(signals):
    answer = -1
    n = len(signals)
    DP = [0] * 3200001
    for g,y,r in signals:
        cycle = g + y + r
        time = g+1
        while time < 3200001:
            for i in range(y):
                point = time+i
                if point < 3200001:
                    DP[point] += 1
                    if DP[point] == n:
                        return point
            time += cycle
            
    return answer