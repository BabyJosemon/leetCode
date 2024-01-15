class Solution {
    public int trap(int[] height) {
        int maxLeft=0;
        int maxRight=0;
        int n=height.length;
        int[] arrMaxLeft=new int[n];
        int[] arrMaxRight=new int[n];
        int result=0,temp=0,j;
        
        for(int i=0;i<n;i++){//creating arrMaxLeft[] and arrMaxRight[]
            j=n-i-1;//the opposite element on the list
            maxLeft=Math.max(maxLeft, height[i]);
            maxRight=Math.max(maxRight, height[j]);
            arrMaxLeft[i]=maxLeft;
            arrMaxRight[j]=maxRight;
        }
        for(int i=0;i<n;i++){//just iterate through and add the result.
            temp = Math.min(arrMaxLeft[i],arrMaxRight[i])-height[i];//amount of water the space can hold
            if(temp>0){
                result+=temp;
            }
        }
        return result; 
    }
}