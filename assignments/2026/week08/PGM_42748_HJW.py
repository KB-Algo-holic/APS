# PGM 42748 - K번째수
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42748

def cutsortnum(array, i, j, k):
    tmp = array[i-1:j]
    tmp.sort()
    return tmp[k-1]

def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        tmp = commands[i]
        answer.append(cutsortnum(array, tmp[0], tmp[1], tmp[2]))
    return answer