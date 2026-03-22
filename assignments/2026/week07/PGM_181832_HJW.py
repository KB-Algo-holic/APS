# PGM 181832 - 정수를 나선형으로 배치하기
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/181832

def solution(n):
    answer = [[0 for _ in range(n)] for _ in range(n)]
    direction = [0, 1, 2, 3]
    d = 0
    x, y = 0, 0
    cnt = 1
    for _ in range(n*n):
        answer[x][y] = cnt
        cnt += 1
        
        if d == 0:
            if 0 <= x < n and 0 <= y+1 < n and not answer[x][y+1]:
                y += 1
            else:
                d += 1
                d %= 4
                x += 1
        
        elif d == 1:
            if 0 <= x+1 < n and 0 <= y < n and not answer[x+1][y]:
                x += 1
            else:
                d += 1
                d %= 4
                y -= 1
        
        elif d == 2:
            if 0 <= x < n and 0 <= y-1 < n and not answer[x][y-1]:
                y -= 1
            else:
                d += 1
                d %= 4
                x -= 1
        
        elif d == 3:
            if 0 <= x-1 < n and 0 <= y < n and not answer[x-1][y]:
                x -= 1
            else:
                d += 1
                d %= 4
                y += 1
        
    return answer