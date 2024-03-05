Here's how the backtracking algorithm works:
​
We start with an empty combination and the target sum.
At each step, we have two choices for each candidate:
Include the candidate in the current combination.
Exclude the candidate from the current combination.
We make a recursive call to explore both possibilities.
When we include a candidate, we add it to the current combination and make a recursive call with the remaining sum.
When we exclude a candidate, we simply make a recursive call without adding it to the combination.
We continue this process until we have either found a valid combination (remaining sum is 0) or overshot the target (remaining sum is negative).
If we find a valid combination, we add it to the result list.
​