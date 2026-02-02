# PGM 12940 - 최대공약수와 최소공배수
# 유형: 정수론
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12940

def gcd(a, b):
    if b > a:
        a, b = b, a
    while b:
        a, b = b, a%b
        
    return a

def solution(n, m):
    answer = []
    d = gcd(n, m)
    answer = [d, n*m//d]

    return answer