# PGM - 43163
# BFS
# https://school.programmers.co.kr/learn/courses/30/lessons/43163

from collections import deque

def solution(begin, target, words):
    answer = 0
    length = len(begin)
    l = len(words)
    visited = [0 for _ in range(l+1)]
    
    q = deque([])
    q.append((l, begin, 0))
    
    while q:
        idx, word, cnt = q.popleft()
        visited[idx] = 1
        
        if word == target:
            return cnt
        
        for i in range(l):
            if not visited[i]:
                n = len(word) -1
                check = 0
                # 검사
                while n >= 0:
                    if word[n] != words[i][n]:
                        check += 1
                    n -= 1
                # 이동 가능
                if check == 1:
                    q.append((i, words[i], cnt+1))
    return answer