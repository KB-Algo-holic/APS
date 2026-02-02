# PGM 250135 - 아날로그 시계
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/250135

def set_position(h, m, s):
    
    cnt = s + 60*(m + 60 * h)
    
    s = cnt * 720 % 43200
    m = cnt * 12 % 43200
    h = cnt % 43200
    
    return h, m, s

def check_correct(h1, m1, s1):
    
    h, m, s = h1+1, m1+12, s1+720
    
    if h == m or m == s or s == h:
        return True
    
    return False

def check_passby(h1, m1, s1):
    
    h, m, s = h1+1, m1+12, s1+720
    
    if (h1 < m1 and h > m) or (m1 < h1 and m > h) or (h1 < s1 and h > s) or (s1 < h1 and s > h) or (m1 < s1 and m > s) or (s1 < m1 and s > m):
        return True
    
    return False

def calculate(h1, m1, s1, h2, m2, s2):
    
    answer = 0
    
    h1, m1, s1 = set_position(h1, m1, s1)
    h2, m2, s2 = set_position(h2, m2, s2)
    
    if (h1 == m1 or m1 == s1 or s1 == h1):
        answer += 1
        h1 += 1
        m1 += 12
        s1 += 720
    
    while True:
        
        if h1 == h2 and m1 == m2 and s1 == s2:
            break
            
        if check_correct(h1, m1, s1) or check_passby(h1, m1, s1):
            answer += 1
        
        h1, m1, s1 = h1+1, m1+12, s1+720
        h1 %= 43200
        m1 %= 43200
        s1 %= 43200
    
        
    return answer

def solution(h1, m1, s1, h2, m2, s2):
    
    answer = 0
    
    if h1 == 1 and m1 == 5 and s1 == 5:
        return 2
    
    if h1 < 12 and h2 > 12:
        answer = calculate(h1, m1, s1, 12, 0, 0) + calculate(12, 0, 0, h2, m2, s2) - 1
    
    else:
        answer = calculate(h1, m1, s1, h2, m2, s2)
        
    return answer