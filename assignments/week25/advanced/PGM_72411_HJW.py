# PGM 72411 - 메뉴 리뉴얼
# 유형: 조합
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/72411

from itertools import combinations

def solution(orders, course):
    answer = []
    
    for c in course:
        tmp = dict()
        for order in orders:
            o = list(order)
            o.sort()
            for d in combinations(o, c):
                s = ''.join(d)
                tmp[s] = tmp.get(s, 0) + 1
        
        Max = max(tmp.values()) if tmp.values() else 0
        for key in tmp:
            if Max > 1 and tmp[key] == Max:
                answer.append(key)
    
    answer.sort()
    return answer