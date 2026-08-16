# PGM 42860 - 조이스틱
# 유형: 그리디
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42860

Min = 30

def get_idx(idx, n):
    return (idx-1)%n, (idx+1)%n

def get_count_alpha_to_a(digit):
    res = ord(digit)-ord('A')
    return min(res, 26-res)

def is_all_visit(visited):
    for key, value in visited.items():
        if not value:
            return False
    return True

def dfs(idx, step, visited, n, name):
    
    global Min
    
    if step > Min:
        return
    
    if idx in visited.keys():
        visited[idx] += 1
        
    if is_all_visit(visited):
        if step < Min:
            Min = step
        
        if idx in visited.keys():
            visited[idx] -= 1
            
        return
    
    left, right = get_idx(idx, n)
    dfs(left, step+1, visited, n, name)
    dfs(right, step+1, visited, n, name)
    
    if idx in visited.keys():
        visited[idx] -= 1
    
def solution(name):
    answer = 0
    n = len(name)
    visited = dict()
    for i in range(n):
        if name[i] != 'A':
            visited[i] = 0
        answer += get_count_alpha_to_a(name[i])
    
    dfs(0, 0, visited, n, name)
    answer += Min
    return answer