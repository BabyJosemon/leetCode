// Last updated: 10/05/2026, 23:12:01
1/*This is tecnically a fast-slow pointer approach which is a subset of two pointers. To solve this we have a pointer i that iterates through the list and another pointer nonZeroPosition that keeps track of the position where a non zero number should be placed. They both initially start together but i moves through the array while other does not at first. As soon as i sees a non zero number it swaps the number's position with nonZeroPosition and iterates nonZeroPosition after. i then continues on.*/
2class Solution {
3    public void moveZeroes(int[] nums) {
4        int nonZeroPosition = 0;
5        for(int i = 0; i<nums.length; i++){
6            if(nums[i]!=0){
7                int temp = nums[nonZeroPosition];
8                nums[nonZeroPosition]= nums[i];
9                nums[i] = temp;
10                nonZeroPosition++;
11            }
12        }
13    }
14}