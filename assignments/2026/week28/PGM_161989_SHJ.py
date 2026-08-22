# PGM 161989 - 덧칠하기
# 유형: 이분탐색, 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/161989


def solution(n, m, section):
    answer = 0
    end = 0

    for s in section:
        if s > end:
            answer += 1
            end = s + m - 1

    return answer
