#To have an optimal solution, look at the outputs eg1. Each ith value (eg. arr[1] = 12 here) in output can be said as the preduct of its left elements and right elements((1)x(3x4)). In this the 3x4 is calculated earlier too for arr[0] but we are doing it again. This causes inefficiency. So we can create 2 new arrays left and right of same size as input.
#Each ith value of left will contain the product of all numbers before it. eg.consider array [1,2,3,4]
#Initialise first value of left as 1 so left=[1,_,_,_] since there is no number before array[0].
#for array[1] the number before it is 1 so left=[1,1,_,_]
#for subsequent values array[i] instead of checking array[i-1]xarray[i-2]...(equation 1) we will just multiply array[i-1]xleft[i-1]. This is because array[i-1] is already the first value before array[i] and instead of using array[i-2]xarray[i-3]... of equation 1 we already know that left[i-1] is already equal to the array[i-2]xarray[i-3]... so left at the end=[1,1,2,6]
#similarly we find right array and here we start from the end of the array. the last element will be 1, right[n-1]=1 as no element to the right of last element.so right=[_,_,_,1].
#for array[2] we use the same principle as before array[j]=array[j+1]xright[j+1]; so array[2]=array[3]xright[3] = 4, right=[_,_,4,1]
# this is because again array[j]=array[j+1]xarray[j+2]x... equation 2 and here array[j+2]x... can be substituted with the already calculated values.
# this can be further optimised to only use the result array by calculating left array in result array first. Then create a varible to store rightmost element. Then run the right array loop and result[i]=result[i]x right variable. This is because result[i] is already the product of all numbers to the left of result[i] and multiply that with the right variable which at first is the last element but everytime we set it to right=rightxarray[j] as each time running the loop back it will keep on multiplying to each value.
class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        #left=[1]*len(nums)# this is the array to store all products to the left of a number starting with 1
        #right=[None]*len(nums)#this is the array to store all products to the right of a number ending with 1
        #right[len(nums)-1]=1
        #result=[None]*len(nums)
        #for i in range(1,len(nums)):
            #left[i]=nums[i-1]* left[i-1]#similar to prefix sum
        #for j in range(len(nums)-2,-1,-1):
            #right[j]=nums[j+1]*right[j+1]#similar to suffix sum
        #for k in range(len(nums)):
            #result[k]=left[k]*right[k]
        result=[1]* len(nums)
        for i in range(1,len(nums)):
            result[i]=nums[i-1]*result[i-1]
        right=nums[-1]
        for j in range(len(nums)-2,-1,-1):
            result[j]=result[j]*right
            right=right*nums[j]
        return result
        