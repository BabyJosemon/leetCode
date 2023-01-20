from collections import deque
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def invertTree(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        queue=deque()#using a deque is good for append,pop,popleft, and appendleft
        queue.append(root)#initially add the root
        while queue:#until this is empty
            currentNode=queue.popleft()#take out the first element
            if currentNode:
                currentNode.left,currentNode.right=currentNode.right,currentNode.left #do the swapping in single operation as otherwise the values of left or right change.
            
                if currentNode.left:
                    queue.append(currentNode.left)#add the subtrees of the nodes as well as they need to be swapped as well.
                if currentNode.right:
                    queue.append(currentNode.right)
        return root