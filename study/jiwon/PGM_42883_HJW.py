# PGM 42883 - 큰 수 만들기
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42883

def solution(number, k):
    number = list(number)
    stack = []
    for num in number:
        if not stack:
            stack.append(num)
            continue
        
        while stack and k and stack[-1] < num:
            stack.pop()
            k -= 1
        
        stack.append(num)
    if k:
        stack.pop()
    return ''.join(stack)