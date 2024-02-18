Java int to binary= Integer.toBinaryString() or Integer.toString(n,2)
Python = "{0:b}.format(n)"
keep a flag(gate) to check if a 1 has been encountered before and another(closedAtLeastOnce) to keep track of atleast two 1's being in binary.
Iterate through the array:
-If we see a 1,
-check if its the first (flag is still false) then change it to true(This is so that when we see a 0
we will only increment gap(currentSize) if flag is true)
-if flag is true then that means we have encountered an opening 1 before, find maxSize till
here, set the currentSize back to 0 and set closedAtLeastOnce to true.
-else we see a 0, only increment if flag is true.
​
At the end check if closedAtLeastOnce is true (eg. "001000") if it is return maxSize+1. Else just return 0 as the gate was never closed.