class Solution {
    public int distanceFromOrigin(int[] point){
        return ((point[0])*(point[0]))+((point[1])*(point[1]));
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> maxheap = new PriorityQueue<>((p1, p2)->distanceFromOrigin(p2)-distanceFromOrigin(p1));
        for(int i=0;i<k;i++){
            maxheap.add(points[i]);    
        }
        for(int i=k;i<points.length;i++){
            if(distanceFromOrigin(maxheap.peek())>distanceFromOrigin(points[i])){
                maxheap.poll();
                maxheap.add(points[i]);
            }
        }
        int[][] resultArray = new int[maxheap.size()][2];
        int index = 0;
        for (int[] point : maxheap) {
            resultArray[index] = point;
            index+=1;
        }
        return resultArray;
    }
}