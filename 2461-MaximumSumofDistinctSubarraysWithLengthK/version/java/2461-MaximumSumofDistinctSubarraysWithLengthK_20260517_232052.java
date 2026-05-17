// Last updated: 17/05/2026, 23:20:52
1/* This is a classic sliding window problem. We need to maintain a window of size k but also make sure everything inside that window is unique. 
2A) We will use a hashmap to store frequency of the numbers that we have seen. 
3B) We will add to currentSum everytime and update the frequency table along with it.
4C) Once we reach the required window size we will now focus on maintaining that window.
5D) We only update maxSum when freqMap.size() == k This works because: if our window has k elements, and our map has k entries, then each element appears exactly once. If there were duplicates, the map would have fewer than k entries.
6// Example: k=3, window=[5,7,5]
7//   → window has 3 elements but map has only 2 keys {5:2, 7:1}
8//   → 2 < 3, so we know there's a duplicate
9E) To maintain the window we do the usual we do for sliding window, reduce nums[start] from currentSum  + remove nums[start] from hashmap+ increment start.
10F) If nums[start] ever gets to 0, then we remove it. This is so that the freqMap.size() stays true to its definition i.e. frequency of numbers in the window and start is not in the window anymore.
11*/
12class Solution {
13    public long maximumSubarraySum(int[] nums, int k) {
14        int start=0;
15        Map<Integer, Integer> seenElements = new HashMap<>();//A) This hashmap will contain the current frequency of elements.
16        long maxSum= 0;
17        long currentSum=0;
18        for(int end = 0; end<nums.length; end++){
19            //B) Add currentSum everytime and update frequency table
20            currentSum+=nums[end];
21            seenElements.put(nums[end],seenElements.getOrDefault(nums[end],0)+1);//either 0 or 1 or increment
22            if(end-start+1==k){
23                //C) Now we have a window, need to maintain it now but first D
24                if(seenElements.size()==k){
25                    //D) only when we have k distinct elements in the hashmap
26                    maxSum=Math.max(maxSum,currentSum);
27                }
28                //E) to maintain the window
29                //Now to move the window we remove start
30                //E) Removing it from currentSum
31                currentSum-=nums[start];
32                //remove it from the hashmap
33                seenElements.put(nums[start],seenElements.get(nums[start])-1);
34                //F) if its frequency goes to zero then remove it, this means that number does not exist in current window
35                int frequencyOfStartThatGotRemoved = seenElements.get(nums[start]);
36                if(frequencyOfStartThatGotRemoved==0){
37                    seenElements.remove(nums[start]);
38                }
39                //E) incrementing start
40                start++;
41            }
42        }
43        return maxSum;
44    }
45}