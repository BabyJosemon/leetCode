//codility, can have 2 solutions 1) mathematical solution = sum of integers from 1-N = n(n+1)/2. Find this sum and subtract from
//it the actual nums sum. The difference is the missing sum. 2)Create a set of numbers from 0 to n+1. Iterate through this set and
//remove nums[i]. The last remaining element will be the missing number.
class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        /*Maths Solution
        int actualSum=0;
        int totalSum=n*(n+1)/2;
        for(int i=0;i<n;i++){
            actualSum+=nums[i];
        }
        return totalSum-actualSum;
        */
        Set<Integer> cache=new HashSet<>();
        for(int i=0;i<=n;i++){
            cache.add(i);    
        }
        for(int i=0;i<n;i++){
            cache.remove(nums[i]);
        }
        return cache.iterator().next();
    }
}