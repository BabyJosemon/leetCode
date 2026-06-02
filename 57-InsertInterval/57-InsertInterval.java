// Last updated: 03/06/2026, 00:10:55
/* The brute force approach where you insert the new interval to the list of intervals and then sort it. And then you use the same algo as 56. Merge Intervals is possible but we can improve it. In the brute force approach we are sorting the array again unnecesarily. Merge Intervals question did not have a sorted array but here we already get a sorted array so we make use of it. We only need to pass through the array once and thenwe have 3 phases. Imagine the intervals on a number line along with the newInterval also on it but above. Then iterate through the list and for each interval:
Phase1 : If the interval lies before newInterval, add it directly to the result list. so interval[1]<newInterval[0]
Phase2 : After Phase 1 you already know: "every remaining interval could overlap — none of them ended too early". So in Phase 2 you just need to know when to stop merging. You stop when the current interval starts after your new interval ends. And till then this new Interval keeps growing by have the start being min of current and new interval starts and end being max of current and new interval ends. 
Phase3: Once phase 2 is done you already know: "every remaining interval starts after newExpandedInterval created in phase 2 so the rest can be added directly." 

Remember different from 56. Merge Intervals overlap check in phase 2 we are not checking if we have an overlap. Everything after phase 1 is a potential overlap so we need to figure out when the overlap stops. That is the conditional in loop which is currentIntervalStart>newIntervalEnd.*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> mergedInterval = new ArrayList<>();
        int i = 0;
        int sizeOfIntervals = intervals.length;
        //PHASE 1
        while(i<sizeOfIntervals && intervals[i][1]<newInterval[0]){
           mergedInterval.add(intervals[i]);
           i++; 
        }
        //PHASE 2: Now the remaining intervals atleast end after new interval starts so overlap
        //So we just need to know when to stop merging, which we stop after currentIntervalStart>newExpandingIntervalEnd
        while(i<sizeOfIntervals && intervals[i][0]<=newInterval[1]){
            //here in case 1 interval[i][0] is currentIntervalStart with is 6 of [6,9] and not [1,3]
            //while this holds true we merge by modifying and expanding newInterval
            newInterval[0]= Math.min(newInterval[0], intervals[i][0]);
            newInterval[1]= Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        //after we have expanded newInterval to max possible merged interval we add it to the result
        mergedInterval.add(newInterval);
        //at this point i is at [6,9]
        while(i<sizeOfIntervals){
            mergedInterval.add(intervals[i]);
            i++;
        }
        return mergedInterval.toArray(new int[mergedInterval.size()-1][]);
    }
}