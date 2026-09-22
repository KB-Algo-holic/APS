class Solution:
    def findCircleNum(self, isConnected: List[List[int]]) -> int:
        n = len(isConnected)
        visited = [False] * n  # 각 도시의 방문 여부
        cnt = 0

        def dfs(idx):  # idx: 현재 도시
            visited[idx] = True  # 노드에 들어오는 순간 방문처리해야하므로 dfs함수 안에 있어야함
            for i in range(n):
                if isConnected[idx][i] == 1 and not visited[i]:  # i: 현재 도시와 연결된 도시
                    dfs(i)

        for i in range(n):
            if not visited[i]:
                dfs(i)
                cnt += 1

        return cnt