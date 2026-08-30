# PGM 81302 - 거리두기 확인하기
# 유형: 그래프 탐색(BFS, DFS)
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/81302

def solution(places):
    answer = []

    for place in places:
        check = 1

        for r in range(5):
            for c in range(5):
                if place[r][c] != 'P':
                    continue

                # 상하좌우: 거리 1
                for dr, dc in [(1,0), (-1,0), (0,1), (0,-1)]:
                    nr, nc = r + dr, c + dc

                    if 0 <= nr < 5 and 0 <= nc < 5:
                        if place[nr][nc] == 'P':
                            check = 0

                # 직선 거리 2
                for dr, dc in [(2,0), (-2,0), (0,2), (0,-2)]:
                    nr, nc = r + dr, c + dc

                    if 0 <= nr < 5 and 0 <= nc < 5:
                        if place[nr][nc] == 'P':
                            mr, mc = r + dr // 2, c + dc // 2
                            if place[mr][mc] != 'X':
                                check = 0

                # 대각선 거리 2
                for dr, dc in [(1,1), (1,-1), (-1,1), (-1,-1)]:
                    nr, nc = r + dr, c + dc

                    if 0 <= nr < 5 and 0 <= nc < 5:
                        if place[nr][nc] == 'P':
                            if place[r][nc] != 'X' or place[nr][c] != 'X':
                                check = 0

        answer.append(check)

    return answer
