// Last updated: 23/09/2026, 23:23:48
// Used Integer.MIN_VALUE because of trees with only negative values. Since every node is negative, every level sum is negative. 0 is never less than any of them so result never updates and stays at 0. This is also why result starts at 1 so that it default to level 1 since root always exists.
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
17    public int maxLevelSum(TreeNode root) {
18        //dont need to check this because of input constraint provided but still...
19        if(root==null){
20            return 0;
21        }
22        Queue<TreeNode> queue = new LinkedList<>();
23        queue.offer(root);
24        int currentLevel=0;
25        int maxSumTillNow=Integer.MIN_VALUE;
26        int result=1;
27        while(!queue.isEmpty()){
28            currentLevel+=1;
29            int currentLevelSize = queue.size();
30            int currentLevelSum=0;
31            for(int i=0;i<currentLevelSize;i++){
32                TreeNode currentNode = queue.poll();
33                currentLevelSum+=currentNode.val;
34                if(currentNode.left!=null){
35                    queue.offer(currentNode.left);
36                }
37                if(currentNode.right!=null){
38                    queue.offer(currentNode.right);
39                }
40            }
41            if(maxSumTillNow<currentLevelSum){
42                maxSumTillNow = currentLevelSum;
43                result = currentLevel;
44            }  
45        }
46        return result;
47    }
48}