# PGM 77885 - 2개 이하로 다른 비트
# 유형: 문자열
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/77885

def solution(numbers):
    answer = []
    for num in numbers:
        x = bin(num)[2:][::-1]
        if x[0] == '0':
            x = (x.replace('0', '1', 1) + 'b0')[::-1]
        elif '10' in x:
            x = (x.replace('10', '01', 1) + 'b0')[::-1]
        else:
            x = '0b10' + x[1:]
        answer.append(int(x, 2))
    return answer