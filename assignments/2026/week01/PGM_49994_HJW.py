# PGM 49994 - 방문 길이
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/49994

def solution(dirs):
    answer = 0
    
    direction = {
        "U": 0,
        "D": 1,
        "R": 2,
        "L": 3
    }
    dx = [0, 0, 1, -1]
    dy = [1, -1, 0, 0]
    
    x, y = 0, 0
    visited = {
        "0 0": [0] * 4
    }
    
    for d in dirs:
        
        i = direction[d]
        a, b = x+dx[i], y+dy[i]
        if not (0 <= abs(a) <= 5 and 0 <= abs(b) <= 5):
            continue
        
        if not visited[f"{x} {y}"][i]:
            visited[f"{x} {y}"][i] = 1
            answer += 1
        
        if not visited.get(f"{a} {b}"):
            visited[f"{a} {b}"] = [0] * 4
        
        if i%2:
            visited[f"{a} {b}"][i-1] = 1
        else:
            visited[f"{a} {b}"][i+1] = 1
        
        x, y = a, b
    
    return answer