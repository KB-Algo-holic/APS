# PGM 131127 - 할인 행사
# 유형: 큐
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131127

from collections import deque

def isOk(count):
    
    for value in count.values():
        if value > 0:
            return False
    
    return True

def solution(want, number, discount):
    answer = 0
    
    count = {}
    for i in range(len(want)):
        count[want[i]] = number[i]
    queue = deque()
    discount = deque(discount)
    
    for _ in range(10):
        item = discount.popleft()
        queue.append(item)
        if item in count:
            count[item] -= 1
    
    if isOk(count):
        answer += 1
    
    while discount:
        item = queue.popleft()
        if item in count:
            count[item] += 1
        
        item = discount.popleft()
        if item in count:
            count[item] -= 1
        queue.append(item)
        
        if isOk(count):
            answer += 1
    
    return answer