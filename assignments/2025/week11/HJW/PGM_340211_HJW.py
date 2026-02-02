# PGM 340211 - 충돌위험 찾기
# 유형: 시뮬레이션
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/340211

def check_map(maps):
    cnt = 0
    flag = 0
    if maps:
        flag = 1
    for key in maps:
        if key != (0, 0) and maps.get(key) > 1:
            cnt += 1
    return cnt, flag

def solution(points, routes):
    answer = 0
    
    points = [0] + points
    routes = [0] + routes
    maps = dict()
    target = dict()
    for i in range(1, len(routes)):
        point = routes[i][0]
        routes[i][0] = 0
        target[i] = [0, 0]
        target[i][0] = points[point][0]
        target[i][1] = points[point][1]
        tmp = (target[i][0], target[i][1])
        maps[tmp] = maps.get(tmp, 0) + 1
    
    while True:
        cnt, flag = check_map(maps)
        if not flag:
            break
        answer += cnt
        maps = dict()
        for t in target:
            for i in range(len(routes[t])):
                dest = routes[t][i]
                if dest != 0:
                    x, y = target[t][0], target[t][1]
                    if x == 0 and y == 0:
                        continue
                    x_, y_ = points[dest][0], points[dest][1]
                    if x > x_:
                        x -= 1
                    elif x < x_:
                        x += 1
                    elif y > y_:
                        y -= 1
                    elif y < y_:
                        y += 1
                    elif x == x_ and y == y_:
                        routes[t][i] = 0
                        if i+1 < len(routes[t]):
                            dest = routes[t][i+1]
                            x_, y_ = points[dest][0], points[dest][1]
                            if x > x_:
                                x -= 1
                            elif x < x_:
                                x += 1
                            elif y > y_:
                                y -= 1
                            elif y < y_:
                                y += 1
                        elif i+1 == len(routes[t]):
                            x, y = 0, 0
                    
                    tmp = (x, y)
                    maps[tmp] = maps.get(tmp, 0) + 1

                    target[t][0] = x
                    target[t][1] = y
                    break

    return answer