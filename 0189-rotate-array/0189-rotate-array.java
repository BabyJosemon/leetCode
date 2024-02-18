class Solution {
    public static void reverseArray(int[] nums, int start, int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
    public void rotate(int[] nums, int k) {
        int rotations=k%nums.length;
        reverseArray(nums, 0, nums.length-rotations-1);
        reverseArray(nums, nums.length-rotations, nums.length-1);
        reverseArray(nums, 0, nums.length-1);
    }
}