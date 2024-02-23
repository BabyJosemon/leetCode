class Solution {
    public int longestOnes(int[] nums, int k) {
        int winStart=0, maxNumberOfOnes=0, maxSize=0;
        for(int winEnd=0; winEnd<nums.length; winEnd++){
            int currentNum=nums[winEnd];
            if(currentNum==1){
                maxNumberOfOnes+=1;
            }
            if((winEnd-winStart+1)-maxNumberOfOnes>k){
                int numberToReduce=nums[winStart];
                if(numberToReduce==1){
                    maxNumberOfOnes-=1;
                }
                winStart+=1;
            }
           maxSize=Math.max(maxSize, winEnd-winStart+1); 
        }
        return maxSize;
        
    }
}