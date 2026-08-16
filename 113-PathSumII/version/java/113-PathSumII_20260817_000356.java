// Last updated: 17/08/2026, 00:03:56
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
16 /**
17 Now the question wants to track a list of such paths which means there are more than 1. Also means we need to keep track of a global result list and pass it along with each call. We will only add to this when we reach the leaf and the leaf.value = target at that point similar to PathSum1. 
18
19The other thing to keep track here is how to build such a list. For that we need to keep track of each node added to a path from root to leaf so that ultimately when we reach the leaf, if its value = target then we can add the list of nodes we have seen to reach here to the result list we also have.
20So in each iteration we add the currentNode.val to this currentList but:
21Suppose we reach node 11, list of nodes seen till now =[5,4,11] we branch left and right.
22
23Suppose we reach leaf node 7 and we see it is not equal to target, the node list we have till now will be [5,4,11,7] but we continue left and right and we reach nulls. In PathSum1 we could have return false but here we dont return anything because knowing that we have reached past a node without a valid path does us nothin and because we need to keep going. So we return empty. Then we have gone to both children of 7 but found nothing so we need to backtrack and for that remove 7 from our list. This makes the list [5,4,11] again and then the right side [5,4,11,2] starts. And once this is done, the 
24list backtracks all the way upto [5] so that [5,8] and so on could start.
25 */
26class Solution {
27    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
28        List<List<Integer>> finalResult = new ArrayList<>();
29        List<Integer> currentList = new ArrayList<>();
30        dfs(root, targetSum, currentList, finalResult);
31        return finalResult;
32    }
33
34    private void dfs(TreeNode root, int currentTarget, List<Integer> currentList, List<List<Integer>> finalResult) {
35        if (root == null) {
36            return;
37        }
38        currentList.add(root.val);
39        if (root.left == null && root.right == null && root.val == currentTarget) {
40            //finalResult.add(currentList) would be wrong her as that is adding a mutable list to the finalResult, This
41            //mutable list is then modified in line 38 so always pass a copy of currentList so that backtracking changes
42            //are not reflected. Answere here would be [[],[]...]
43            finalResult.add(new ArrayList<>(currentList));
44        }
45        dfs(root.left, currentTarget - root.val, currentList, finalResult);
46        dfs(root.right, currentTarget - root.val, currentList, finalResult);
47        //we have reach the end of a given path and we might or might not have added to final result, anyway remove last 
48        //added val from currentList to continue the path to go elsewhere
49        currentList.remove(currentList.size() - 1);
50    }
51}