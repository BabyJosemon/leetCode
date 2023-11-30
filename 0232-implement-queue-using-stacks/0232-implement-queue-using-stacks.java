class MyQueue {

        Stack<Integer> inputStack = new Stack<Integer>();
        Stack<Integer> outputStack = new Stack<Integer>();
    //Our 2 stacks
        
    
    
    public void push(int x) {
        inputStack.push(x);//simply push into one stack
    }
    
    public int pop() {
        peek();//to remove elements we will use another stack where we will move our items from inputStack. Removal from inputStack is LIFO and adding it into outputStack means that the order gets reversed and not first element will be in top to pop
        return(outputStack.pop());//pop that first element after transferring to output stack
    }
    
    public int peek() {
       if(outputStack.empty()){//always populate this
           while(!inputStack.empty()){//move all
               outputStack.push(inputStack.pop());//this is where 2xstack LIFO = FIFO
           }
       }
        return(outputStack.peek());
    }
    
    public boolean empty() {
       return(inputStack.empty() && outputStack.empty()) ;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */