# PGM 12906 - 같은 숫자는 싫어
# 유형: 스택
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12906

def solution(arr):
    answer = []
    last = -1
    for num in arr:
        if num == last:
            continue
        answer.append(num)
        last = num
    return answer