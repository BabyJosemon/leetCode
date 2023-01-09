class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        cache={}    #dictionary of number in list: its respective index
        for index, value in enumerate(nums):
            if(target-value in cache):  #if diff in list return current index and index of diff stored in cache.
                return [index, cache[target-value]]
            else:
                cache[value]=index



