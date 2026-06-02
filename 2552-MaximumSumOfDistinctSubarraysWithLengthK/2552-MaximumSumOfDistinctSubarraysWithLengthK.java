// Last updated: 03/06/2026, 00:10:44
/* This is a classic sliding window problem. We need to maintain a window of size k but also make sure everything inside that window is unique. 
A) We will use a hashmap to store frequency of the numbers that we have seen. 
B) We will add to currentSum everytime and update the frequency table along with it.
C) Once we reach the required window size we will now focus on maintaining that window.
D) We only update maxSum when freqMap.size() == k This works because: if our window has k elements, and our map has k entries, then each element appears exactly once. If there were duplicates, the map would have fewer than k entries.
// Example: k=3, window=[5,7,5]
//   → window has 3 elements but map has only 2 keys {5:2, 7:1}
//   → 2 < 3, so we know there's a duplicate
E) To maintain the window we do the usual we do for sliding window, reduce nums[start] from currentSum  + remove nums[start] from hashmap+ increment start.
F) If nums[start] ever gets to 0, then we remove it. This is so that the freqMap.size() stays true to its definition i.e. frequency of numbers in the window and start is not in the window anymore.
*/
class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int start=0;
        Map<Integer, Integer> seenElements = new HashMap<>();//A) This hashmap will contain the current frequency of elements.
        long maxSum= 0;
        long currentSum=0;
        for(int end = 0; end<nums.length; end++){
            //B) Add currentSum everytime and update frequency table
            currentSum+=nums[end];
            seenElements.put(nums[end],seenElements.getOrDefault(nums[end],0)+1);//either 0 or 1 or increment
            if(end-start+1==k){
                //C) Now we have a window, need to maintain it now but first D
                if(seenElements.size()==k){
                    //D) only when we have k distinct elements in the hashmap
                    maxSum=Math.max(maxSum,currentSum);
                }
                //E) to maintain the window
                //Now to move the window we remove start
                //E) Removing it from currentSum
                currentSum-=nums[start];
                //remove it from the hashmap
                seenElements.put(nums[start],seenElements.get(nums[start])-1);
                //F) if its frequency goes to zero then remove it, this means that number does not exist in current window
                int frequencyOfStartThatGotRemoved = seenElements.get(nums[start]);
                if(frequencyOfStartThatGotRemoved==0){
                    seenElements.remove(nums[start]);
                }
                //E) incrementing start
                start++;
            }
        }
        return maxSum;
    }
}