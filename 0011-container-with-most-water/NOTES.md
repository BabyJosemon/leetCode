We use the two pointer approach where we set left and right and maxArea as 0.
At first the area is calculated as min(height[left], height[right]) multiplied by the length between the left and the right ~ right-left.
Consider first case when left=0, right=8, here the height of nums[left] = 1 and height of nums[right] = 7 but the water it can hold between this is at max till hight 1, i.e the min of both. and width = 8-0=8
This first area is set to maxArea.
now we need to check for all areas, instead of doing all, now just check which of height[left] and height[right] is longer. Here height[righ] = 7 is longer so we dont need to move this. So just move left+=1. We would do reverse if we wanted to find minimum area.