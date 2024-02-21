staticStart=winStart;
​
staticEnd=winEnd;
​
}
​
if(currentSum<0){
​
currentSum=0;
​
winStart=winEnd+1;
​
}
​
}
​
if(winStart>nums.length){
​
return new int[0];
​
}else{
​
return Arrays.copyOfRange(nums, staticStart, staticEnd + 1);
​
}
​
}
​
public static void main(String args[])
​
{
​
int[] result = maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4});
​
System.out.println(Arrays.toString(result));
​
}