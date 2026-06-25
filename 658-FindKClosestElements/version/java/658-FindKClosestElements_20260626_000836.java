// Last updated: 26/06/2026, 00:08:36
1/** Similar to 973. K Closest Points to Origin */
2class Solution {
3    public List<Integer> findClosestElements(int[] arr, int k, int x) {
4        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(distanceFromNumber(b,x), distanceFromNumber(a,x)));
5        for(int i=0; i<k; i++){
6            maxHeap.offer(arr[i]);
7        }
8        for(int i=k; i<arr.length; i++){
9            if(distanceFromNumber(arr[i], x)<distanceFromNumber(maxHeap.peek(),x)){
10                maxHeap.poll();
11                maxHeap.offer(arr[i]);
12            }
13        }
14        ArrayList<Integer> result = new ArrayList<>(maxHeap);
15        Collections.sort(result);
16        return result;
17    }
18    public Integer distanceFromNumber(int num, int target){
19        return Math.abs(num - target);
20    }
21}