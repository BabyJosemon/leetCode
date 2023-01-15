# use sliding window where we start the start at 0 and end from 1 to end of list. If start is bigger or equal than end then ignore them by moving start to winEnd position. 
class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        winStart=0
        difference=0
        for winEnd in range(1,len(prices)):
            if prices[winStart]>=prices[winEnd]:
                winStart=winEnd#moving winStart upto winEnd to ignore this scenario. If we find a bigger difference later on that will mean that the start of this new gap will be smaller than the current winEnd
            else:
                currentDifference=prices[winEnd]-prices[winStart]
                difference=max(currentDifference,difference)#cache the current highest difference
        return difference