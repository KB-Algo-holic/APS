# LC 64 - Minimum Path Sum
# 유형: DP
# 링크: https://leetcode.com/problems/minimum-path-sum/

class Solution:
    def minPathSum(self, grid: List[List[int]]) -> int:
        n, m = len(grid), len(grid[0])
        dp = [[0 for _ in range(m)] for _ in range(n)]
        dp[0][0] = grid[0][0]
        for i in range(1, n):
            dp[i][0] = grid[i][0] + dp[i-1][0]
        for j in range(1, m):
            dp[0][j] = grid[0][j] + dp[0][j-1]
        
        for i in range(1, n):
            for j in range(1, m):
                dp[i][j] = min(dp[i-1][j], dp[i][j-1]) + grid[i][j]
                
        return dp[n-1][m-1]