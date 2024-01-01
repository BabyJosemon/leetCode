because this is sorted, get each element and then run binary search on remaining elements to find the remaining number.
​
Or we can use two pointer where :
```
left,right=0,len(number)-1
while(left<right):
sum=numbers[left]+numbers[right]
if sum>target:
right-=1
elif sum<target:
left+=1
else:
return [left+1, right+1]
```