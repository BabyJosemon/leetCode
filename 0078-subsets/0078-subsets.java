class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> subsetsResult= new ArrayList<>();
        subsetsResult.add(new ArrayList<>());//empty subset
        for(int i=0;i<nums.length;i++){
            int sizeOfSubsets=subsetsResult.size();//have to take this before else we might add to elements we dont want to.
            for(int j=0;j<sizeOfSubsets;j++){
                List<Integer> copy=new ArrayList<>(subsetsResult.get(j));
                copy.add(nums[i]);
                subsetsResult.add(copy);
            }    
        }
        return subsetsResult;  
    }
}