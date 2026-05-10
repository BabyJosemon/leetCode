// Last updated: 10/05/2026, 20:54:20
/*The intuition behind this is probably very specific but still logical. We need to find numbers a,b,and c with 4 conditions specified. So a<b<c and a+b>c, a+c>b, and b+c>a. The brute force approach would be to check each combination resulting in O(n^3). We have seen in questions like 3sum that we need to sort, we will do the same here first. Now the intuition is:
1) If a<b<c i.e. a and b are the smallest numbers then we only need to verify 
a+b>c. The other two conditions we know will always be satisfies this these earlier two are satisfied. This is because if a and b the smallest numbers in the bunch can add up to a number greater than c, then adding c to a instead of b will only make the sum(a+c) even bigger than sum (a+b). This means the condition (a+c>b) will also be true. Same for the last condition.
2) The other intuition is that if we have a=4, b=8, c=9 satisfies a + b > c, then any number between a and b will also satisfy the condition. In 4+8>9 i.e. replace a with any x such that a<=x<=b. They will all satisfy, this is because If you increase a, the left side a + b only gets bigger or stays the same. The right side c doesn't change at all. So once you have a valid a,b,and c you can just count numbers between a and b as well without checking.
With these 2 things in mind we can solve this by sorting the array first then iterating from the largest (rightmost) number as c. Then the two pointers are a and b that start with a=0th element, b=(c-1)th element (number before c). We check the condition of a+b>c, if false then the sum of a b is too small and we need to increase it, so move left forward. If true then we count the numbers between left and right (these numbers x where left<=x<=right). After that we move right-- so that we check the next combination. Imagine this as for each iteration of c we have a left(a) and a right(b) and for each b we find all combinations with a (hence why right--)
*/
class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count=0;
        for(int c=nums.length-1;c>=2;c--){
            int left=0;
            int right=c-1;
            //traditional two pointers
            while(left<right){
                if((nums[left]+nums[right])>nums[c]){
                    //we found the condition, we only need to count now.
                    count+=(right-left);
                    right--;//we move to next combination to check
                }else{
                    //sum is too small, need to increase so move left
                    left++;
                }
            }
        }
        return count;
    }
}