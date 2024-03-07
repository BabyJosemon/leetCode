class KthLargest {
    PriorityQueue<Integer> minheap=new PriorityQueue<>((i1,i2)->i1-i2);
    final int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
        for(int i=0;i<nums.length;i++){
            add(nums[i]);
        }
    }
    
    public int add(int val) {
        minheap.add(val);
        if(minheap.size()>k){
            minheap.poll();
        }
        return minheap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */