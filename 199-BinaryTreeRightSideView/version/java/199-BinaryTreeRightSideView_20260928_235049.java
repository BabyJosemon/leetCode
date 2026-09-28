// Last updated: 28/09/2026, 23:50:49
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
16class Solution {
17    public List<Integer> rightSideView(TreeNode root) {
18        if (root == null) {
19            return new ArrayList<>();
20        }
21        List<Integer> result = new ArrayList<>();
22        Queue<TreeNode> queue = new LinkedList<>();
23        queue.offer(root);
24        while (!queue.isEmpty()) {
25            int currentLevelSize = queue.size();
26            for (int i = 0; i < currentLevelSize; i++) {
27                TreeNode currentNode = queue.poll();
28                if (currentNode.left != null) {
29                    queue.offer(currentNode.left);
30                }
31                if (currentNode.right != null) {
32                    queue.offer(currentNode.right);
33                }
34                if (i == currentLevelSize - 1) {
35                    result.add(currentNode.val);
36                }
37            }
38        }
39        return result;
40    }
41}