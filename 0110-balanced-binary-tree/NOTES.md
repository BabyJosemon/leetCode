Balanced Binary tree is a tree where at every node the difference of the number of nodes on its right and left subtree is 1 or 0. For this to happen again use a helper method.
Set a flag as true first, Recursively find max height of left and right subtree. This means set
base cases and also at the end return max of left and right. And if anytime
their difference is greater than 1 or the flag is false, Then reinforce the flag as false.