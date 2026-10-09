answer = []


def rotate(matrix, queries):
    global answer
    for q in queries:
        l = []
        y1, x1, y2, x2 = q[0] - 1, q[1] - 1, q[2] - 1, q[3] - 1

        start = matrix[y1][x1]
        prev = matrix[y1][x1]
        tmp = -1
        current_x = x1;
        current_y = y1
        move = [1, 0]

        while (tmp != start):
            current_y += move[1]
            current_x += move[0]

            tmp = matrix[current_y][current_x]
            matrix[current_y][current_x] = prev
            prev = tmp

            if (current_x == x2):
                move = [0, 1]
            if (current_y == y2):
                move = [-1, 0]
            if (current_x == x1):
                move = [0, -1]

            l.append(tmp)
        answer.append(min(l))


def solution(rows, columns, queries):
    matrix = []
    tmp = []
    for i in range(1, (rows * columns + 1)):
        tmp.append(i)
        if (len(tmp) == columns):
            matrix.append(tmp)
            tmp = []

    rotate(matrix, queries)

    return answer