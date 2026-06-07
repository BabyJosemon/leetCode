// Last updated: 08/06/2026, 00:52:22
1/**This interval problem uses the second approach of sorting by end time so that Intuitively, this frees time for us to add more intervals as early as possible. This means after sorting we just need to find the number of overlapping intervals. Here after sorting we need to add intervals that we detect as overlapping to the counter and move ahead.
2We start at the second interval and compare with the first.
3When we find an overlap we increment the counter but also remember what this represents, internally you are telling 
4yourself that you will remove one of these since there is an overlap. Which one to discard?
5 When you find an overlap you are discarding the current interval, this is because after sorting by end time, your 
6 current interval that is overlapping with the previous is most definitely larger than previous interval, and we need to
7 keep the smallest intervals to maximise intervals.
8 When we dont find an overlap then we dont increment counter but internally we are telling ourselves that we are keeping
9 the current interval in the list.
10 previousIntervalEnd is the end of the last interval you decided to keep and we only keep intervals that are non overlapping so we only move previousIntevalEnd if non overlapping*/
11class Solution {
12    public int eraseOverlapIntervals(int[][] intervals) {
13        if(intervals.length==0){
14            return 0;
15        }
16        Arrays.sort(intervals, (a,b)-> a[1]-b[1]);
17        int count =0;// atleast first interval is non overlapping.
18        int previousIntervalEnd = intervals[0][1];
19        for(int i=1;i<intervals.length;i++){//start at second interval
20            int currentIntervalStart = intervals[i][0];
21            if(previousIntervalEnd>currentIntervalStart){
22                //we have an overlapping interval
23                count++;
24                //since we are discarding currentInterval, we will not move previous as previous is still non overlapping
25            }
26            else{
27                //this is a non overlapping interval so we decide to keep this current, and we keep it by assigning its
28                //value to previous so that next intervals can be checked against it.
29                previousIntervalEnd=intervals[i][1];
30            }
31        }
32        return count;
33    }
34}