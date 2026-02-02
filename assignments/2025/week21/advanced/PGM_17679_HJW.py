# PGM 17679 - [1차] 프렌즈4블록
# 유형: 구현
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/17679

def turn_round(m, n, board, direction):
    result = []
    if direction == 'right':
        for i in range(n):
            line = ""
            for j in range(m-1, -1, -1):
                line += board[j][i]
            result.append(line)
    
    elif direction == 'left':
        for i in range(n-1, -1, -1):
            line = ""
            for j in range(m):
                line += board[j][i]
            result.append(line)
    
    return result

def friends_4_block(m, n, board):
    
    new_board = [[1 for _ in range(n)] for _ in range(m)]
    
    for i in range(m-1):
        for j in range(n-1):
            if board[i][j] != '0' and board[i][j] == board[i+1][j] == board[i][j+1] == board[i+1][j+1]:
                new_board[i][j] = 0
                new_board[i+1][j] = 0
                new_board[i][j+1] = 0
                new_board[i+1][j+1] = 0
    
    result = []
    cnt = 0
    for i in range(m):
        line = ""
        for j in range(n):
            if new_board[i][j] == 0:
                cnt += 1
                line += ' '
            else:
                line += board[i][j]
        result.append(line)
    
    return result, cnt
                

def solution(m, n, board):
    answer = 0
    
    while True:
        board, cnt = friends_4_block(m, n, board)
        if not cnt:
            break
        answer += cnt
        board = turn_round(m, n, board, 'right')
        for i in range(len(board)):
            board[i] = ''.join(board[i].split())[::-1].zfill(n)[::-1]
        board = turn_round(n, m, board, 'left')

    return answer