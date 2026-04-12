# PGM - 42578 의상
# 해쉬
# https://school.programmers.co.kr/learn/courses/30/lessons/42578?language=python3

def solution(clothes):
    answer = 1
    clothes_by_type = {}
    for clothe in clothes:
        clothes_by_type[clothe[1]] = clothes_by_type.get(clothe[1], 1)+1

    for value in clothes_by_type.values():
        answer *= value

    return answer-1