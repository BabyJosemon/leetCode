class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){//base case
            return false;
        }
        int lengthOfS1=s1.length();
        int lengthOfS2=s2.length();
        Map<Character, Integer> s1Map=new HashMap<>();
        Map<Character, Integer> s2WindowMap=new HashMap<>();
        for(char ch='a'; ch<='z';ch++){
            s1Map.put(ch, 0);
            s2WindowMap.put(ch, 0);
        }
        for(int i=0;i<lengthOfS1;i++){
            s1Map.put(s1.charAt(i), s1Map.get(s1.charAt(i))+1);
            s2WindowMap.put(s2.charAt(i), s2WindowMap.get(s2.charAt(i))+1);
        }
        if(s1Map.equals(s2WindowMap)){return true;}
        //Now we start the sliding window
        for(int winEnd=1; winEnd<=lengthOfS2-lengthOfS1; winEnd++){
            char pushOutChar=s2.charAt(winEnd-1);
            char pushInChar=s2.charAt(winEnd+lengthOfS1-1);
            s2WindowMap.put(pushOutChar, s2WindowMap.get(pushOutChar)-1);
            s2WindowMap.put(pushInChar, s2WindowMap.get(pushInChar)+1);
            if(s1Map.equals(s2WindowMap)){return true;}
        }
        return false;
    }
}