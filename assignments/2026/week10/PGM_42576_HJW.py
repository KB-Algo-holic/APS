# PGM 42576 - 완주하지 못한 선수
# 유형: 해시
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42576

def solution(participant, completion):
    tmp = dict()
    for i in range(len(participant)):
        if participant[i] in tmp:
            tmp[participant[i]] += 1
        else:
            tmp[participant[i]] = 1
    for i in range(len(completion)):
        tmp[completion[i]] -= 1
    for key in tmp:
        if tmp[key] != 0:
            answer = key
    return answer