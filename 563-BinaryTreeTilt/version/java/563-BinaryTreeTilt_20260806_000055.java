// Last updated: 06/08/2026, 00:00:55
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
16 /**DFS Decision Checklist — Calculate Tilt
17 *
18 * 1) What does each call need to RETURN?
19 *    Not the same as "what I need to compute tilt." I need left sum AND
20 *    right sum, but a function can only return ONE value. So the real
21 *    question is: what's the single number my PARENT needs from me?
22 *    → Parent needs my total subtree sum (to compute its own tilt).
23 *    → So return = subtree sum, NOT tilt.
24 *
25 * 2) Base case: node == null → return 0.
26 *    Nothing to sum, nothing to recurse into.
27 *
28 * 3) What does the current node do with left/right before returning?
29 *    This is where the actual problem requirement lives.
30 *    tilt += Math.abs(left - right)   ← the problem's definition of tilt,
31 *    applied at this node, using the sums pulled up from below.
32 *
33 * 4) Why "left + right + node.val" for the return?
34 *    Contract from Q1: "each call returns the sum of its OWN subtree."
35 *    My subtree = my left subtree + my right subtree + myself.
36 *      left      = sum of left subtree  (recursive call honors same contract)
37 *      right     = sum of right subtree (same)
38 *      node.val  = me, not included in either left or right
39 *    So the formula isn't derived by trial — it's just the definition of
40 *    "subtree sum" written in code. Sanity check for any DFS return:
41 *    does this match what I claimed I'd return, one level up?
42 4) Do I need helper methods? Ideally Only needed when a parent must pass information down to its children (a running
43  sum, a min/max bound, the path so far) — and that information doesn’t already fit in your main function’s signature.
44   The helper adds the extra parameter(s). We need it here but for only because of Point 5 as, since we are using a global variable to store the total tilt of the tree, we should define tilt inside the body of our main function, and then introduce a helper function to perform the recursive calls. This way, no code outside of the main function will have access to the tilt variable.
45 5) Do I need a global variable? Yes I do because this question wants to return something about the whole tree. 
46 Something returned affter aggregating all nodes of the tree. Or something collected. This will be the tilt.
47 */
48class Solution {
49    private int tilt=0;
50    public int findTilt(TreeNode root) {
51        dfs(root);
52        return tilt;
53    }
54    private int dfs(TreeNode currentNode){
55        if(currentNode==null){
56            return 0;
57        }
58        int left = dfs(currentNode.left);
59        int right = dfs(currentNode.right);
60        tilt+=Math.abs(left-right);
61        return left+right+currentNode.val;
62    }
63}