/*
If we search linearly by checking each pair of consecutive values and try to find the pivot where a[i]>a[i+1] then the a[i+1] is the min.
BUT The first hint that they say that they need an algo that runs in O(log n) time suggests the use of binary search. If we could straight-up use binary search, the first element would be the minimum. However the array could have been rotated so we cant use normal binary search. Instead,
keep track of a result variable set it to arr[0] at start
given eg [3,4,5,1,2]. take left and right similar to Bsearch. Then if arr[left]<arr[right] then it is sorted and we just check min with result and arr[l]
Find mid, now arr[mid] can be a potential solution so mincheck with result. 
When the array is pivoted, its divided into 2 parts, the left sorted portion and right sorted portion. The rotation puts the larger values from right side of original array onto the left side. In the above eg. [3,4,5] is left and [1,2] is right side. Now we need to check which side the mid belongs to. If it is a part of left side then we need to search only right side bcs of above reason.
Now we check if arr[mid]>=arr[l]. If it is it means that the current mid is part of the left side and everything to the right will definitely be smaller than them. So we increment left
Otherwise the mid is part of the right side and everything to the right of right side will be larger so we check left. and also because of pivot the smallest in the right side will always be to the left of mid (eg. mid=2), so we decrement the right 
*/
class Solution {
    public int findMin(int[] nums) {
        int result=nums[0];
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<=right){
            if(nums[left]<nums[right]){//This is the case when left and right are within a normal sorted array or subarray.
                result=Math.min(result, nums[left]);//In normal sorted array, smallest is the leftmost
                break;
            }
            mid=(left+(right-left)/2);
            result=Math.min(result,nums[mid]);
            //Now to check if currentMid is part of left side or right side
            if(nums[mid]>=nums[left]){//we are in left side, check right then cz right will always have smaller
                left=mid+1;
            }else{
                right=mid-1;//we are in right side and everything to the right of right side will be larger so we check left.
            }
            
        }
        return result;
        
    }
}