// Last updated: 03/06/2026, 00:10:56
/*Imagine you have bookings on a calendar: [1,3], [2,6], [8,10]. If you sort them by start time, you can just walk left to right and ask one simple question each time:

"Does this new interval overlap with the last one I added?"

If yes → stretch the last one. If no → add a new one.
1) First. You need them in order so you only ever need to compare against the most recently added interval.
2) You then create a resultant list called merged in which the first interval always goes in first. For this to happen we check if merged is empty then we add first interval.
3) From the second interval onward we need to check if it overlaps with the already added first interval in merged or not.
4) If there is an interval, which we check and is true if currentStart<lastEnd (current interval starts before last one ends), then we need to merge it to the last added interval in merged. During merging the end time of this merged interval will be the greater end time between the two intervals.
5) If there is no interval then we cannot merge and we simply add it to the merged list.
 */
class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort first
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        List<int[]> merged = new ArrayList<>();
        //now we go through each interval
        for(int[] interval: intervals){
            int currentStart = interval[0];
            int currentEnd = interval[1];
            //pay attention here, to check overlap we also need lastIntervalEnd which is merged(merged.size()-1)[1] (because we need the last interval already in merged). But before we do that we need to check merged is empty first because in the very first case when merged is empty the finding the lastIntervalEnd will cause ArrayIndexOutOfBoundException (merged.get(-1)). So in that case as soon as merged.isEmpty() is true the rest is not checked.
            boolean mergedEmptyOrNoOverlapExists = merged.isEmpty() || currentStart>merged.get(merged.size()-1)[1];
            if(mergedEmptyOrNoOverlapExists){
                //merged is empty initially but later on if an overlap does not exist with last added interval in merged then we directly add the interval.
                merged.add(interval);
            }else{
                //overlap exists
                int[] lastKnownExistingInterval = merged.get(merged.size()-1);
                //when merging the start of lastKnownExistingInterval remains same but end time needs to be max of lastKnownExistingInterval and currentInterval
                lastKnownExistingInterval[1]= Math.max(lastKnownExistingInterval[1], currentEnd);
            }
        }
        return merged.toArray(new int[merged.size()][]);
        //[ [1,6], [8,10] ]   ->   { {1,6}, {8,10} }
    }
}