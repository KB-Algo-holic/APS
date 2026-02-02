# PGM 12947 - 하샤드 수
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12947

def solution(x):
    answer = True
    Sum = 0
    tmp = x
    while tmp > 0:
        Sum += tmp%10
        tmp //= 10
    if x%Sum:
        answer = False
    return answer