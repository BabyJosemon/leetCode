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
    public boolean helperCheckTreeSame(TreeNode root, TreeNode subRoot){
        if(root==null || subRoot==null){
            return root==subRoot;
        }
        return root.val==subRoot.val && helperCheckTreeSame(root.left, subRoot.left) && helperCheckTreeSame(root.right, subRoot.right);
    }
    
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){//if subRoot empty cz [] is a subset of any tree
            return true;
        }
        if(root==null){//if we are here we know that subRoot!=null and hence if root=null then just return false
            return false;
        }
        if(helperCheckTreeSame(root, subRoot)){//if root!=null and subRoot!=null then check their subroots
            return true;
        }
        //now if the 3rd if returns false for any reason we need to recursively check the same for root's left and right
        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }
}