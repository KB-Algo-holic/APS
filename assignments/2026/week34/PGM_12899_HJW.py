# PGM 12899 - 124 나라의 숫자
# 유형: 문자열
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12899

def nto3(n):
    res = ''
    while n:
        res += str(n%3)
        n //= 3
    return res

def delzero(n):
    num = list(n)
    flag = True
    for i in range(len(num)):
        if num[i] == '0' and i+1 < len(num):
            flag = False
            idx = i+1
            while True:
                if num[idx] == '0':
                    idx += 1
                elif num[idx] == '1':
                    num[idx] = '0'
                    break
                elif num[idx] == '2':
                    num[idx] = '1'
                    break
                elif num[idx] == '4':
                    num[idx] = '2'
                    break
            num[idx-1] = '4'
            break
            
    return ''.join(num), flag
                    
def solution(n):
    answer = ''
    answer = nto3(n)
    answer, flag = delzero(answer)
    while True:
        answer, flag = delzero(answer)
        if flag:
            break
    return answer[::-1].lstrip('0')