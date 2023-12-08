#this question can be thought of as a binary search question. The largest value of k can be the largest value of piles array which will take len(piles) hrs for koko to finish. eg. at speed 11 the time taken by koko will be 4 (len(piles)) but this is not necesarrily the smallest. The answer lies in the array from 1 to the largest value in piles. We will do binary search without an array to avoid memeory restrictions if input is large.
#We then do a simple binary search and for every mid we will run that mid thru the piles array to find out time taken using this mid. For that we initialise newTime=0 everytime, then for each value of piles we divide it by the mid and find the ceil. This ensures the condition of pile having less than k(mid in this instance). eg. in 6 is the first possible k (or mid) and first element of piles is 3. At speed 6, 3 bananas will be done in 1 hour so math.ceil(3/6).
# At the end we have a time taken value for current k, if it is smaller than time taken by the guards(h) then this could be a possible answer. So we store it in smallest variable using min. We say possible answer because as there could be a k even smaller that also doesnt exceed the gaurd time(h), so we set end to mid-1 like in binary search. If it is larger than the time taken by gaurds then this is not a possible answer and it means that we need to increase the speed of eating bananas (k) so we set start to mid+1 so that a larger mid is calculated. The cycle starts again and at the end return smallest.
class Solution:
    def minEatingSpeed(self, piles: List[int], h: int) -> int:
        largestK=max(piles)
        #possiblek = [i for i in range(1,largestK+1)]  #not creating an array as that creates problems if size is too big.eg[3662904334] h=3662904333
        start=1
        end=largestK
        smallest=largestK#this is the value we keep track of, can be largestK initially too.
        while(start<=end):
            mid=start+(end-start)//2
            newTime=0#counting time taken for current k
            for i in range(len(piles)):
                newTime=newTime+math.ceil(piles[i]/mid)
            if(newTime>h):#if time taken with this possiblek[mid] is longer than guard break then increase banana/hour speed or k should be larger than current amount, also we also dont need to update smallest as this is not one of the possible answers.
                start=mid+1
            else:#newTime<=h
                smallest=min(mid,smallest)
                end=mid-1
        return smallest
                
            
        