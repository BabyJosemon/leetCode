// Last updated: 10/05/2026, 20:46:22
/*The idea here is similar to two sum two pointer solution. But for that we need to sort the input array. After that we need to run a loop for first element.
At each element arr[i] we need to find two other numbers that equal to the opposite polarity of arr[i]. Or 
we need to find left and right so that the total is 0.
This is two sum now. So left= i+1 and right = end of array. Find the total sum of arr[i]+arr[left]+arr[right]. If it is smaller that 0 then we increment left otherwise decrememnt right. 
The tricky part is to avoid duplicates. Duplicates can occur by two scenarios.
1)In First iteration of i if arr[i+1]==arr[i]. That means the next number in the loop is the same as before. This will cause duplicates because we will run the same two sum algorithm to find arr[i+1]'s left and right and that could be the same numbers. To avoid this ,every time your iterate check if arr[i]==arr[i-1]. If it is the skip it.
2)For a particular arr[i], there could be multiple same left and rights. this would also result in duplicates, there is a way to fix that. Usually in two sum when we find a target we just return true and dont do anything to left or right OR we move them both so that the algorithm continues. But here as soon as you find a valid triplet, we will increment left and decrement right until its adjacent number is not the same and only then do we move both left and right. So if arr[left]==arr[left+1], arr[right]==arr[right-1]. This will keep skipping until left<right or we have no same number.*/
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // Your code goes here
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        //we will run main loop till nums.length-2 This is because we need atleast two numbers at the end for the last 
        //left and right.
        for(int i=0;i<nums.length-2;i++){
            //we check for the first duplicate condition. It will only start checking after i>0 so that we dont get
            // nums[-1] in check
            if(i>0 && nums[i]==nums[i-1]){
                continue;
            }
            //two sum from now
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int currentSum = nums[i]+nums[left]+nums[right];
                if(currentSum>0){
                    //sum is larger than 0, need to reduce it so decrement right.
                    right--;
                }else if(currentSum<0){
                    //sum is smaller than 0, need to increase it so increment left.
                    left++;
                }else{
                    //we have found a triplet that sums to 0 so we add it to the result array
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //now we need to move left and right so that the algorithm continues but before we move we need to 
                    //skip the second set of duplicates.
                    //To skip duplicates we move left and right until their adjcent number is not the same, then we move 
                    //them (which makes them end up in these adjacent non same number)
                    while(left<right && nums[left]==nums[left+1]){
                        //skip till nums[left]!=nums[left+1]
                        left++;
                    }
                    while(left<right && nums[right]==nums[right-1]){
                        //same
                        right--;
                    }
                    //now we can move left and right so that the main two pointer algorithm continues
                    left++;
                    right--;
                }
            }
        }
        return result;
    }
}