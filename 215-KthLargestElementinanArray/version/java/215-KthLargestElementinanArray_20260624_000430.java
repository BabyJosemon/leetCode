// Last updated: 24/06/2026, 00:04:30
// O(n) as we iterate through all elemnts.
1
2/*This is a heap (priority queue in java) question, any question that has top, kth, smallest, largest, closest, 
3most-frequent etc use heaps. Heaps can be minheap (default) or max heap where the root is either smallest or largest.
4 They can be represented as complete binary trees. Heap has 4 operations:
51) push = priorityQueue.offer (log n)
62) pop = priorityQueue.poll (log n)
73) peek = priorityQueue.peek (1)
84) heapify = Constructor (PriorityQueue<Integer> pq = new PriorityQueue<>(list); ) (n but in java it is faster than 
9offering element one by one which is nlogn)
10In this question, because we need the kth largest we just build a minheap of k elements.  we can just iterate through
11 input array and add each element to a heap. Whent he size of the heap goes more than k, and we need to add further 
12 elements, then we check if the new element to add is bigger than root, then we remove the root. This is 
13 because the root is the smallest in a minheap and we want to get rid of those to end up with a heap of the largest
14 elements. If we had to find kSmallest then we use maxheap because we wwant to get rid of te largest elements.
15 */
16class Solution {
17    public int findKthLargest(int[] nums, int k) {
18        PriorityQueue<Integer> myHeap = new PriorityQueue<>();
19        //add the first k elements to establish that our heap only has k elements.
20        for (int i = 0; i < k; i++) {
21            myHeap.offer(nums[i]);
22        }
23        for (int i = k; i < nums.length; i++) {
24            if (nums[i] > myHeap.peek()) {//check if current num is greater than root
25                myHeap.poll();//remove root
26                myHeap.offer(nums[i]);//add that current num that is greater than root
27            }
28        }
29        return myHeap.peek();
30        //to return the array:
31        //return myHeap.stream().mapToInt(Integer::intValue).toArray();
32    }
33}