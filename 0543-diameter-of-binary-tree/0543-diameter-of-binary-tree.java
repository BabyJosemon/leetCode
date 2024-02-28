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
 This question uses the diameter approach from grokking but here we need the number of edges in the diameter and not the 
 actual diameter(number of nodes) so we dont need to add 1 to the currentDiameter of a node.
 
 
 This is a medium question and we use DFS again. Because we need the max diameter, we use a global variable. For each
 node just find the diameter from that node and check if its larger than global variable. If it is, swap.for this:
1) Similar to DFS at each node we need the depth/height of its left and right subtree, so we make 2 recursive calls to both sides
2) The diameter with a node A at center will be sum of its left and rightSubtree height+1
3) The height of the current node is equal to the maximum of the heights of its left and right subtree +1 (count itself) eg. for node 1 it is max(2,1)+1=3.
4) normally we return the value we are searching for (treeDiameter here) but bcs it is a global variable we dont need to 
do that, instead we return the height of that node at end. which is max(leftSubTreeHeight, rightSubTreeHeight)+1.
Eg. at node(4), leftSubTreeHeight and rightSubTreeHeight will return 0, this makes currentDiameter=1 and then for node(2)'s
leftSubTree we just return height of node(2) instead of the diameter.

Dont bother with point 4, we are returning the heights like in max depth of tree question.
 */
class Solution {
    int treeDiameter;
    
    public int helper(TreeNode currentNode){
        if(currentNode==null){
            return 0;    
        }
        int leftSubTreeHeight=helper(currentNode.left);
        int rightSubTreeHeight=helper(currentNode.right);
        
        int currentDiameter=leftSubTreeHeight+rightSubTreeHeight;//we are not adding 1 as we only need the no. of edges
        treeDiameter=Math.max(treeDiameter, currentDiameter);
        
        return Math.max(leftSubTreeHeight, rightSubTreeHeight)+1;//here the +1 is the edge that connects the parent to child
        
    }
    public int diameterOfBinaryTree(TreeNode root) {
        
        treeDiameter=0;
        if(root==null){
            return 0;
        }
        helper(root);
        return treeDiameter;
    }
}