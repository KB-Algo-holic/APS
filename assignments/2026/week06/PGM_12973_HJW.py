# PGM 12973 - 짝지어 제거하기
# 유형: 스택
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12973

def solution(s):
    answer = 0
    
    stack = []
    
    for c in s:
        if not stack:
            stack.append(c)
            
        elif stack[-1] == c:
            stack.pop()
        
        else:
            stack.append(c)
    
    if not stack:
        answer = 1

    return answer