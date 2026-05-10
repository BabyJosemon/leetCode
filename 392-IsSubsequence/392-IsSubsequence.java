// Last updated: 10/05/2026, 20:46:20
//this can also be solved by two pointers. Each pointer on each string. Each char of s should be in t and the order should
//be preserved, this is an advantage for us. pointer i in s and pointer j in t. if s[i]==t[j]  that means we "found" the
//letter at position i for s. we only increment i when we find a matching in t but we increment j everytime. This means
//j is run from start of t to end.
class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.length()==0){
            return true;
        }
        int iteratorI=0;
        int iternatorJ=0;
        for(int iteratorJ=0;iteratorJ<t.length();iteratorJ++){
            if(s.charAt(iteratorI)==t.charAt(iteratorJ)){
                iteratorI++;
                if(iteratorI==s.length()){
                   return true;
                }
            }
        }
        return false;
    }
}