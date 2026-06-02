// Last updated: 03/06/2026, 00:10:46
/* This can be solved with the idea that whenever we choose k cards from n total cards we are left with n-k cards that are not selected. And these n-k cards are always continuos unlike the circular windows of k. We know the total sum of the array and totalsum=sum of K elements + sum of n-k elements. This means to maximise sum of k elements, we just need to minimise sum of n-k elements. This then just turns into a sliding window question where we need to find the window of left out cards that has the minimum sum. For that window the sum of k elements will be the largest. So the window here will be of n-k size.*/
class Solution {
    public int maxScore(int[] cardPoints, int k) {
        // Your code goes here
        //LOC=LeftOutCards, CH=Chosen Cards
        int start=0;
        int windowSizeLOC= cardPoints.length-k;//n-k window size
        int minimumWindowValueLOC=Integer.MAX_VALUE;//the value to minimise
        int maximumScoreCH=Integer.MIN_VALUE;//the value to maximise
        int currentSumLOC=0;//current sum of n-k window
        int currentSumCH=0;//current sum of the left over k elements.
        //Finding total sum
        int totalSum=0;
        for(int value: cardPoints){
            totalSum+=value;
        }
        if(windowSizeLOC==0){
            //this is the case where the window size k is equal to the size of input array. So here the window size will 0. In such a case the maximum is the total sum. 
            return totalSum;
        }
        //sliding-window
        for(int end =0; end<cardPoints.length; end++){
            currentSumLOC+=cardPoints[end];
            if(end-start+1==windowSizeLOC){//we have reached n-k window size now for each window
                currentSumCH=totalSum-currentSumLOC;//find the current sum of left over k elements
                minimumWindowValueLOC=Math.min(minimumWindowValueLOC, currentSumLOC);//find the minimum of current sum of n-k elements and global variable.
                maximumScoreCH=Math.max(maximumScoreCH, currentSumCH);//keeping track of the maximum of current sum of left over k elements and global.
                //standard window moving now, moving start. Since we are actively trying to minimize currentSumLOC, we subtract start from it
                currentSumLOC-=cardPoints[start];
                start++;
            }
        }
        return maximumScoreCH;//at the end we will have the maximum sum of left over k elements we ever saw.
        
    }
}