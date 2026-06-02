# PGM 42842 - 카펫
# 유형: 완전 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42842

def solution(brown, yellow):
    answer = []
    for i in range(1, yellow + 1):
        if yellow % i == 0:
            width = yellow / i
            tmp = width + width + i + 2 + i + 2
            if tmp == brown:
                answer = [int(width) + 2, i + 2]
                break
    return answer