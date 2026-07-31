// Last updated: 01/08/2026, 00:16:36
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
16/* We follow the same steps everywhere we ask the base question what do i need 
17from my left and right child to see if we are a valid BST rooted at current node?
18We need booleans validating them. This is the return value AND on left and right.
19Our base case, if we reach the null node then we havent seen a false yet so return
20 true. But now think what is a BST and what each node of a valid BST adhere to?
21 Starting at root, left node from root will be smaller than its value. So we need
22 to pass the root (parents) value to recursive call. Since every node under this 
23 left node will always need to be smaller that root, this is passed as the max 
24 value. So each parent nodes value is its left childs max value. Minimum value can 
25 be anything so at root let us assume Integer.MIN_VALUE. 
26 Similarly for right child of root, since it has to be larger than root, the min 
27 value sent is the root.value. And max can be Integer.MAX_VALUE. This can be our 
28 helper method to start the operation and in each operation of left movement we 
29 send the max value as the parent while min remains the same. Similarly for right 
30 movement we send the min value as parent while max remains same. 
31 When will we ever not be BST, when current node's value is either larger than the 
32 max it got or smaller that the min it got. This breaks the pattern and hence will 
33 return false.
34*/
35public class Solution {
36    public Boolean isValidBST(TreeNode root) {
37        // Your code goes here
38        return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
39    }
40
41    public Boolean dfs(TreeNode root, long min, long max) {
42        if (root == null) {
43            return true;
44        }
45        if (root.val >= max || root.val <= min) {
46            return false;
47        }
48        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
49    }
50}