//use a set, if value is not in set add it, if it is in set remove it. The last remaining element in set is answer.
//or sort it and return where nums[i]!=nums[i+1]
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Set<Integer> cache=new HashSet<>();
        for(int i=0;i<nums.length;i++){
            if(!cache.contains(nums[i])){
                cache.add(nums[i]);
            }else{
                cache.remove(nums[i]);
            }
        }
        for(Integer i: cache){
            return i;
        }
        return -1;
    }
}