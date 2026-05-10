// Last updated: 10/05/2026, 20:46:21
//This is similar to two pointers, except we use another pointer that points to the last of the larger arr1. This is 
//because arr1 has extra 0s that are to use used to replace with the correct numbers so that the result array is in arr1
//and not a new array. 
//Interesting point here that instead of starting at beginning and end of array like normal, we start both pointers at
//the end of the arrays. Compare each value and whichever is bigger gets put in.
//So two pointers that start at the end of both arr1 and arr2 and third pointer that starts at 
//the end of arr1+arr2 -1. This is going to be the size of the resultant array anyway.
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int firstPointer=m-1;
        int secondPointer=n-1;
        int thirdPointer=m+n-1;
        while(firstPointer>=0 && secondPointer>=0){
            if(nums1[firstPointer]<nums2[secondPointer]){
                nums1[thirdPointer]=nums2[secondPointer];
                secondPointer--;
            }else{//else here being (nums1[firstPointer]>=nums2[secondPointer])
                nums1[thirdPointer]=nums1[firstPointer];
                firstPointer--;
            }
            thirdPointer--;//thirdPointer decrememnts everytime
        }
        while(firstPointer>=0){
            nums1[thirdPointer]=nums1[firstPointer];
            firstPointer--;
            thirdPointer--;
        }
        while(secondPointer>=0){
            nums1[thirdPointer]=nums2[secondPointer];
            secondPointer--;
            thirdPointer--;
        }
    }
}