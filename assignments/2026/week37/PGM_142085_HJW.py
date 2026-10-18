# PGM 142085 - 디펜스 게임
# 유형: 우선순위 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/142085

import heapq

def solution(n, k, enemy):
    answer = len(enemy)
    
    dp = [0] * len(enemy)
    target = [enemy[0]]
    heapq.heapify(target)
    dp[0] = enemy[0]
    Sum = sum(target)
    
    for i in range(1, len(enemy)):
        num = enemy[i]
        
        if len(target) < k:
            heapq.heappush(target, num)
            Sum += num
        else:
            Min = heapq.heappop(target)
            
            if Min < num:
                heapq.heappush(target, num)
                Sum -= Min
                Sum += num
            else:
                heapq.heappush(target, Min)
        
        dp[i] = enemy[i] + dp[i-1]
        
        if dp[i] - Sum > n:
            answer = i
            break
    
    return answer