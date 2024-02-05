class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        int n=strs[0].length();
        for(int i=0;i<n;i++){
            char firstI=strs[0].charAt(i);
            for(int j=1;j<strs.length;j++){
                if(i>=strs[j].length() || firstI!=strs[j].charAt(i)){
                    return strs[0].substring(0,i);
                }
            }
        }
        
        return strs[0]; //for egde case ["av", "a", "ab"] and ["","",""] and ["flower","flower","flower","flower","flower"]
    }
}