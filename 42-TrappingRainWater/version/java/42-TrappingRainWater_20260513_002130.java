// Last updated: 13/05/2026, 00:21:30
1/* Two Pointer:
2At each point, note that the water height can only be a minimum of the maximum height on left side and maximum height on right side. From this we subtract the elevation. After subtracting the elevation if there is a positive number left, that is the amount of water in that gap. Eg. consider height[2]=0, at this point the maximum height to its left is 1(height[1]) and maximum height to the right is 3(height[[7]). The minimum of these is 1, that means at most this gap can hold 1 unit of water. Subtract the current elevation(height[2]) from this water to get 1-0=1 unit of water in this space. Eg. consider height[5]=0, max on left=2, right=3. Min of this is 2. Subtracting elevation 2-0=2 units of water Eg. height[8]=2, maxL=3 maxR=2. Min of that is 2. Subtracting elevation (2) from it we get 2-2=0, so cannot hold water. Eg. height[7]=3, maxL2=2, maxR=2.Min of that is 2. Subtracting elevation(3) from it we get 2-3=-1 which is negative so cannot hold water.​An easy way to use this technique is to create 2 new arrays arrMaxLeft[] and arrMaxRight[] of size n. arrMaxLeft[] would hold at each point the highest height seen to the left of the current position and vice versa in arrMaxRight[]. Then we just subtract height[] values from min of respective arrMaxLeft[] and arrMaxRight[] arrays. We only add it to result if it is greater than 0. */
3class Solution {
4    public int trap(int[] height) {
5        int n = height.length;
6        int[] arrLeftMax = new int[n];
7        int[] arrRightMax = new int[n];
8        int maxLeft=0, maxRight=0, j;
9        //building arrMaxLeft[] and arrMaxRight[]
10        for(int i=0;i<n;i++){
11            j=n-i-1;//the exact opposite, the arrRightMax starts from the end
12            arrLeftMax[i]=Math.max(maxLeft,height[i]);
13            maxLeft=Math.max(maxLeft,height[i]);
14            arrRightMax[j]=Math.max(maxRight, height[j]);
15            maxRight=Math.max(maxRight, height[j]);
16        }
17        int totalWater=0;
18        int waterInCurrentLevel;
19        //just iterate through and add the result.
20        for(int k=0;k<n;k++){
21            waterInCurrentLevel = Math.min(arrLeftMax[k],arrRightMax[k])-height[k];
22            if(waterInCurrentLevel>0){
23                totalWater+=waterInCurrentLevel;
24            }else{
25                continue;
26            }
27        }
28        return totalWater;
29    }
30}