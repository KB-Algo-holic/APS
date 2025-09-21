# PGM 12923 - 숫자 블록
# 유형: 수학
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12923

def get_divider(n):
    res = 1
    if  n == 1:
        return 0
    for i in range(2, int(n**0.5)+1):
        if not n%i:
            if i > res:
                res = i
            if n//i <= 10000000:
                if n//i > res:
                    res = n//i
    return res

def solution(begin, end):
    answer = [1] * (end - begin + 1)
    for i in range(end-begin+1):
        n = begin+i
        answer[i] = get_divider(n)
    return answer