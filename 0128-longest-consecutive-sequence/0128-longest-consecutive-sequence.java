class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toCollection(HashSet::new));
        int best=0;
        for(int i:nums){
        if(!numsSet.contains(i-1)){
            int nextNum=i+1;
            while(numsSet.contains(nextNum)){
                nextNum+=1;
            }
            best=Math.max(best,nextNum-i);
        }
    }
    return best;
       
    
    
    
}
}