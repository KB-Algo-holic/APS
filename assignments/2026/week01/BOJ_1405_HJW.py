# BOJ 1405 - 미친 로봇
# 유형: DFS
# 링크: https://www.acmicpc.net/problem/1405

K, E, W, S, N = map(int, input().split())
answer = 0
rates = [E/100, W/100, S/100, N/100]
dx = [0, 0, 1, -1]
dy = [1, -1, 0, 0]

def dfs(step, a, b, visited, rate):

    global answer

    if step == K:
        answer += rate
        return

    for i in range(4):
        x, y = a + dx[i], b + dy[i]
        if not visited[x][y]:
            visited[x][y] = 1
            dfs(step+1, x, y, visited, rate*rates[i])
            visited[x][y] = 0

visited = dict()
for i in range(-2*K, 2*K):
    visited[i] = dict()
    for j in range(-2*K, 2*K):
        visited[i][j] = 0

visited[0][0] = 1
dfs(0, 0, 0, visited, 1)
print(answer)