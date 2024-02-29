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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if(root==null){
            return result;
        }
        ArrayDeque<TreeNode> deque=new ArrayDeque<>();
        deque.offer(root);
        while(deque.size()!=0){
            int currentLevelSize=deque.size();
            ArrayDeque<TreeNode> currentLevelNodes=new ArrayDeque<>();//using queue here, can use stack as well
            for(int i=0;i<currentLevelSize;i++){
                TreeNode currentNode=deque.poll();
                currentLevelNodes.offerFirst(currentNode);
                if(currentNode.left!=null){
                    deque.offer(currentNode.left);
                }
                if(currentNode.right!=null){
                    deque.offer(currentNode.right);
                }
            }
            result.add(currentLevelNodes.poll().val);
        }
        return result;
    }
}