# PGM 87946 - 피로도
# 유형: 완전탐색
# 링크: https://school.programmers.co.kr/learn/courses/30/lessons/87946

def dfs(k, dungeons, visited, count):
    max_count = count
    for i in range(len(dungeons)):
        if not visited[i] and k >= dungeons[i][0]:
            visited[i] = True
            max_count = max(max_count, dfs(k - dungeons[i][1], dungeons, visited, count + 1))
            visited[i] = False
    return max_count

def solution(k, dungeons):
    visited = [False] * len(dungeons)
    return dfs(k, dungeons, visited, 0)

# def permutation(cur, n, visited, k, dungeons, count, max_result):
#     max_result[0] = max(max_result[0], count)

#     for i in range(n):
#         if visited[i]:
#             continue
#         if k < dungeons[i][0]:
#             continue

#         visited[i] = True
#         cur.append(i)
#         permutation(cur, n, visited, k - dungeons[i][1], dungeons, count + 1, max_result)
#         cur.pop()
#         visited[i] = False  


# def solution(k, dungeons):
#     n = len(dungeons)
#     visited = [False] * n
#     max_result = [0]  
#     permutation([], n, visited, k, dungeons, 0, max_result)
#     return max_result[0]


