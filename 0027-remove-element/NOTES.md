This can also be solved using two pointer approach where we have 2 pointers i and index.
Iterate through i:
if i != val:
put arr[index]=arr[i]
index++
else:
dont increment index
return index