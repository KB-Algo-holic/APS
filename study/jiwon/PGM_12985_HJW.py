# PGM 12985 예상대진표
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12985

def solution(n, a, b):

    answer = 0
    while a != b:
        
        answer += 1
        
        a = int((a+1)/2)
        b = int((b+1)/2)

    return answer