# PGM 67257 - 수식 최대화
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67257

from collections import deque
from itertools import permutations

ops = ("+", "-", "*")

def cal(a, o, b):
    
    if o == "+":
        return a + b

    if o == "-":
        return a - b
    
    if o == "*":
        return a * b

def solution(exp):
    answer = 0
    res = []
    exp = deque(exp)
    tmp = ""
    while exp:
        digit = exp.popleft()
        if digit in ops:
            res.append(int(tmp))
            res.append(digit)
            tmp = ""
            continue
        tmp += digit
    res.append(int(tmp))
    
    for op in permutations(ops):
        queue = deque(res)
        queue2 = deque()
        
        for o in op:
            while queue:
                if queue[0] in ops and queue[0] == o:
                    x = queue.popleft()
                    queue2.append(cal(queue2.pop(), x, queue.popleft()))
                    continue
                queue2.append(queue.popleft())
            
            queue = queue2
            queue2 = deque()
        
        num = abs(queue.popleft())
        if num > answer:
            answer = num
    
    return answer