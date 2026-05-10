// Last updated: 10/05/2026, 23:26:30
// This is the correct solution.
1//Doing the same as Move Zeroes question, dont know if this is the most optimised
2class Solution {
3    public void sortColors(int[] nums) {
4        // Your code goes here
5        int nextPositionToReplace=0;
6        int i=0;
7        for(i=0;i<nums.length;i++){
8            if(nums[i]==0){
9                int temp=nums[i];
10                nums[i]=nums[nextPositionToReplace];
11                nums[nextPositionToReplace]=temp;
12                nextPositionToReplace++;
13            }
14        }
15        //we dont need new parameter for 1's position as right now the nextPositionToReplace is at the position where the next 1 should go
16        for(i=0;i<nums.length;i++){
17            if(nums[i]==1){
18                int temp=nums[i];
19                nums[i]=nums[nextPositionToReplace];
20                nums[nextPositionToReplace]=temp;
21                nextPositionToReplace++;
22            }
23        }
24        //similarly here the nextPositionToReplace is at the correct next position where a 2 should come next.
25        for(i=0;i<nums.length;i++){
26            if(nums[i]==2){
27                int temp=nums[i];
28                nums[i]=nums[nextPositionToReplace];
29                nums[nextPositionToReplace]=temp;
30                nextPositionToReplace++;
31            }
32        }
33        
34    }
35}