For this question you have to understand BST and its property during an inorder traversal.
Inorder traversal of a tree is left,root,right. So for first example the inorder is [1,2,3]. And
for any BST to be valid, their inorderList will always be in ascending order. So create an
empty list globally (or static). Use a helper method that traverses through the tree and
populates this list inorder (ie call the recursive function on left, add currentNode, call the
recursive function on the right). Once this is done, just iterate through this array is main
method and if at any instance arr[i]>arr[i+1] return false, else return true at end.