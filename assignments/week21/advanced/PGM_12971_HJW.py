# PGM 12971 - 스티커 모으기(2)
# 유형: DP
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12971

def solution(sticker):
    if len(sticker) <= 2:
        return max(sticker)
    
    N = len(sticker)-1
    DP1 = [0] * N
    DP2 = [0] * N
    
    DP1[0] = sticker[0]
    DP1[1] = max(sticker[0], sticker[1])
    for i in range(2, N):
        DP1[i] = max(DP1[i-1], DP1[i-2]+sticker[i])
    
    DP2[0] = sticker[1]
    DP2[1] = max(sticker[1], sticker[2])
    for i in range(2, N):
        DP2[i] = max(DP2[i-1], DP2[i-2]+sticker[i+1])
    
    return max(DP1[N-1], DP2[N-1])