# PGM 340210 - 수식 복원하기
# 유형: 완전탐색, 시뮬레이션
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340210

def plus(A, B, base):
    res = ''
    A = list(A)[::-1]
    B = list(B)[::-1]
    carry = '0'
    for i in range(3):
        if i < len(A):
            a = A[i]
        else:
            a = '0'
        if i < len(B):
            b = B[i]
        else:
            b = '0'
        
        value = int(a) + int(b) + int(carry)
        if value >= base:
            carry = '1'
            value -= base
        else:
            carry = '0'
        res += str(value)
    
    res = res.rstrip('0')[::-1]
    if not res:
        res = '0'
    return res

def minus(A, B, base):
    
    res = ''
    A = list(A)[::-1]
    B = list(B)[::-1]
    for i in range(2):
        if i < len(A):
            a = int(A[i])
        else:
            a = 0
        if i < len(B):
            b = int(B[i])
        else:
            b = 0
        
        if a < b:
            A[i+1] = str(int(A[i+1])-1)
            a += base
        value = a - b
        res += str(value)
    
    res = res.rstrip('0')[::-1]
    if not res:
        res = '0'
    return res

def check_digit(A, B, base):
    for digit in A:
        if int(digit) >= base:
            return False
    for digit in B:
        if int(digit) >= base:
            return False
    return True

def solution(expressions):
    
    answer = []
    
    exp, res = [], []
    for expression in expressions:
        e, r = map(str, expression.split(' = '))
        if '+' in e:
            A, B = map(str, e.split(' + '))
            exp.append([A, B, '+'])
        else:
            A, B = map(str, e.split(' - '))
            exp.append([A, B, '-'])
        res.append(r)

    potentials = [1] * 10
    for base in range(2, 10):
        if potentials[base]:
            for i in range(len(res)):
                A, B, op = exp[i][0], exp[i][1], exp[i][2]
                if not check_digit(A, B, base):
                    potentials[base] = 0
                    break
                if res[i] != 'X':
                    if op == '+':
                        value = plus(A, B, base)
                    else:
                        value = minus(A, B, base)

                    if value != res[i]:
                        potentials[base] = 0

    for i in range(len(res)):
        if res[i] == 'X':
            A, B, op = exp[i][0], exp[i][1], exp[i][2]
            state = f'{A} {op} {B} = '
            candidates = set()
            for base in range(2, 10):
                if potentials[base]:
                    if op == '+':
                        value = plus(A, B, base)
                    else:
                        value = minus(A, B, base)
                    candidates.add(value)
            if len(candidates) == 1:
                state += value
            else:
                state += '?'
            answer.append(state)
    return answer