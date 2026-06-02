# LC 784 - Letter Case Permutation
# 유형: 완전 탐색
# 링크: https://leetcode.com/problems/letter-case-permutation/

class Solution:
    answer = []

    def dfs(self, s, idx, now):
        if idx == len(s):
            self.answer.append(now)
            return
        
        if s[idx].isalpha():
            self.dfs(s, idx+1, now+s[idx].lower())
            self.dfs(s, idx+1, now+s[idx].upper())
        
        else:
            self.dfs(s, idx+1, now+s[idx])

    def letterCasePermutation(self, s: str) -> List[str]:
        self.answer = []
        self.dfs(s, 0, '')
        return self.answer