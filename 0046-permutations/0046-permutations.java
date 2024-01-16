class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result= new ArrayList<>();
        Queue<List<Integer>> allPermutations = new LinkedList<>();
        allPermutations.add(new ArrayList<>());
        for(int i: nums){
            int totalNumberOfPermutations=allPermutations.size();
            for(int j=0;j<totalNumberOfPermutations;j++){
                List<Integer> oldPermutation=allPermutations.poll();
                for(int k=0;k<=oldPermutation.size();k++){
                    List<Integer> newPermutation=new ArrayList<>(oldPermutation);
                    newPermutation.add(k,i);
                    if(newPermutation.size()==nums.length){
                        result.add(newPermutation);
                    }else{
                        allPermutations.add(newPermutation);
                    }
                }
            }
        }
        return result;
    }
}