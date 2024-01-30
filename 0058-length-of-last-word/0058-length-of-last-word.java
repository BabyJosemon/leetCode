class Solution {
    public int lengthOfLastWord(String s) {
        int count=0;
        int j=s.length()-1;
        char[] strs=s.toCharArray();
        while(strs[j]==' '){
            j=j-1;
        }
        int i=0;
        while(i<=j){
            if(strs[i]!=' '){
              count++;  
            }else{
                count=0;
            }  
            i++;
        }
        return count;
        
    }
}