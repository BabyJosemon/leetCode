class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int MaximumK=Arrays.stream(piles).max().getAsInt();//This is the maximum speed
        int beginning=1;
        int ending=MaximumK;
        int mid;
        int currentMinK=MaximumK;
        while(beginning<=ending){
            mid=(beginning+(ending-beginning)/2); 
            int currentTimeTaken=0;
            for(int i=0;i<piles.length;i++){
                currentTimeTaken+=Math.ceil((double) piles[i] / mid);
                //We need to do float as 3/6=0 and ceil of that is 0, but 3/6.0=0.5 and ceil of that is 1.
            }
            if(currentTimeTaken>h){
                beginning=mid+1;
            }else{
                currentMinK=Math.min(currentMinK,mid);
                ending=mid-1;
            }
        }
        return currentMinK;
    }
}