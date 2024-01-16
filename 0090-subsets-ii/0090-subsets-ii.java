class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> subsetResult=new ArrayList<>();
        subsetResult.add(new ArrayList<>());
        int startingPoint=0, endPoint=0;
        for(int i=0;i<nums.length;i++){
            int subsetSize=subsetResult.size();
            startingPoint=0;
            if(i>0 && nums[i]==nums[i-1]){
                startingPoint=endPoint+1;//only copy subsets added in previous step and not prior ones.
            }
            endPoint=subsetSize-1;
            for(int j=startingPoint;j<=endPoint;j++){
                List<Integer> copy=new ArrayList<>(subsetResult.get(j));
                copy.add(nums[i]);
                subsetResult.add(copy);
            }
        }
        return subsetResult;
        
        
    }
}