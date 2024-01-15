class Solution {
    //THis is the recursion solution where we are recalculating certain branches so not optimal
    /*public int fib(int n) {
        if(n<=1){
            return n;
        }
        return fib(n-1)+fib(n-2);
    }*/
    
    /*
    This is recursion with memoization where we use a list to store the already calculated values. This optimizes it but it increases memory used. This can also be implemented using hashtable but bcs we know the index to look for the access complexity is O(1) for both so no difference.
    public int helper(int n, int[] cache){
        if(n<=1){
            return n;
        }
        if(cache[n]!=0){
            return cache[n];
        }
        return(cache[n]=helper(n-1,cache)+helper(n-2, cache));
    }
    public int fib(int n) {
        int[] cache= new int[n+1];
       return helper(n, cache);
    }
    */
    //This is the tabulation method which is the most optimised where we are not using any additional datastructures but using 2 variable that keep on moving.
    public int fib(int n){
        if(n<=1){
            return n;
        }else{
        int prev=0;
        int prev2=1;
        int currentSum;
        for(int i=2;i<=n;i++){
            currentSum=prev+prev2;
            prev=prev2;
            prev2=currentSum;
            
        }
        return prev2;
        }
    }
    
}