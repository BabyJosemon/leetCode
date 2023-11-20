# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def helper(self, l, r):
        if l is None and r is None:
            return True
        if l is None or r is None:
            return False
        return l.val==r.val and self.helper(l.left, r.right) and self.helper(l.right, r.left)
        
    def isSymmetric(self, root: Optional[TreeNode]) -> bool:
        if root is None:
            return True
        else:
            return self.helper(root.left, root.right)