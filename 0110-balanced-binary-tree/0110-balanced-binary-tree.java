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
    boolean balancedFlag;
    public int helper(TreeNode currentNode){
        if(currentNode==null){
            return 0;
        }
        int leftSubTreeMaxHeight=helper(currentNode.left);
        int rightSubTreeMaxHeight=helper(currentNode.right);
        if(Math.abs(rightSubTreeMaxHeight-leftSubTreeMaxHeight)>1 || !balancedFlag){
            balancedFlag=false;
        }
        return Math.max(leftSubTreeMaxHeight, rightSubTreeMaxHeight)+1;
    }
    public boolean isBalanced(TreeNode root) {
        balancedFlag=true;
        helper(root);
        return balancedFlag;
    }
}