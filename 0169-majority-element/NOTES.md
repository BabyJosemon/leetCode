Another way is to have 2 variables, count and a candidate. set count=1, candidate=arr[0]
Iterate through the array,
everytime we see the candidate again, increment count by 1 else decrement by 1.
if count ever becomes 0, change the candidate to whatever arr[i] decreased it to 0.
So [2,2,1,1,1,2,2] i=0, count=1, candidate=2
i=1, count=2, candidate=2
i=2, count=1, candidate=2
i=3, count=0, candidate=1
i=4, count=1, candidate=1
i=5, count=0->count=1, candidate=2
i=6, count=2, candidate=2
return  candidate
​