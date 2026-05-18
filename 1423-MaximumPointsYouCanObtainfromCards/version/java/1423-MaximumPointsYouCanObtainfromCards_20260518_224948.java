// Last updated: 18/05/2026, 22:49:48
1/* This can be solved with the idea that whenever we choose k cards from n total cards we are left with n-k cards that are not selected. And these n-k cards are always continuos unlike the circular windows of k. We know the total sum of the array and totalsum=sum of K elements + sum of n-k elements. This means to maximise sum of k elements, we just need to minimise sum of n-k elements. This then just turns into a sliding window question where we need to find the window of left out cards that has the minimum sum. For that window the sum of k elements will be the largest. So the window here will be of n-k size.*/
2class Solution {
3    public int maxScore(int[] cardPoints, int k) {
4        // Your code goes here
5        //LOC=LeftOutCards, CH=Chosen Cards
6        int start=0;
7        int windowSizeLOC= cardPoints.length-k;//n-k window size
8        int minimumWindowValueLOC=Integer.MAX_VALUE;//the value to minimise
9        int maximumScoreCH=Integer.MIN_VALUE;//the value to maximise
10        int currentSumLOC=0;//current sum of n-k window
11        int currentSumCH=0;//current sum of the left over k elements.
12        //Finding total sum
13        int totalSum=0;
14        for(int value: cardPoints){
15            totalSum+=value;
16        }
17        if(windowSizeLOC==0){
18            //this is the case where the window size k is equal to the size of input array. So here the window size will 0. In such a case the maximum is the total sum. 
19            return totalSum;
20        }
21        //sliding-window
22        for(int end =0; end<cardPoints.length; end++){
23            currentSumLOC+=cardPoints[end];
24            if(end-start+1==windowSizeLOC){//we have reached n-k window size now for each window
25                currentSumCH=totalSum-currentSumLOC;//find the current sum of left over k elements
26                minimumWindowValueLOC=Math.min(minimumWindowValueLOC, currentSumLOC);//find the minimum of current sum of n-k elements and global variable.
27                maximumScoreCH=Math.max(maximumScoreCH, currentSumCH);//keeping track of the maximum of current sum of left over k elements and global.
28                //standard window moving now, moving start. Since we are actively trying to minimize currentSumLOC, we subtract start from it
29                currentSumLOC-=cardPoints[start];
30                start++;
31            }
32        }
33        return maximumScoreCH;//at the end we will have the maximum sum of left over k elements we ever saw.
34        
35    }
36}