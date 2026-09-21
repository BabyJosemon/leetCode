// Last updated: 21/09/2026, 23:06:13
1/**
2BFS gives us clarity over all nodes in a level. This is what we want in this question too. We want to find all nodes in a level and separate them into their own lists. 
3
4This is easy to understand when you see that the algorithm above can be used with little modification to achieve this. 
5
6Understand that whenever the line: 
7*while(!queue.isEmpty())* 
8
9is called, it is called on a queue that is filled with all elements in the current level. This is because when we started with root that was a level. We take a snapshot at this point and we have the first level. The snapshot tells us how many nodes in a level.
10Then we find its children and add it to the queue, at which point the queue has the next level. We take a snapshot again. Snapshot  tells us we have 2 elements in this level.
11
12So we run a loop for the snapshot and during which we process all elements in the snapshot and add its children. 
13
14These children are the next level so until the previous snapshot finishes, this new one does not start.
15
16Once a level is done we add to the main list.
17 */
18/**
19 * Definition for a binary tree node.
20 * public class TreeNode {
21 *     int val;
22 *     TreeNode left;
23 *     TreeNode right;
24 *     TreeNode() {}
25 *     TreeNode(int val) { this.val = val; }
26 *     TreeNode(int val, TreeNode left, TreeNode right) {
27 *         this.val = val;
28 *         this.left = left;
29 *         this.right = right;
30 *     }
31 * }
32 */
33class Solution {
34    public List<List<Integer>> levelOrder(TreeNode root) {
35        if(root==null){
36            return new ArrayList<>();
37        }
38        List<List<Integer>> resultList = new ArrayList<>();
39        Queue<TreeNode> queue = new LinkedList<>();
40        queue.offer(root);
41        while(!queue.isEmpty()){
42            //the snapshot
43            int levelSize = queue.size();
44            List<Integer> currentLevel = new ArrayList<>();
45            for(int i=0;i<levelSize;i++){
46                //run this for each level/snapshot of level
47                TreeNode currentNode = queue.poll();
48                currentLevel.add(currentNode.val);
49                if(currentNode.left!=null){
50                    queue.offer(currentNode.left);
51                }
52                if(currentNode.right!=null){
53                    queue.offer(currentNode.right);
54                }
55            }
56            //one level/snapshot is complete.
57            resultList.add(currentLevel);
58        }
59        return resultList;
60    }
61}