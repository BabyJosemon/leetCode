// Last updated: 20/07/2026, 23:44:52
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
16/**This is a DFS question that shows the use of using helper functions that use global variables passed as parameters.
17Similar to all DFS questions ask yourself If I'm at a node in the tree, what values do I need from my left and right
18children to calculate the number of good nodes in the subtree rooted at the current node? 
19I need the good nodes from my left and right subtree. So this is the return value. Once we have that even for the root,
20we can add them and add 1 (for root) to get our answer. So it is a left+right question similar to 104.
21But now how do we get this number? How can we tell if a node is good. It is good if no number before it is larger than
22it. We can keep track of this by keeping tabs on the largest number we have seen yet in each branching. This works 
23because even in 3->1->3 1 is not good but because 3 is largest and was a good value, the max stayed as 3 and the leaf 
243 is greater than or equal to the current max. This current Max is what we pass down from root to the leaf.*/
25class Solution {
26    public int goodNodes(TreeNode root) {
27        return dfs(root, Integer.MIN_VALUE);//initial max value
28    }
29
30    public int dfs(TreeNode root, Integer maxValueTillNow) {
31        if (root == null) {
32            return 0;//no root, no good value
33        }
34        int count = 0;
35        if (root.val >= maxValueTillNow) {
36            maxValueTillNow = root.val;
37            count++;
38        }
39        int leftSubTree = dfs(root.left, maxValueTillNow);
40        int rightSubTree = dfs(root.right, maxValueTillNow);
41        return count + leftSubTree + rightSubTree;//is just the worker saying: "my result + everything left reported +
42        //everything right reported"
43    }
44}