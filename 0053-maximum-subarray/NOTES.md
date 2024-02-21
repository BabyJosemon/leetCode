Loop through the array. Keep track of currentSum and maxSum in every iteration. If at
any time currentSum goes below 0, reset currentSum back to 0. If we were asked to return the ranges where the maxSum resides then we use a sort of sliding window.
```
public static int[] maxSubArray(int[] nums) {
  int maxSum=Integer.MIN_VALUE;
  int currentSum=0;
  int winStart=0, staticStart=0, staticEnd=0;
  for(int winEnd=0;winEnd<nums.length;winEnd++){
    currentSum+=nums[winEnd];
    if(currentSum>maxSum){
      maxSum=currentSum;
      staticStart=winStart;
      staticEnd=winEnd;
    }
    if(currentSum<0){
      currentSum=0;
      winStart=winEnd+1;
    }
  }
    if(winStart>nums.length){
      return new int[0];
    }else{
      return Arrays.copyOfRange(nums, staticStart, staticEnd + 1);
    }
}
public static void main(String args[])
{
  int[] result = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
  System.out.println(Arrays.toString(result));
}
```
