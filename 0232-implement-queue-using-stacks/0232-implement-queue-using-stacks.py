from collections import deque
class MyQueue:
    
    

    def __init__(self):
        self.inputStack=deque()
        self.outputStack=deque()

    def push(self, x: int) -> None:
        self.inputStack.append(x)

    def pop(self) -> int:
        self.peek()
        return self.outputStack.pop()

    def peek(self) -> int:
        if(len(self.outputStack)==0):
            while(len(self.inputStack)>0):
                self.outputStack.append(self.inputStack.pop())
        return self.outputStack[-1]
        

    def empty(self) -> bool:
        return (len(self.inputStack)==0 and len(self.outputStack)==0)


# Your MyQueue object will be instantiated and called as such:
# obj = MyQueue()
# obj.push(x)
# param_2 = obj.pop()
# param_3 = obj.peek()
# param_4 = obj.empty()