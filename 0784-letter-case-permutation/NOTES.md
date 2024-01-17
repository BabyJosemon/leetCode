This is similar to subset question:
We create an empty list result, add initial string to it.
Then we run a loop for each char in string s:
If s.charAt(i) is letter only then we do the following, for others like digits we skip this:
We see how many permutations in result.
Then we take a copy of the permutations in it and for each copy we take the ith letter from them and swap its case. We add the resultant string back into result.
[Flowchart](https://imgur.com/YRD2WYQ)