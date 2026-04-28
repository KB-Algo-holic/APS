# LC 700 - Search in a Binary Search Tree
# 유형: 트리
# 링크: https://leetcode.com/problems/search-in-a-binary-search-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:

    def find(self, node, value, res):

        if node.val == value:
            res.append(node)
        
        elif node.left and node.val > value:
            self.find(node.left, value, res)
        
        elif node.right and node.val < value:
            self.find(node.right, value, res)
        
    def searchBST(self, root: Optional[TreeNode], val: int) -> Optional[TreeNode]:
        
        res = []
        self.find(root, val, res)
        answer = res.pop() if res else None

        return answer