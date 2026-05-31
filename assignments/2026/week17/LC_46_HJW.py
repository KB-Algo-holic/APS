# LC 46 - Permutations
# 유형: 완전 탐색
# 링크: https://leetcode.com/problems/permutations/

class Solution:
    answer = []
    def dfs(self, nums, visited, res):

        if len(res) == len(nums):
            self.answer.append(list(res))
            return

        for i in range(len(nums)):
            if not visited[i]:
                visited[i] = 1
                res.append(nums[i])
                self.dfs(nums, visited, res)
                res.pop()
                visited[i] = 0

    def permute(self, nums: List[int]) -> List[List[int]]:
        self.answer = []
        visited = [0] * len(nums)
        self.dfs(nums, visited, [])
        
        return self.answer