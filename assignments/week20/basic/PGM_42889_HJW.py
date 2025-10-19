# PGM 42889 - 실패율
# 유형: DP, 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42889

def solution(N, stages):
    answer = []
    success = [0] * (N+2)
    for stage in stages:
        success[stage] += 1
    DP = [0] * (N+2)
    DP[N+1] = success[N+1]
    for i in range(N, 0, -1):
        DP[i] = DP[i+1] + success[i]
    fail_rate = []
    for i in range(1, N+1):
        if DP[i]:
            value = success[i] / DP[i]
            fail_rate.append([i, value])
        else:
            fail_rate.append([i, 0])
    fail_rate.sort(key=lambda x:x[1], reverse=True)
    for fail in fail_rate:
        answer.append(fail[0])
    return answer