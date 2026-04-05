# PGM 12909 - 올바른 괄호
# 유형: 문자열
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12909?language=python3

def solution(s):
    answer = True
    count = 0

    for ch in s:
        if ch == '(':
            count += 1
        else:
            count -= 1

        if count < 0:
            answer = False
            break

    if count != 0:
        answer = False

    return answer
