//If starting is (1,1) only moving to right is (1+1,1) and only moving down is (1,1+1). Use recursion, when we are at m and n we 
//have reached the solution so return 1 there. This will backpropagate as everytime we find the finish we get a 1 and that 
//gets added to total. Draw recursion tree with 2 branches to verify.
class Solution {
    private static HashMap<String, Integer> cache;
    public static int helper(int r, int c, int m, int n){
        if(r==m && c==n){
            return 1;
        }
        if(r>m || c>n){
            return 0;
        }
        String key=r+","+c;
        if(cache.containsKey(key)){
            return cache.get(key);
        }else{
            cache.put(key, helper(r+1,c,m,n)+helper(r,c+1,m,n));
        }
        return helper(r+1,c,m,n)+helper(r,c+1,m,n);
    }
    public int uniquePaths(int m, int n) {
        cache=new HashMap<String, Integer>();
        return helper(1, 1, m, n);
    }
}