- Here we will use the same method as before and also have some additions of our own.
- we will sort the numbers first so that duplicates stay together.
- and when we do find a number repeated we will not add it to all existing items in the result subset but only to the items that were added at the last step.
- this means that we will have to keep track of our previously added values everytime. Thankfully we are adding them sequentially so we keep 2 pointers start and end.
- initially both will be 0, everytime we start the first loop start will be set to 0, and every time end will be original subset size -1 so that we know how much range we are copying. This keeps track of our end. After that we do the copying between our start and end..
- if we see that nums[i] == nums[i-1] ie duplicate, we will set start to end+1. This is because end was currently pointing to last of previous subsetSize which means the new values were added after this end. So if we set our start to this end+1., we effectively only consider values added in last iteration.
​
[FlowChart](https://imgur.com/JqFsRWL)