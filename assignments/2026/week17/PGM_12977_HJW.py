# PGM 12977 - 소수 만들기
# 유형: 완전 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12977

def get_sieve():
    
    res = [1] * 3000
    res[0] = 0
    res[1] = 0
    
    for i in range(4, 3000, 2):
        res[i] = 0
    for i in range(3, 3000, 2):
        if res[i]:
            for j in range(2*i, 3000, i):
                res[j] = 0
    
    return res

def solution(nums):
    
    answer = 0

    sieve = get_sieve()
    N = len(nums)
    
    for i in range(N-2):
        for j in range(i+1, N-1):
            for k in range(j+1, N):
                if sieve[nums[i]+nums[j]+nums[k]]:
                    answer += 1

    return answer