// Last updated: 24/06/2026, 23:33:46
// The part on the left—the (a, b) or (b, a)—defines the variable names Java assigns to the two items it is currently holding in its hands.It does not matter if you write (a, b) or (b, a) on the left. The variable names themselves do not change whether it is a min-heap or a max-heap. What matters is how you order those same variables inside the math on the right.Here is exactly how Java reads this syntax.Understanding the Blueprint: (item1, item2) -> ...Think of the left side as a template. Java always grabs two items from the heap:The First item it grabbed gets assigned to the first variable name.The Second item it grabbed gets assigned to the second variable name.Scenario A: You write (a, b) -> Integer.compare(distance(b), distance(a))Java assigns the first item to the name a.Java assigns the second item to the name b.On the right side, you put b first. So Java calculates: distance(second item) - distance(first item).This creates a Max-Heap.Scenario B: You write (b, a) -> Integer.compare(distance(a), distance(b))Java assigns the first item to the name b.Java assigns the second item to the name a.On the right side, you put a first. Look closely at what a represents here: it is the second item! So Java calculates: distance(second item) - distance(first item).This also creates a Max-Heap.
1/**Similar to finding 215. kLargest elements in array, this is ksmallest distances and so we use maxHeap that has root as 
2its largest element and we remove root if we find something smaller than it. This means that by the end only the 
3smallest distanceToOrigin points will be in the maxHeap. Keep in mind we are not directly comparing the points but
4rather comparing each points distancesToOrigin. We created a helper and dont use Math.sqrt because that returns a 
5Double which we will need to ceil. Not using it makes no difference and is easier. Also dissimilar from kLargest where
6 we first inserted k elements and then from kth element we started to check root, here we run 1 loop through the array
7 and add all till (k-1)th. Then from kth we start checking the actual distanceToOrigin of a point to the root. So if
8 a point has distance smaller than root then that is replaced and priorityQueue internally bubbles new element up.
9 This could have been done in kLargest question as well.*/
10
11class Solution {
12    public int[][] kClosest(int[][] points, int k) {
13        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(distanceToOrigin(b), distanceToOrigin(a)));
14        //OR PriorityQueue<int[]> maxHeap = new PriorityQueue<>(Collections.reverseOrder()); if we were not using array
15        //The comparator here compares the distancesToOrigin of two points,
16        for(int[] point: points){
17            int currentDistanceToOrigin = distanceToOrigin(point);
18            System.out.println(currentDistanceToOrigin);
19            if(maxHeap.size()<k){
20                 maxHeap.offer(point);
21            }else if(currentDistanceToOrigin<distanceToOrigin(maxHeap.peek())){
22                maxHeap.poll();
23                maxHeap.offer(point);
24            }
25        }
26        //direct conversion of 2d priority queue to 2d array without order guarantee. 
27        //if we needed to maintain order:
28        // Create a 2D array with the exact size of the queue
29        /*int[][] result = new int[pq.size()][];
30        int index = 0;
31        while (!pq.isEmpty()) {
32            result[index++] = pq.poll(); // Pulls elements out in priority order
33        }*/
34        return maxHeap.toArray(new int[0][]);
35    }
36    Integer distanceToOrigin(int[] point){
37        return (point[0]*point[0])+(point[1]*point[1]);
38    }
39}