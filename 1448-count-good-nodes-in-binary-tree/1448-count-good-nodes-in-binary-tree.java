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
    int counter;
    public void helper(TreeNode currentNode, int max){
        if(currentNode==null){
            return;
        }
        if(currentNode.val>=max){
            max=currentNode.val;
            counter++;
        }
        helper(currentNode.left, max);
        helper(currentNode.right, max);
    }
    public int goodNodes(TreeNode root) {
        counter=0;
        helper(root, Integer.MIN_VALUE);
        return counter;
    }
}