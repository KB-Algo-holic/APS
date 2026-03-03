# PGM 181926 - 수 조작하기 1
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181926

def solution(n, control):
    x = {"w":1,"s":-1,"d":10,"a":-10}
    for c in control:
        n += x.get(c)
    return n