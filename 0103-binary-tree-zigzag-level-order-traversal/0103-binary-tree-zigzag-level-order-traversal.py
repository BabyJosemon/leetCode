from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def zigzagLevelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        if root is None:
            return []
        result=[]
        queue=deque()
        queue.append(root)
        currentBool=False
        while queue:
            currentLevelSize=len(queue)
            currentLevel=deque()
            for _ in range(currentLevelSize):
                currentNode=queue.popleft()
                if currentBool:
                    currentLevel.appendleft(currentNode.val)
                else:
                    currentLevel.append(currentNode.val)
                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right:
                    queue.append(currentNode.right)
            result.append(list(currentLevel))
            currentBool=not currentBool
        return result