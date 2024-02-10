/**
 * This is also DFS same as pathsum but here we also keep track of all the paths that fall into our category
 We create an allPaths variable to hold all positive paths and a currentPath that keeps track of what route we are on
 right now. For everytime the helper is called add the currentNode's val into the currentPath. 
 Then check if we have the targetSum and that it is a leaf node. If it is we add the currentPath to the allPaths
 Else
 call helper on the left child and the right child with a reduced targetSum.
 At the end remove the last added node from currentPath. This is because eg(currentPath=[5,4,11,7]) if we reach a leaf node and it is not equal to targetSum then helper will be called again on its left and right and those will be null and return nothing.
 But this 7 will have to be removed so currentPath=[5,4,11] and when we were at 11 earlier we had 2 helpers one to the left and
 one to the right. The left one resulted in the scenario above and now the right one will be considered and as usual 2 will be added. If we had failed here as well then again we will remove the 2, then remove the 11 then 4 and so on till we reach to
 execution of original root's right side.
 So basically the remove is always called after if and else block.
 */
class Solution {
    public static void helper(TreeNode currentNode, int targetSum, List<List<Integer>> allPaths, List<Integer> currentPath){
        if (currentNode==null){
            return;
        }
        currentPath.add(currentNode.val);
        if(currentNode.val==targetSum && currentNode.left==null && currentNode.right==null){
            allPaths.add(new ArrayList<Integer>(currentPath));
        }else{
            helper(currentNode.left, targetSum-currentNode.val, allPaths, currentPath);
            helper(currentNode.right, targetSum-currentNode.val, allPaths, currentPath);
        }
        currentPath.remove(currentPath.size()-1);
        
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> allPaths=new ArrayList<>();
        List<Integer> currentPath=new ArrayList<>();
        helper(root, targetSum, allPaths, currentPath);
        return allPaths;
    }
}