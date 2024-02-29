We will use DFS here, bcs we have to keep track of a counter we will have it global (or static).
The basic idea is that we need nodes that are set in increasing order. So, we will call our helper function with the root and a min value. The idea is at each node we keep track of a
max variable. If the currentNode's value is greater than or equal to max, then we will
increment the counter else we dont.