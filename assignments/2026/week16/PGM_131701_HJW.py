# PGM 131701 - 섬 연속 부분 수열 합의 개수
# 유형: 누적합
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/131701

def solution(elements):
    answer = set()
    N = len(elements)
    elements += elements
    for i in range(1, N+1):
        for j in range(N):
            answer.add(sum(elements[j:j+i]))
    return len(answer)