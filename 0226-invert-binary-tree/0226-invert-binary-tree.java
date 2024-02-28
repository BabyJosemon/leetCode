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
    public TreeNode invertTree(TreeNode root) {
        if(root==null){
            return root;
        }
        ArrayDeque<TreeNode> deque=new ArrayDeque<>();
        deque.offer(root);
        while(deque.size()!=0){
            TreeNode currentNode=deque.poll();
            if(currentNode!=null){
                TreeNode temp=currentNode.left;
                currentNode.left=currentNode.right;
                currentNode.right=temp;
                if(currentNode.left!=null){
                    deque.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    deque.offer(currentNode.right);
                }
                
            }
        }
        return root;
        
        
    }
}