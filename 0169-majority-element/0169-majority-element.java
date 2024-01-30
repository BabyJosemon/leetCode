class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> cache= new HashMap<Integer, Integer>();
        int answer=0;
        int maxFrequency=0;//These will be used to get the max in the cache without traversing the cache again
        int maxFrequencyElement=nums[0];//These will be used to get the max in the cache without traversing the cache again
        for(int i: nums){
            int count = cache.getOrDefault(i, 0) + 1;
            cache.put(i, count);
            if(count>maxFrequency){
                maxFrequency=count;
                maxFrequencyElement=i;
            }
        }
        
        return maxFrequencyElement;
    }
}