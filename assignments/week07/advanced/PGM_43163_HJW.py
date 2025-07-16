# PGM 43163 - 단어 변환
# 유형: BFS
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/43163

from collections import deque

def possible(a, b):
    length = len(a)
    result = 0
    for i in range(length):
        if a[i] != b[i]:
            result += 1
    
    if result == 1:
        return True
    else:
        return False

def solution(begin, target, words):

    length = len(words)

    for _ in range(length):
        if words[_] == target:
            target_index = _ + 1
            break
        target_index = 0

    possibilities = [[] for _ in range(length+1)]
    
    for i in range(length):
        for j in range(length):
            if i != j:
                from_ = words[i]
                to_ = words[j]
                if possible(from_, to_):
                    possibilities[i+1].append(j+1)
    
    for i in range(length):
        if possible(begin, words[i]):
            possibilities[0].append(i+1)

    visited = [0] * (length + 1)

    queue = deque()
    queue.append([0,0])
    visited[0] = 1

    while queue:
        node = queue.popleft()
        index = node[0]
        step = node[1]
        if index == target_index:
            return step

        for v in possibilities[index]:
            if visited[v] == 0:
                queue.append([v, step+1])
                visited[v] = 1
    
    return 0