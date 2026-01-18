# PGM 12904 - 가장 긴 팰린드롬
# 유형: 문자열
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/12904

def solution(s):
    
    for size in range(len(s), -1, -1):
        for i in range(len(s)-size+1):
            tmp = s[i:i+size]
            if tmp == tmp[::-1]:
                return size