class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> cache = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!cache.contains(nums[i])){
               cache.add(nums[i]); 
            }else{
                return true;
            }
        }
        return false;
    }
}