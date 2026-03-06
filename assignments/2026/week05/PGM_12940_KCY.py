# PGM 12940 - 최대공약수와 최소공배수
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12940

def solution(n, m):
    check = min(n, m)
    answer = []

    for i in range(check, 0, -1):
        if n % i == 0 and m % i == 0:
            answer.append(i)
            answer.append(i * n/i * m/i)
            break
    return answer