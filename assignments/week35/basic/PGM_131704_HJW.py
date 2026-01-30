# PGM 131704 - 택배상자
# 유형: 큐/스택
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131704

from collections import deque

def solution(order):
    answer = 0
    
    stack = []
    queue = deque()
    
    for i in range(1, len(order)+1):
        queue.append(i)
    
    for num in order:
        
        flag = 1
        while True:
            if queue and queue[0] == num:
                queue.popleft()
                answer += 1
                break
            
            if stack and stack[-1] == num:
                stack.pop()
                answer += 1
                break
            
            if queue and queue[0] < num:
                stack.append(queue.popleft())
            
            else:
                flag = 0
                break
        
        if not flag:
            break
    
    return answer