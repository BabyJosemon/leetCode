Here we follow something similar to the subsets where we use a queue to keep track of all permutations being done to all the numbers seen till now in the list.
For every number i in nums
get all items in allPermutions one by one. For each permutation from allPermutation, convert it into a list call it newPermutation and inset our current number i in all possible positions of newPermutation including the end of newPermutations.
This means we run the loop from 0 to len(newPermutations) inclusive.
When we add it we check if the resultant newPermutation has the length equal to that of nums[] then we add it to a result array.
​
[Flowchart](https://imgur.com/aAQ4rKO)
