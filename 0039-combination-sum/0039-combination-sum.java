class Solution {
    public void backtrackHelper(List<List<Integer>> result, List<Integer> currentList, int[] candidates, int currentTarget, int start){
        if(currentTarget<0){
            return;
        }else if(currentTarget==0){
            result.add(new ArrayList<>(currentList));
        }else{
            for(int i=start; i<candidates.length; i++){
                currentList.add(candidates[i]);
                backtrackHelper(result, currentList, candidates, currentTarget-candidates[i], i);
                currentList.remove(currentList.size()-1);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result= new ArrayList<>();
        backtrackHelper(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
}