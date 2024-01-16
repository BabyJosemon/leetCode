To make all possible subsets think of this:
​
- Empty list [] is always part of the subsets so add it first to the resultant. ie results = [[]]
- then take the first number in the input (1 here), copy what we have in the current results (ie [] for now) add 1 to it (so [] +1 = [1] ) and add it back into the results. So now results is [[], [1]]
- then again take the next number from input (5 here). Then loop through all elements in results, copy them and add 5 to them and add it in results.
- []+5 = [5] ; [1] + 5 = [1,5]; results = [[], [1], [5], [1,5]]
- repeat this process for all numbers
[Image](https://imgur.com/a/CUJ58FD)
![Subsets Flowchart](http://imgur.com/a/CUJ58FD)