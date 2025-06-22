# PGM 12909 - 올바른 괄호
# 유형: 스택
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909


def solution(s):
    stack = []
    
    for ch in s:
        if ch == ")":
            if not stack:
                return False
            stack.pop()
        else:
            stack.append("(")

    return not stack