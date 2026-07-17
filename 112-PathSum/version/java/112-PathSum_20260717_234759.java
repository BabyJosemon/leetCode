// Last updated: 17/07/2026, 23:47:59
1/**
2 * Definition for a binary tree node.
3 * public class TreeNode {
4 *     int val;
5 *     TreeNode left;
6 *     TreeNode right;
7 *     TreeNode() {}
8 *     TreeNode(int val) { this.val = val; }
9 *     TreeNode(int val, TreeNode left, TreeNode right) {
10 *         this.val = val;
11 *         this.left = left;
12 *         this.right = right;
13 *     }
14 * }
15 */
16 /**Like every DFS question with backtracking ask the question "If I'm at a node in the tree, what values do I need from
17 my child to tell if there's a path from the root to a leaf that sums to the target?" To have such a path, the sum of 
18 the nodes from the left child OR right child should be target-root.val. This is the question that will be used on each
19 node. For base cases, if node is null then we have no child and we return false. This is only for when you are given a
20 null input.
21 The main base case is when you reach a leaf node. Since at each node we are checking if its children have target-root.val
22 We know then that by the time we reach leaf the target has shrunk down to each the value of the leaf or not. If not, 
23 return false else return true.
24 Remeber we recurse left and right but we always send back target-root.val
25
26  Base Case
27If our current node is None, then our subtree is empty and there's no path from the current node to a leaf that sums to the target.
28If our current node is a leaf node, then we check if the target is equal to the leaf node's value. If it is, then there's a path from the current node to a leaf that sums to the target.
29  Helper Functions
30We need to pass the current target down from parent to children nodes, but this is included in the function signature of the main function, so we don't need to introduce a helper function.
31  Global Variables
32The return value of each recursive call matches the answer to the problem, so we don't need to use any global variables.
33 T*/
34class Solution {
35    public boolean hasPathSum(TreeNode root, int targetSum) {
36        if(root==null){
37            return false;//only if we got a null input
38        }
39        if(root.left==null&&root.right==null){
40            return targetSum==root.val;//if at leaf, the value of target is same as leaf i.e. path found.
41        }
42        //the question we ask at each root
43        //does the sum of left child equal target-root.val?
44        boolean leftHasPathSum = hasPathSum(root.left, targetSum-root.val);
45        //or does the sum of the right child equal target-root.val?
46        boolean rightHasPathSum = hasPathSum(root.right, targetSum-root.val);
47        return leftHasPathSum || rightHasPathSum;
48    }
49}