looking at the input[1,2,3,4,5,6,7] and expected output, we can judge that we take k(3)
elements from the rear and put them in the front. (put [5,6,7] in front).
This means that we can think of our input having 2 subarrays; one subarray that is pushed
back ([1,2,3,4]; nums[0:nums.length-k-1]) and another subarray that is put in front
([5,6,7]; nums[nums.length-k: nums.length-1]). This is what we do:
1) Reverse first subarray = [4,3,2,1] in place so array = [4,3,2,1,5,6,7]
2) Reverse second subarray = [7,6,5] in place so array = [4,3,2,1,7,6,5]
3) Now just reverse the whole array, = [5,6,7,1,2,3,4]
This is the result.
One thing to keep in mind, if k is very large or greater than length of nums eg.101 or 8
. we dont need to rotate it 101 times. This is because everytime we rotate the list
num.length times it resets (So [1,2,3,4,5,6,7] is the output for k=7) after that we just need
to rotate once more. So actual rotations will always be k%nums.length.
[See Image](https://imgur.com/a/qEft4Or)
​
Bonus- if k is negative eg. -2 which is rotate to left the answer is [3,4,5,6,7,1,2] which is
basically same as k=5 as 5 elements were picked up from back and put in front. So
for k<0, k=k+nums.length