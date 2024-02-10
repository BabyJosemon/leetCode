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
 * Keep subtracting from each node we find until we reach a targetSum and the node is leaf.
 * DFS
 */
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if(root==null){
            return false;//basecase 1
        }
        if(root.left==null && root.right==null && root.val==targetSum){
            return true;//basecase 2
        }
        return (hasPathSum(root.left, targetSum-root.val) || hasPathSum(root.right, targetSum-root.val));
        
    }
}