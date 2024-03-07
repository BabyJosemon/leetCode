We follow the exact same approach as 347- Top k frequent elements. The only difference
being that instead of creating a minheap and getting only top k frequent elements, we
create a maxheap and add all Map.Entries. This is so that the priorityQueue stays sorted
and we dont have to sort again.