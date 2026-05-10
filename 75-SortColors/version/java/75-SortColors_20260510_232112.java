// Last updated: 10/05/2026, 23:21:12
1//Doing the same as Move Zeroes question, dont know if this is the most optimised.
2class Solution {
3    public void sortColors(int[] nums) {
4        // Your code goes here
5        int nextZeroPosition=0;
6        int i=0;
7        for(i=0;i<nums.length;i++){
8            if(nums[i]==0){
9                int temp=nums[i];
10                nums[i]=nums[nextZeroPosition];
11                nums[nextZeroPosition]=temp;
12                nextZeroPosition++;
13            }
14        }
15        int nextOnePosition=0;
16        for(i=0;i<nums.length;i++){
17            if(nums[i]==1){
18                int temp=nums[i];
19                nums[i]=nums[nextZeroPosition];
20                nums[nextZeroPosition]=temp;
21                nextZeroPosition++;
22            }
23        }
24        int nextTwoPosition=0;
25        for(i=0;i<nums.length;i++){
26            if(nums[i]==2){
27                int temp=nums[i];
28                nums[i]=nums[nextZeroPosition];
29                nums[nextZeroPosition]=temp;
30                nextZeroPosition++;
31            }
32        }
33        
34    }
35}