# PGM 67256 - 키패드 누르기
# 유형: 구현 / 탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/67256

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

target = {
    0: [3, 1],
    1: [0, 0],
    2: [0, 1],
    3: [0, 2],
    4: [1, 0],
    5: [1, 1],
    6: [1, 2],
    7: [2, 0],
    8: [2, 1],
    9: [2, 2],
    '*': [3, 0],
    '#': [3, 2]
}

left_side = [1, 4, 7]
right_side = [3, 6, 9]

def bfs(start, end):
    x, y = target[start][0], target[start][1]
    queue = []
    visited = [[0 for _ in range(3)] for _ in range(4)]
    visited[x][y] = 1
    queue.append([x, y])
    
    count = 0
    while queue:
        node = queue.pop(0)
        x, y = node[0], node[1]
        step = visited[x][y]
        if x == target[end][0] and y == target[end][1]:
            return step
        
        for i in range(4):
            a, b = x + dx[i], y + dy[i]
            if 0 <= a <= 3 and 0 <= b <= 2 and visited[a][b] == 0:
                visited[a][b] = step + 1
                queue.append([a, b])

def solution(numbers, hand):
    answer = ''

    left = '*'
    right = '#'

    for num in numbers:
        
        if num in left_side:
            left = num
            answer += 'L'
            continue
        
        elif num in right_side:
            right = num
            answer += 'R'
            continue

        left_step = bfs(left, num)
        right_step = bfs(right, num)

        if left_step < right_step:
            left = num
            answer += 'L'
        
        elif right_step < left_step:
            right = num
            answer += 'R'
        
        else:
            if hand == 'left':
                left = num
                answer += 'L'
            
            else:
                right = num
                answer += 'R'
    
    return answer