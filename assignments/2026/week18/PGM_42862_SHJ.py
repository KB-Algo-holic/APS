# PGM 42862 - 체육복
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42862

def solution(n, lost, reserve):
    lost_set = set(lost)
    reserve_set = set(reserve)

    common = lost_set & reserve_set
    lost_set -= common
    reserve_set -= common

    answer = n - len(lost_set)

    for r in sorted(reserve_set):
        if r - 1 in lost_set:
            lost_set.remove(r - 1)
            answer += 1

        elif r + 1 in lost_set:
            lost_set.remove(r + 1)
            answer += 1

    return answer
