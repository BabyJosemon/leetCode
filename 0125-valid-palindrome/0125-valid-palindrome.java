class Solution {
    public boolean isPalindrome(String s) {
        String lowerCased=s.toLowerCase();
        String trimmedStr=lowerCased.replaceAll("[^a-z0-9]","");
        char letterFirst, letterSecond;
        int j;
        int n=trimmedStr.length();
        if(n==0){
            return true;
        }
        for(int i=0;i<n/2;i++){
            j=n-i-1;
            letterFirst=trimmedStr.charAt(i);
            letterSecond=trimmedStr.charAt(j);
            if(letterFirst!=letterSecond){
                return false;
            }
                
        }
        return true;
        
    }
}