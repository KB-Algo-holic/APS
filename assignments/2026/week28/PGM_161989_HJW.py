# PGM 161989 - 덧칠하기
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/161989

def solution(n, m, section):
    answer = 0
    while section:
        target = section[-1]
        answer += 1
        while section and section[-1] > target-m:
            section.pop()
            
    return answer