class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result= new ArrayList<>();
        Set<List<Integer>> partial = new HashSet<>();
        for(int i=0;i<nums.length;i++){
            int firstPointer=i+1;
            int secondPointer=nums.length-1;
            while(firstPointer<secondPointer){
                int sum=nums[i]+nums[firstPointer]+nums[secondPointer];
                if (sum>0){
                    secondPointer--;
                }else if(sum<0){
                    firstPointer++;
                }
                else{
                    partial.add(Arrays.asList(nums[i],nums[firstPointer],nums[secondPointer]));
                    firstPointer++;
                    secondPointer--;
                }
            }
        }
        result.addAll(partial);
        return result;
    }
}
