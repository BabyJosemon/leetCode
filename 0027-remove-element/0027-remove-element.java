class Solution {
    public int removeElement(int[] nums, int val) {
        int temp;
        int i;
        for(i=0;i<nums.length;i++){
            int j=nums.length-1;
            if(nums[i]==val){
                while(i<=j){
                    if(i==j){
                        return i;
                    }
                    if(nums[j]!=val){
                        temp=nums[i];
                        nums[i]=nums[j];
                        nums[j]=temp;
                        break;
                    }
                    j--;
                    
                }
            }
            
        }
        
       return i; 
    }
}