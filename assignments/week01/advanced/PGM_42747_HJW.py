# PGM 42747 - H-Index
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42747

def solution(citations):
    answer = 0
    citations.sort(reverse=True)

    for i in range(len(citations)):
        h = citations[i]
        if len(citations[:i+1]) <= h:
            answer = len(citations[:i+1])
    return answer