# PGM 12909 - 올바른 괄호
# 유형: 스택
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909

def solution(s):
    cnt = 0
    for c in s:
        if c == '(':
            cnt += 1
        else:
            if cnt == 0:
                return False
            cnt -= 1
    return cnt == 0