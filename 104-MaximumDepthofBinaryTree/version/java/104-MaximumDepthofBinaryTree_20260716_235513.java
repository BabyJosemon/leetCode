// Last updated: 16/07/2026, 23:55:13
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
16 /**This is a DFS beginner problem. Since we need to find the maximum depth we need DFS as all nodes need to be visited
17 Can be done with recursion and backtracking. Since we recurse into the left and right of a node. Think what would a
18 given node need to calculate its max depth. It will be itself(1) +  maxDepth(left subtree) + maxDepth(right subtree).
19 This is the basis of every DFS backtracking. This is because the max depth of a tree = 1(root) + maxDepth of left + 
20 maxDepth of right subtree. An empty node has no height so that will return 0. 
21 
22 To determine what the return value should be for a different problem, imagine you're at a node in the tree and ask yourself: "What information do I need from my left and right subtrees to solve the problem for my subtree?"
23 eg. Problem
24Find the maximum value in a binary tree
25Explanation
26If I'm at a node in the tree, what values do I need from my left and right subtrees to find the maximum value for my subtree?
27I need to know the maximum value in my left subtree, and the maximum value in my right subtree. The maximum value in my subtree is the maximum of those two values and the value of my node.*/
28class Solution {
29    public int maxDepth(TreeNode root) {
30        if (root == null){
31            return 0;
32        }
33        int leftSubTreeMaxDepth = 1 + maxDepth(root.left);
34        int rightSubTreeMaxDepth = 1 + maxDepth(root.right);
35        return Math.max(leftSubTreeMaxDepth, rightSubTreeMaxDepth);
36        /**Could also have been
37        int leftSubTreeMaxDepth = maxDepth(root.left);
38        int rightSubTreeMaxDepth = maxDepth(root.right);
39        return 1 + Math.max(leftSubTreeMaxDepth, rightSubTreeMaxDepth);
40         */
41    }
42}