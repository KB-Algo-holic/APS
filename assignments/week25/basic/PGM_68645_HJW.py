# PGM 68645 - 삼각 달팽이
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/68645

num = 1

def draw(matrix, depth, n):
    
    global num
    
    for i in range(2*depth, n-depth):
        matrix[i][depth] = num
        num += 1

    for i in range(depth+1, n-2*depth):
        matrix[n-1-depth][i] = num
        num += 1
    
    for i in range(n-2-depth, 2*depth, -1):
        matrix[i][i-depth] = num
        num += 1

def solution(n):
    matrix = [[0 for _ in range(n)] for _ in range(n)]
    
    for i in range(334):
        draw(matrix, i, n)
    
    answer = []
    for i in range(n):
        for j in range(n):
            if matrix[i][j]:
                answer.append(matrix[i][j])
            else:
                break
    
    return answer