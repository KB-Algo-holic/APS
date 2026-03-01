# PGM 77485 - 행렬 테두리 회전하기
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/77485

def rotation(N, M, matrix, query):
    
    x1, y1, x2, y2 = query[0], query[1], query[2], query[3]
    x1 -= 1
    y1 -= 1
    x2 -= 1
    y2 -= 1
    
    points = [matrix[x1][y1], matrix[x2][y1], matrix[x1][y2], matrix[x2][y2]]
    Min = N*M
    # 상단
    for i in range(y2, y1, -1):
        matrix[x1][i] = matrix[x1][i-1]
        if matrix[x1][i] < Min:
            Min = matrix[x1][i]
    
    # 우측
    for i in range(x2, x1+1, -1):
        matrix[i][y2] = matrix[i-1][y2]
        if matrix[i][y2] < Min:
            Min = matrix[i][y2]
    matrix[x1+1][y2] = points[2]
    if points[2] < Min:
        Min = points[2]
    
    # 하방
    for i in range(y1, y2-1):
        matrix[x2][i] = matrix[x2][i+1]
        if matrix[x2][i] < Min:
            Min = matrix[x2][i]
    matrix[x2][y2-1] = points[3]
    if points[3] < Min:
        Min = points[3]
    
    # 좌측
    for i in range(x1, x2-1):
        matrix[i][y1] = matrix[i+1][y1]
        if matrix[i][y1] < Min:
            Min = matrix[i][y1]
    matrix[x2-1][y1] = points[1]
    if points[1] < Min:
        Min = points[1]
    
    return Min
    

def solution(rows, columns, queries):
    
    answer = []
    matrix = [[0 for _ in range(columns)] for _ in range(rows)]
    
    cnt = 1
    for i in range(rows):
        for j in range(columns):
            matrix[i][j] = cnt
            cnt += 1
    
    for query in queries:
        Min = rotation(rows, columns, matrix, query)
        answer.append(Min)    

    return answer