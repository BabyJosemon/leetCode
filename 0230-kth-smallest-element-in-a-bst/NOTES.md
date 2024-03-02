we do the same as we did in 98. Validate Binary Search Tree. It is given that this is a bst and
when we do a inorder traversal of a bst we always get an ascending sorted list. So retrieve
that list and return the k-1'th element (1-indexed).
We can optimise this by only doing inorder traversal till the kth element by keeping track of a global counter.