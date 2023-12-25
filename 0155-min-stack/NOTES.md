basically have 2 arraylists at the same time. One keeps track of the actual stack and the other keeps track of what is the minimum of the stack, we will keep this minimum at the top of minimumArray everytime, even if we have to copy item in list.
1)Push value = add value to stack as normal, but in minimumArray we might also add the value:
* If minimumArray is empty, add to it normally as we do.
* If minimumArray already has elements, then we will check the "top" element of minimumArray (minArray[-1] or last element). We will compare this last element with the value we currently want to add and will add whatever is the smallest. So eg. if minArray=[-2], if the value to add is 0, minArray= [-2,-2]
2)Pop = since the last element of list is the top of our stack, remove that using stack.length-1. Since minArray is also same length remove last element from there too. eg. stack=[-2,0,-3] minArray=[-2,-2,-3]. Pop removes -3 from both because this makes new minimum -2.
3)Top = same as pop except dont remove just get from stack.
4)GetMin = same as top except from minimum array.