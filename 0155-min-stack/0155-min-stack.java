class MinStack {
    List<Integer> stack;
    List<Integer> minimum;

    public MinStack() {
       stack = new ArrayList<Integer>();
       minimum = new ArrayList<Integer>();
    }
    
    public void push(int val) {
        this.stack.add(val);
        int lengthMin = this.minimum.size();
        if(lengthMin==0){
            this.minimum.add(val);
        }else{
            this.minimum.add(Math.min(val, this.minimum.get(lengthMin-1)));
        }
    }
    
    public void pop() {
        int lengthPop=this.stack.size()-1;
        int popped=this.stack.remove(lengthPop);
        int poppedMin=this.minimum.remove(lengthPop);
    }
    
    public int top() {
        return this.stack.get(this.stack.size()-1);
    }
    
    public int getMin() {
        return this.minimum.get(this.minimum.size()-1);
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */