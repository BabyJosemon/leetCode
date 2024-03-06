Duplicates in maxheap are also added while maintaining order so in example 1 the
maxheap formation will look like:
[1]
[5,1]
[9,5,1]
[10,9,5,1]
[11,10,9,5,1]
[13,11,10,9,5,1]
[13,12,11,10,9,5,1]
[13,13,12,11,10,9,5,1]
[15,13,13,12,11,10,9,5,1], now size =9 greater than 8 so remove root
[13,13,12,11,10,9,5,1] return root now which is the 8th smallest.
​
If it was a minheap:
[1]
[1,5]
[1,5,9]
[1,5,9,10]
[1,5,9,10,11]
[1,5,9,10,11,13]
[1,5,9,10,11,12,13]
[1,5,9,10,11,12,13,13]
[1,5,9,10,11,12,13,13,15], now size=9 greater than 8 so remove root
[5,9,10,11,12,13,13,15], root=5 is the 8th largest
​