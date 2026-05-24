# from collections import deque
#
#
# def bfs(now, visited, n, computers):
#     q = deque()
#     q.append(now)
#     visited[now] = True
#
#     while q:
#         t = q.popleft()
#
#         for tt in range(len(computers[t])):
#             con = computers[t][tt]
#             if con and not visited[tt]:
#                 q.append(tt)
#                 visited[tt] = True
#     return 1
#
#
# def solution(n, computers):
#     answer = 0
#     visited = [False] * n
#
#     for computer in range(n):
#         if not visited[computer]:
#             answer += bfs(computer, visited, n, computers)
#     return answer
def solution(n, computers):
    parents = [i for i in range(n)]

    def find(a):
        if parents[a] != a:
            parents[a] = find(parents[a])
        return parents[a]

    def union(a, b):
        pa = find(a)
        pb = find(b)
        if pa != pb:
            parents[pb] = pa

    for i in range(n):
        for j in range(n):
            if computers[i][j] == 1 and i != j:
                union(i, j)

    return len(set(find(i) for i in range(n)))
