Here we use minheap implemented using PriorityQueue and first add k elements to the
minheap, this means that the smallest is stored in root. After that iterate through the rest of
the elements and:
1) if nums[i] is larger than root of minheap, then remove the root and add this larger value
to minheap.
​
2) else dont bother.
This means that at the end we will be left with k largest elements from the array and the
root will the kth largest.
​