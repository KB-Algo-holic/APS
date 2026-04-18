# PGM 172928 - 공원 산책
# 유형: 그래프
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/172928

def solution(park, routes):
    answer = []
    x, y = -1, -1
    for i in range(len(park)):
        for j in range(len(park[0])):
            if park[i][j] == 'S':
                x, y = i, j
                break
        if x != -1 and y != -1:
            break
    
    for i in range(len(routes)):
        command = routes[i].split()
        flag = True
        dx, dy = x, y
        step = int(command[1])
        
        if command[0] == 'N':
            dx -= step
            if dx < 0:
                flag = False
            
            if flag:
                for k in range(x, dx-1, -1):
                    if park[k][y] == 'X':
                        flag = False
            
        elif command[0] == 'S':
            dx += step
            if dx >= len(park):
                flag = False
            
            if flag:
                for k in range(x, dx+1):
                    if park[k][y] == 'X':
                        flag = False
                        
        elif command[0] == 'W':
            dy -= step
            if dy < 0:
                flag = False
            
            if flag:
                for k in range(y, dy-1, -1):
                    if park[x][k] == 'X':
                        flag = False
            
        elif command[0] == 'E':
            dy += step
            if dy >= len(park[0]):
                flag = False
            
            if flag:
                for k in range(y, dy+1):
                    if park[x][k] == 'X':
                        flag = False
        
        if flag:
            x, y = dx, dy
    
    return [x, y]