# PGM 84512 - 모음사전
# 유형: 완전탐색 / 규칙 찾기
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/84512

def solution(word):
    vowels = "AEIOU"
    weights = [781, 156, 31, 6, 1]

    answer = 0

    for i, char in enumerate(word):
        answer += vowels.index(char) * weights[i] + 1

    return answer
