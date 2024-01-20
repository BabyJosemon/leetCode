/*
Again we bank on the idea that rotating a sorted array creates 2 sides, left side with larger elements which were originally at the end of the unrotated array, and right side with smaller elements that were originally at the beginning of the unrotated array. This is similar to finding minimum in sorted array, We do the same in that we will start a regular binary search eg. consider [3,4,5,6,7,8,9,0,1,2], target=7. assume mid=6, we check to see that we are in the left side (arr[mid]>=arr[left]).
If we are in left side:
   -If now the target is larger than mid eg.7 then it means that we need to search on the right as all elements to left of mid will definitely be smaller than target too. 
   -If not, the target is smaller than mid eg.0 it can be on two sides 3-5 or 7-2. We now use the property that the smallest element in left side is the leftmost element.
        -If target is smaller than even this leftmost element eg.0 then it cannot be in 3-5 range so check 7-2 range.
        -If target is not smaller eg.4 then it has to be in the 3-5 range.
If we are in right side:(eg. mid=1)
   -If now the target is smaller than mid eg.0 then it means that we need to search on the left as all elements to right of mid will definitely be larger than target too. 
   -If not, the target is larger than mid eg.4 it can be on two sides 3-0 or 2-2. We now use the property that the largest element in right side is the right element.
        -If target is larger than even this rightmost eg.4 element then it cannot be in 2-2 range so check 3-0 range.
        -If target is not larger eg.2 then it has to be in the 2-2 range.
*/
class Solution {
    public int search(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        int mid;
        while(left<=right){
            mid=(left+(right-left)/2);
            if(nums[mid]==target){
                return mid;
            }
            ///////We are at the Left Sorted Side
            if(nums[mid]>=nums[left]){//this means we on the left side and smallest value is leftmost edge of array eg. mid=6
                if(target>nums[mid]){//if target is still larger than mid then it has to be on right side. eg.7
                    left=mid+1;
                }else{//if target is smaller eg.0 then it can be on both sides 3-5 or 7-2
                    if(target<nums[left]){//this means that none of the elements on left of mid can be possible
                        left=mid+1;
                    }else{//eg.5
                      right=mid-1;  
                    }
                }
                
            }else{
            ///////We are at the Right Sorted Side
                //we on right side largest here is the right most edge value eg. mid=1
                if(target<nums[mid]){//eg.0 then this means that none of the elements on the right can be possible targets as they are all larger than mid
                    right=mid-1;
                }else{//if target is greater than mid eg. 8, it can be on two sides 3-0 or 1-2
                    if(target>nums[right]){//the rightmost is the largest in right side, if target is even larger it cannot be in right of right side
                        right=mid-1;
                    }else{//eg.2
                        left=mid+1;
                    } 
                }
            }
            
        }
        return -1;  
    }
}