// Last updated: 29/05/2026, 23:41:54
1/*This is the brute force approach where you insert the new interval to the list of intervals and then sort it. And then you use the same algo as 56. Merge Intervals */
2class Solution {
3    public int[][] insert(int[][] intervals, int[] newInterval) {
4        int[][] newIntervalList = Arrays.copyOf(intervals, intervals.length + 1);
5        newIntervalList[newIntervalList.length-1]=newInterval;
6        Arrays.sort(newIntervalList, (a,b)-> a[0]-b[0]);
7        List<int[]> result = new ArrayList<>();
8        for(int[] interval: newIntervalList){
9            int currentStart = interval[0];
10            int currentEnd = interval[1];
11            if(result.isEmpty() || currentStart>result.get(result.size()-1)[1]){
12                result.add(interval);
13            }else{
14                result.get(result.size()-1)[1] = Math.max(result.get(result.size()-1)[1], currentEnd);
15            }
16        }
17        return result.toArray(new int[result.size()][]);
18    }
19}