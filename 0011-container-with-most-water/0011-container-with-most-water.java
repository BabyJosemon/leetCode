class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int maxArea=0;
        int smallerHeight, width;// to be used later
        while(left<right){
           smallerHeight=Math.min(height[left], height[right]);//this is the shortest height for first container
            width=right-left;
            maxArea=Math.max(maxArea, smallerHeight*width);//first max area
            if(height[left]<height[right]){
                left+=1;
            }else{
                right-=1;
            }
        }
        return maxArea;    
    }
}