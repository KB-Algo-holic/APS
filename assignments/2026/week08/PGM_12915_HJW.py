# PGM 12915 - 문자열 내 마음대로 정렬하기
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12915

def solution(strings, n):
    answer = sorted(strings, key=lambda x:(x[n], x))
    return answer