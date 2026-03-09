# PGM 120921 - 문자열 밀기
# 유형: 문자열
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120921

def solution(A, B):
    answer = 0
    while answer < len(A):
        if A == B:
            break
        A = A[-1] + A[:-1]
        answer += 1
    
    if answer == len(A):
        answer = -1
    return answer