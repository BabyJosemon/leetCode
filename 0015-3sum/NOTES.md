Here we will use a form of two pointer approach, where
Approach for this Problem:
Sort the input array
Initialize a set to store the unique triplets and an output vector to store the final result
Iterate through the array with a variable i, starting from index 0.
Initialize two pointers, j and k, with j starting at i+1 and k starting at the end of the array.
In the while loop, check if the sum of nums[i], nums[j], and nums[k] is equal to 0. If it is insert the triplet into the set and increment j and decrement k to move the pointers.
If the sum is less than 0, increment j. If the sum is greater than 0, decrement k.
After the while loop, iterate through the set and add each triplet to the output vector.
Return the output vector
​
​