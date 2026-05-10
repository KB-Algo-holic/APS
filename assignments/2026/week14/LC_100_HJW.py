# LC 100 - Same Tree
# 유형: DFS
# 링크: https://leetcode.com/problems/same-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def __init__(self):
        self.res = True
    
    def dfs(self, a, b):

        if (a.val == None and b.val != None) or (a.val != None and b.val == None):
            self.res = False
            return
        
        if a.val != b.val:
            self.res = False
            return
        
        if (not a.left and b.left) or (a.left and not b.left) or (not a.right and b.right) or (a.right and not b.right):
            self.res = False
            return
        
        if self.res and a.left and b.left:
            self.dfs(a.left, b.left)
        
        if self.res and a.right and b.right:
            self.dfs(a.right, b.right)

    def isSameTree(self, p: Optional[TreeNode], q: Optional[TreeNode]) -> bool:
        
        if (p and not q) or (not p and q):
            self.res = False
        
        if p and q:
            self.dfs(p, q)
        
        return self.res