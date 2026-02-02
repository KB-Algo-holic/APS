# PGM 148653 - 마법의 엘리베이터
# 유형: 수학
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/148653

def solution(storey):
    answer = 0
    while storey:
        rest = storey % 10
        storey //= 10
        if rest >= 6:
            rest = 10 - rest
            storey += 1
        elif rest == 5:
            if storey % 10 >= 5:
                storey += 1
        answer += rest
    return answer