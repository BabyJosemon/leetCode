// Last updated: 10/05/2026, 20:46:23
//This is also a two pointer question, might seem like not because two pointers usually have the array sorted but that 
//is not always required. What we need is to We start with the widest possible container (pointers at both ends) and can
//eliminate suboptimal containers based on a simple observation: moving the taller wall inward can never help us because:
//The width decreases but also we are still limited by the height of the shorter wall
//So we always move the pointer pointing to the shorter wall, hoping to find a taller one.
class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int currentMaxVolume=0;
        while(left<right){
            int currentWidth = right-left;
            //can also use Math.min() and Math.max()
            int currentHeight = minim(height[left], height[right]);
            int currentVolume=currentWidth*currentHeight;
            currentMaxVolume = maxim(currentMaxVolume,currentVolume);
            if(height[left]<height[right]){
                left++;
            }else{
                right--;
            }
        }
        return currentMaxVolume;
    }
    public int minim(int a, int b){
        if(a>b){
            return b;
        }
        return a;
    }
    public int maxim(int a, int b){
        if(a>b){
            return a;
        }
        return b;
    }
}