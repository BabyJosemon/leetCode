class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        result=[]
        i=0# because this question deals with ongoing values in an iteration, use while loop which keeps iterating over multiple values instead of for loop that iterates on one item at a time. Consider example2 for this test.
        while(i<len(intervals) and intervals[i][1]<newInterval[0]):
            #first add all intervals that are smaller than newIntervals into result, so where the second number in current list in the intervals list is smaller than the starting number of newInterval. This means the newInterval cannot be put in now, we need to wait. eg [1,2] in example2. This will end when intervals[i][1] becomes larger than newInterval[0] eg. [3,5]
            result.append(intervals[i])
            i+=1
        while(i<len(intervals) and intervals[i][0]<=newInterval[1]):
            # here we see why we used while loop, now we are at a point where we need to add our interval i.e [3,5] but to know what new interval to be formed we make it in parts. the first part will be min of 'first element of current list from intervals list and first element of newInterval (ie. min(3,4)). and second part will be max of 'second element from current list of intervals list and second element of newInterval (ie. max(5,8))'. This is stored as the newInterval list which is now (3,8). Then we iterate the while loop and it continues till second part of and condition breaks which is secured bcs of newInterval[1] always being the max. We directly edit values of newInterval and not put a new variable as then it will get updated in every iteration. In next iteration we check against [6,7] but newInterval remains[3,8]. Next [8,10] where it becomes [3,10]. After that the loop breaks and we add it to the result.
            newInterval[0]=min(intervals[i][0],newInterval[0])
            newInterval[1]=max(intervals[i][1],newInterval[1])
            i+=1
        result.append(newInterval)
        while(i<len(intervals)):
            # this is just adding the rest back into result
            result.append(intervals[i])
            i+=1
        return result