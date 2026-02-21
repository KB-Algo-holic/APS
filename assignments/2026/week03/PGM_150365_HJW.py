# PGM 150365 - 미로 탈출 명령어
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/150365

def solution(n, m, x, y, r, c, k):
    
    answer = ''
    step = get_step(x, y, r, c)
    
    K = k-step
    if K < 0 or K%2:
        return 'impossible'
    
    while k != get_step(x, y, r, c):
        if x < n:
            answer += 'd'
            x += 1
            k -= 1
        elif y > 1:
            answer += 'l'
            y -= 1
            k -= 1
        elif y < m:
            answer += 'rl'
            k -= 2
    
    while not (x == r and y == c):      
        if x < r:
            answer += 'd'
            x += 1
        elif y > c:
            answer += 'l'
            y -= 1
        elif y < c:
            answer += 'r'
            y += 1
        elif x > r:
            answer += 'u'
            x -= 1
    
    return answer

def get_step(x, y, r, c):
    return abs(x-r) + abs(y-c)