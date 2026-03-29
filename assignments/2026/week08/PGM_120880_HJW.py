# PGM 120880 - 특이한 정렬
# 유형: 정렬
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/120880

def solution(numlist, n):
    return sorted(numlist, key=lambda x:(abs(x-n), n-x))