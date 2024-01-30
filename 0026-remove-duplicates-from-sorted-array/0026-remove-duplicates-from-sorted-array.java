class Solution {
    public int removeDuplicates(int[] nums) {
        int i,j=1;
        for(i=1;i<nums.length;i++){
            if(nums[i]!=nums[i-1]){
                nums[j]=nums[i];
                j++;
            }    
        }
        return j;
        
    }
}