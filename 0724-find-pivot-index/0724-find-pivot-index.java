//Useful Logic Can be also used in Codility Tape Equilibrium. given nums[1,7,3,6,5,6] we need to find if leftsum=rightsum.
//Sum the elements=28 this is rightsum. Initiate leftSum as 0. This rightsum is totalrightSum rn ie. (1+7+3+6+5+6). If we 
//start a loop from beginning of array and keep subtracting each element from this rightSum, then our rightSum becomes each 
//partition's sum one by one. 28-1=(7+3+6+5+6), 27-7=(3+6+5+6), 20-3=(6+5+6). Each time we are getting the rightPartition sum
//Now along with this keep summing leftSum with i. So that leftSumPartition also increases, 1=(1), 1+7=(8),1+7+3=(11)... Between
//both these steps check if anywhere they become equal, if they do return i.

class Solution {
    public int pivotIndex(int[] nums) {
        int rightSum=0,leftSum=0,n;
        n= nums.length;
        for(int i=0;i<n;i++){
            rightSum+=nums[i];//28
        }
        for(int i=0;i<n;i++){
            rightSum-=nums[i];
            if(rightSum==leftSum){return i;}
            leftSum+=nums[i];
        }
        return -1;
    }
}