class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> cache = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!cache.add(nums[i])){
               return true; 
            }
        }
        return false;
    }
}