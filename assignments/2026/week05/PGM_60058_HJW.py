# PGM 60058 - 괄호 변환
# 유형: 스택, 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/60058

def is_balance(string):
    
    res = 0
    for c in string:
        if c == '(':
            res += 1
        else:
            res -= 1
    
    if res:
        return False
    return True

def is_correct(string):
    
    stack = []
    for c in string:
        if c == '(':
            stack.append(c)
        else:
            if not stack:
                return False
            stack.pop()
    
    if stack:
        return False
    return True

def get_reverse(string):
    
    res = ""
    for c in string:
        if c == '(':
            res += ')'
        else:
            res += '('
    
    return res

def solution(p):
    
    if not p:
        return p
    
    if is_correct(p):
        return p
        
    u, v = p[:2], p[2:]
    while not is_balance(u):
        u += v[:2]
        v = v[2:]
        
    if is_correct(u):
        return u + solution(v)
    
    return '(' + solution(v) + ')' + get_reverse(u[1:-1])