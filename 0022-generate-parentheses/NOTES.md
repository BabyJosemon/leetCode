this question uses backtracking similar to DFS where we have choices of adding '(' or ')'
based on some rules and this decision splits into branches. So we need to keep track of
how many open and closed paranthesis we have at each moment. The rules are:
1) At no moment can open and closed be greater than n.
2) If Open is less than n we have an option of adding '('.(eg. "(()")
3) if closed is less than open we have an option of adding ')'. (eg. "(()")
4) if at any time open=closed=n, then return as possible solution.
[Tree](http://imgur.com/Xj076XI)
​
Some other considerations:
We will create a nested function as we need to keep access to n, currentString without
passing them.
We will use a stack to store currentString as it is easier to remove last added paranthesis
from stacks than from list. (Python impl)
In my java impl Here we dont need to remove using pop() as we are passing the string
with the method call so every method call has a different string