# PGM 12938 - 최고의 집합
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12938

from collections import deque

def solution(n, s):
    if n > s:
        return [-1]
    
    target = s // n
    answer = deque([target]*n)
    Sum = target*n
    while Sum < s:
        answer.appendleft(answer.pop()+1)
        Sum += 1
    
    answer = list(answer)
    answer.sort()
    return answer