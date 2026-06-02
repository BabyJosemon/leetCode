// Last updated: 03/06/2026, 00:10:51
/*This is tecnically a fast-slow pointer approach which is a subset of two pointers. To solve this we have a pointer i that iterates through the list and another pointer nonZeroPosition that keeps track of the position where a non zero number should be placed. They both initially start together but i moves through the array while other does not at first. As soon as i sees a non zero number it swaps the number's position with nonZeroPosition and iterates nonZeroPosition after. i then continues on.*/
class Solution {
    public void moveZeroes(int[] nums) {
        int nonZeroPosition = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i]!=0){
                int temp = nums[nonZeroPosition];
                nums[nonZeroPosition]= nums[i];
                nums[i] = temp;
                nonZeroPosition++;
            }
        }
    }
}