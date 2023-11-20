from collections import deque
"""
# Definition for a Node.
class Node:
    def __init__(self, val: int = 0, left: 'Node' = None, right: 'Node' = None, next: 'Node' = None):
        self.val = val
        self.left = left
        self.right = right
        self.next = next
"""

class Solution:
    def connect(self, root: 'Optional[Node]') -> 'Optional[Node]':
        if root is None:
            return None
        result=[]
        queue=deque()
        queue.append(root)
        while(queue):
            currentLength=len(queue)
            currentLevel=[]
            for i in range(currentLength):
                currentNode=queue.popleft()
                if(currentLength-i!=1):
                    nextNode=queue[0]
                    nextChecker=False
                else:
                    nextNode=None
                    nextChecker=True
                currentNode.next=nextNode
                currentLevel.append(currentNode.val)
                if nextChecker:
                    currentLevel.append('#')
                if currentNode.left:
                    queue.append(currentNode.left)
                if currentNode.right:
                    queue.append(currentNode.right)
            result+=currentLevel
        return root
                
        