# PGM 42860 - 조이스틱
# 유형: 그리디/DFS/구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/42860

Min = 0

def change(B):
    a, b = ord('A'), ord(B)
    
    return min(abs(a-b), 26-(abs(a-b)))

def right(cursor, N):
    cursor += 1
    cursor %= N
    
    return cursor

def left(cursor, N):
    cursor -= 1
    cursor %= N
    
    return cursor

def dfs(idx, N, name, visited, step):
    
    global Min
    
    if step > N+2:
        return
    
    flag = True
    for i in range(N):
        if name[i] != 'A':
            if not visited[i]:
                flag = False
                break
    
    if flag:
        if step < Min:
            Min = step
        return
    
    l, r = left(idx, N), right(idx, N)
    visited[l] += 1
    dfs(l, N, name, visited, step+1)
    visited[l] -= 1
    visited[r] += 1
    dfs(r, N, name, visited, step+1)
    visited[r] -= 1
            
        
def solution(name):
    
    global Min
    
    answer = 0
    N = len(name)
    Min = N+1
    c = 0
    for digit in name:
        c += change(digit)
    visited = [0] * N
    visited[0] = 1
    dfs(0, N, name, visited, 0)
    answer = c + Min
    return answer