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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        Deque<TreeNode> deque=new ArrayDeque<>();
        deque.offer(root);
        int currentQueueLength;
        List<Integer> currentLevel;
        TreeNode currentNode;
        while(!deque.isEmpty()){
            currentQueueLength=deque.size();
            currentLevel=new ArrayList<Integer>();
            for(int i=0;i<currentQueueLength;i++){
                currentNode=deque.poll();
                currentLevel.add(currentNode.val);
                if(currentNode.left!=null){
                    deque.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    deque.offer(currentNode.right);
                }
            }
            result.add(currentLevel);
        }
        return result;
        
        
    }
}