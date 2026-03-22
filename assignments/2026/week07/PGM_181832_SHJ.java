# 주석 1 : PGM - 181832
# 주석 2 : 구현
# 주석 3 : https://school.programmers.co.kr/learn/courses/30/lessons/181832

def solution(n):
    answer = [[0] * n for _ in range(n)]

    top, bottom = 0, n - 1
    left, right = 0, n - 1

    num = 1

    while num <= n * n:
        # 1. left → right
        for i in range(left, right + 1):
            answer[top][i] = num
            num += 1
        top += 1

        # 2. top → bottum
        for i in range(top, bottom + 1):
            answer[i][right] = num
            num += 1
        right -= 1

        # 3. right → left
        if top <= bottom:
            for i in range(right, left - 1, -1):
                answer[bottom][i] = num
                num += 1
            bottom -= 1

        # 4. bottom → top
        if left <= right:
            for i in range(bottom, top - 1, -1):
                answer[i][left] = num
                num += 1
            left += 1

    return answer
