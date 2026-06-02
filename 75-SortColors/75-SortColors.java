// Last updated: 03/06/2026, 00:10:54
//Doing the same as Move Zeroes question, dont know if this is the most optimised
class Solution {
    public void sortColors(int[] nums) {
        // Your code goes here
        int nextPositionToReplace=0;
        int i=0;
        for(i=0;i<nums.length;i++){
            if(nums[i]==0){
                int temp=nums[i];
                nums[i]=nums[nextPositionToReplace];
                nums[nextPositionToReplace]=temp;
                nextPositionToReplace++;
            }
        }
        //we dont need new parameter for 1's position as right now the nextPositionToReplace is at the position where the next 1 should go
        for(i=0;i<nums.length;i++){
            if(nums[i]==1){
                int temp=nums[i];
                nums[i]=nums[nextPositionToReplace];
                nums[nextPositionToReplace]=temp;
                nextPositionToReplace++;
            }
        }
        //similarly here the nextPositionToReplace is at the correct next position where a 2 should come next.
        for(i=0;i<nums.length;i++){
            if(nums[i]==2){
                int temp=nums[i];
                nums[i]=nums[nextPositionToReplace];
                nums[nextPositionToReplace]=temp;
                nextPositionToReplace++;
            }
        }
        
    }
}