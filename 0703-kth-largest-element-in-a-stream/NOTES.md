because add() has to return the kth largest number in stream, we need to use minheap as
we did in top k largest element. And in add() it is given that we add first and then return
root, but because we have to maintain a size of k, we delete root if the size goes over k.
This also means that the root at everytime will be the kth largest element as we poll() after
adding to minheap.