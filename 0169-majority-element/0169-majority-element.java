class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> cache= new HashMap<Integer, Integer>();
        int answer=0;
        for(int i: nums){
            Integer count = cache.get(i);
            if(count==null){
                cache.put(i,1);
            }else{
                cache.put(i, count+1);
            }
        }
        for(int j: cache.keySet()){
            int count=cache.get(j);
            if(count>nums.length/2){
                answer=j;
            }
        }
        return answer;
    }
}