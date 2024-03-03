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
/*
This can also be done using backtracking with DFS. The idea is we iterate through the input array and at each num we have a 
binary choice. To either add num[i] to the resultant list or to not add. So we keep branching. eg. [1,2,3] initially result=[]
nums[0] gives first choice, we either add 1 to form [1] or we dont to stay []. In the next iteration for both these branches 
we can either add nums[1] or not. From [1] we get 2 branches, [1,2] and [1]. From [] we get, [2] and []. Then again choice at
nums[2], from[1,2],[1] branch we get: [1,2,3] [1,2] [1,3] [1] and from [2], [] we get: [2,3] [2] [3] []. These 8 are our result.
In code with DFS we will first go down the path of adding all first so [1,2,3] then remove last added so [1,2].
Code:
```
class Solution{

    public List<List<Integer>> subsets(int[] nums) {
    
        List<List<Integer>> subsetsResult= new ArrayList<>();
        List<Integer> currentSubset= new ArrayList<>();
        
        public void subsetDFS(int i){
            if(i>=len(nums)){
                subsetsResult.add(currentSubset);
                return;
            }
            currentSubset.add(nums[i]) //left subtree
            subsetDFS(i+1);
            
            currentSubset.pop() //backtracking into right subtree
            subsetDFS(i+1);
        }
        return subsetsResult;
    }
}
```
*/