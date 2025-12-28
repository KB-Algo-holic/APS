# PGM 76502 - 괄호 회전하기
# 유형: 큐/스택
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/76502

from collections import deque

collect = {
    '}': '{',
    ']': '[',
    ')': '('
}

def det(s):
    stack = []
    
    s = deque(list(s))
    
    while s:
        a = s.popleft()
        if a in ['{', '[', '(']:
            stack.append(a)
        else:
            if not stack:
                return False
            
            if collect[a] != stack[-1]:
                return False
            
            stack.pop()
    if stack:
        return False
    
    return True

def solution(s):
    answer = 0
    
    queue = deque(list(s))
    
    cnt = 0
    while cnt < len(queue):    
        if det(queue):
            answer += 1
        
        queue.append(queue.popleft())
        cnt += 1
        
    return answer