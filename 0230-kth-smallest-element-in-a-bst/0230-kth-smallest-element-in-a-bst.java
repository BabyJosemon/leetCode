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
    List<Integer> inorderList;
    public void inorderTraverserHelper(TreeNode currentNode){
        if(currentNode==null){
            return;
        }
        inorderTraverserHelper(currentNode.left);
        inorderList.add(currentNode.val);
        inorderTraverserHelper(currentNode.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorderList=new ArrayList<Integer>();
        inorderTraverserHelper(root);
        return inorderList.get(k-1);
    }
}

/*
class Solution {
    List<Integer> inorderList;
    public void inorderTraverserHelper(TreeNode currentNode, int counter, int k){
        if(currentNode==null){
            return;
        }
        if(counter==k){
            return;
        }
        inorderTraverserHelper(currentNode.left, counter, k);
        inorderList.add(currentNode.val);
        counter+=1;
        inorderTraverserHelper(currentNode.right, counter, k);
    }
    public int kthSmallest(TreeNode root, int k) {
        inorderList=new ArrayList<Integer>();
        int counter=0;
        inorderTraverserHelper(root, counter, k);
        return inorderList.get(k-1);
    }
}*/