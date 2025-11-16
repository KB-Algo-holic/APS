# PGM 388352 - 비밀 코드 해독
# 유형: 조합
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/388352

from itertools import combinations

def intersection(A, B):
    res, i, j = 0, 0, 0
    
    while i < 5 and j < 5:
        if A[i] == B[j]:
            res += 1
            i += 1
            j += 1
        
        elif  A[i] > B[j]:
            j += 1
        
        else:
            i += 1
    
    return res

def solution(n, q, ans):
    answer = 0
    m = len(q)
    for target in combinations([i for i in range(1, n+1)], 5):
        for i in range(m):
            if intersection(target, q[i]) != ans[i]:
                break
        else:
            answer += 1
                
    return answer