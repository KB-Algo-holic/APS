# PGM 181932 - 코드 처리하기
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181932

def solution(code):
    answer = ''
    mode = 0
    for i in range(len(code)):
        if code[i] == "1":
            mode += 1
            mode %= 2
        else:
            if mode%2 and i%2:
                answer += code[i]
            elif not mode%2 and not i%2:
                answer += code[i]
    if not answer:
        answer = "EMPTY"
    return answer