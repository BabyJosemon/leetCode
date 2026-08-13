// Last updated: 13/08/2026, 23:37:53
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
15 *//**
16 * DFS Decision Checklist — Diameter of Binary Tree
17 * Diameter = longest path (in edges) between any two nodes, may or may not pass through root.
18 *
19 * 1) What does each call need to RETURN?
20 *    Not diameter — same trap as tilt. Diameter is a "final answer" for a
21 *    node, not reusable info. Test: can parent compute ITS answer from my
22 *    diameter alone? No — parent needs to know how DEEP my subtree goes,
23 *    not what the longest path inside it already was.
24 *    → So return = HEIGHT (max depth) of my subtree, not diameter.
25 *      This is reusable: parent's height = 1 + max(child heights).
26 *
27 * 2) Base case: node == null → return 0.
28 *    An empty subtree has height 0 (no nodes, no edges).
29 *
30 * 3) What does the current node do with left/right before returning?
31 *    This is where the real problem requirement lives — same slot as
32 *    tilt's Math.abs(left-right) line.
33 *    The longest path THROUGH this node = leftHeight + rightHeight
34 *    (edges down to the deepest left leaf, plus edges down to the
35 *    deepest right leaf). Compare that against the global max:
36 *      diameter = Math.max(diameter, left + right);
37 *
38 * 4) Why "1 + Math.max(left, right)" for the return — NOT left+right+1?
39 *    Contract from Q1: "each call returns the HEIGHT of its own subtree."
40 *    Height = 1 (edge down to my taller child) + that child's height.
41 *    I only continue down ONE path upward (whichever side is taller) —
42 *    I don't get credit for both sides once I'm reporting to my parent.
43 *    (left + right is the DIAMETER through me — that's Q3's job, not
44 *    the return.)
45 *
46 * 5) Global needed? Yes — same reason as tilt: diameter is the max
47 *    over ALL nodes in the tree, not something a parent needs handed
48 *    to it. It's collected as a side effect, not returned.
49 *
50 * 6) Helper method needed? Same reason as tilt — keep `diameter` private
51 *    inside findDiameter(), use a helper dfs() to recurse without
52 *    exposing the accumulator outside the class.
53 */
54class Solution {
55    int diameter = 0;
56    public int diameterOfBinaryTree(TreeNode root) {
57        dfs(root);
58        return diameter;
59    }
60    private int dfs(TreeNode currentNode){
61        if(currentNode==null){
62            return 0;
63        }
64        int left = dfs(currentNode.left);
65        int right = dfs(currentNode.right);
66        diameter = Math.max(diameter, left+right);
67        return 1+Math.max(left,right);
68    }
69}