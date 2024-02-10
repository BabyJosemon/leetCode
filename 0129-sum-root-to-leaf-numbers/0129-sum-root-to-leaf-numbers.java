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
 
 DFS basic formula: each path number eg 12= 1*10+2. So at each iteration multiply previously calculated sum by 10 and add the 
 current value to it. If we do reach leaf, return the sum until that point. otherwise recursively call the function to left and right subtree
 */
class Solution {
    public static int helper(TreeNode currentNode, int currentSum){
        if(currentNode==null){
            return 0;//if empty input
        }
        currentSum=10*currentSum+currentNode.val;
        if ((currentNode.left==null)&&(currentNode.right==null)){
            return currentSum;//when we reach the leaf node
        }
        return helper(currentNode.left, currentSum)+helper(currentNode.right, currentSum);//otherwise iteratively go down
    }
    
    public int sumNumbers(TreeNode root) {
        int pathSum=0;
        return helper(root, pathSum);
    }
}