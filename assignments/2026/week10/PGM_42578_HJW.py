# PGM 42578 - 의상
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42578

def solution(clothes):
    hashmap = dict()
    for c in clothes:
        kind = c[1]
        hashmap[kind] = hashmap.get(kind, 0) + 1
    
    answer = 1
    for value in hashmap.values():
        answer *= value+1
    answer -= 1
    return answer