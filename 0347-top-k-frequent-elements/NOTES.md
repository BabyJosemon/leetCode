Here we will use bucket sort, we create a frequency distribution eg.{1:3,2:2,3:1} then we create a bucket array that will store Lists of type integer and the key in the bucketList[freq[key]] position. This means that 1 will be stored in index 3, 2 at index 2, and 3 at index 1. This is also why the bucket list will have size nums.length+1 as the length will be limited to the max frequency. Then we just retrieve k values from the back of the bucketList. Each element of the bucketList is made a list so that if we have values with same frequency then they need to be accounted for as well.
OR
This can also be solved using heaps where we usually tackle top k problems. we will still
create a frequency hashmap. Then it is just the matter of finding top k largest frequencies.
So we use a minheap with comparator made using Map.entry values(). Then when the size
of minheap exceeds k just pop top root. This makes sure that only the  largest will remain at
the end.