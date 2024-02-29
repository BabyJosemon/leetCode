Use DFS, we need 2 methods here, 1 that iterates through the root tree and another that checks if the subtree that we are considering from root tree is equal to subroot tree. Luckily we have an algo that does that. These are the scenarios:
1) if subroot is null then just return true as [] is a subset of every tree
2) if root is null then at this point bcs (1) was not triggered we know that subRoot is not null,
and in that scenario if root is null and subRoot!=null then return false.
3) if both root and subRoot are non null then check if their subTrees are equal using helper
method.
If point 3 returns false for any reason, eg in example 1 then we need to keep checking if
any further subtree of root's left or right are equal to subTree. So to keep the loop going:
4) Move to root.left and check if same as subTree and do the same to root.right. If either of them pass return true.