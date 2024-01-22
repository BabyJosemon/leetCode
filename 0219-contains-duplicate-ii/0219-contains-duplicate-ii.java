class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> cache=new HashMap<>();
        int distance;
        for(int i=0;i<nums.length;i++){
            if(!cache.containsKey(nums[i])){
                cache.put(nums[i],i);//add if not seen yet
            }else{
                distance=Math.abs(cache.get(nums[i])-i);
                if (distance<=k){
                    return true;
                }else{
                  cache.put(nums[i],i);//This was added for cases like [1,0,1,1] where distance of first 2 1s is greater than k
                    //but the distance between next 1s is less than 1 so we should return true. So if we see a duplicate but
                    //its distance is not smaller than or equal to k, we update cache with this index so that if another 
                    //duplicate occurs, we check its distance with this one and not the previous.
                }
            }    
        }
        return false;
    }
}