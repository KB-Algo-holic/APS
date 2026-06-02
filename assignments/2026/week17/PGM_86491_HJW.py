# PGM 86491 - 최소직사각형
# 유형: 완전 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/86491

def solution(sizes):
    answer = 0
    w, h = 0, 0
    for size in sizes:
        w_, h_ = size[0], size[1]
        if h_ > w_:
            w_, h_ = h_, w_
        if w_ > w:
            w = w_
        if h_ > h:
            h = h_
    answer = w*h
    return answer