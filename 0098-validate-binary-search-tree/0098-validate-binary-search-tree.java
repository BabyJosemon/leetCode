/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    List<Integer> inorderList=new ArrayList<>();
    public void inorderTraverser(TreeNode currentNode){
        if(currentNode==null){
            return;
        }
        inorderTraverser(currentNode.left);
        inorderList.add(currentNode.val);
        inorderTraverser(currentNode.right);
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root==null){
            return true;
        }
        inorderTraverser(root);
        for(int i=0;i<inorderList.size()-1;i++){
            if(inorderList.get(i)>=inorderList.get(i+1)){
                return false;
            }
        }
        return true;
    }
}