// Last updated: 19/06/2026, 00:12:38
1/**#this question can be thought of as a binary search question. The largest value of k can be the largest value of piles array which will take len(piles) hrs for koko to finish. eg. at speed 11 the time taken by koko will be 4 (len(piles)) but this is not necesarrily the smallest. The answer lies in the array from 1 to the largest value in piles. We will do binary search without an array to avoid memeory restrictions if input is large.
2#We then do a simple binary search and for every mid we will run that mid thru the piles array to find out time taken using this mid. For that we initialise newTime=0 everytime, then for each value of piles we divide it by the mid and find the ceil. This ensures the condition of pile having less than k(mid in this instance). eg. in 6 is the first possible k (or mid) and first element of piles is 3. At speed 6, 3 bananas will be done in 1 hour so math.ceil(3/6).
3# At the end we have a time taken value for current k, if it is smaller than time taken by the guards(h) then this could be a possible answer. So we store it in smallest variable using min. We say possible answer because as there could be a k even smaller that also doesnt exceed the gaurd time(h), so we set end to mid-1 like in binary search. If it is larger than the time taken by gaurds then this is not a possible answer and it means that we need to increase the speed of eating bananas (k) so we set start to mid+1 so that a larger mid is calculated. The cycle starts again and at the end return smallest. */
4class Solution {
5    public int minEatingSpeed(int[] piles, int h) {
6        //finding largest element
7        int maximumRate = piles[0];
8        for(int pile : piles) maximumRate = Math.max(maximumRate, pile);
9
10        int low = 1;
11        int high = maximumRate;
12        int minRateSolution = maximumRate;
13        while(low<=high){
14            int midRate = low + (high-low)/2;
15            long timeTakenWithCurrentRate = timeTakenWithRate(piles, midRate);
16            if(timeTakenWithCurrentRate<=h){
17                minRateSolution = Math.min(minRateSolution, midRate);
18                //see if rate can go even lower while staying under input h
19                high = midRate-1;
20            }else{
21                //time taken is more than h so we need to increase rate
22                low = midRate+1;
23            }
24        }
25        return minRateSolution;
26    }
27
28    public long timeTakenWithRate(int[] piles, int rate){
29        long timeTaken = 0;
30        for(int pile: piles){
31            timeTaken+=(pile + rate - 1)/rate;
32        }
33        return timeTaken;
34    }
35}