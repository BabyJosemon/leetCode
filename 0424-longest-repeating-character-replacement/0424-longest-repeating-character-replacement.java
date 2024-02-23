class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> cache=new HashMap<>();
        int winStart=0, resultMaxLength=0, winEnd;
        for(winEnd=0;winEnd<s.length();winEnd++){
            char currentChar=s.charAt(winEnd);
            if(!cache.containsKey(currentChar)){
                cache.put(currentChar,0);
            }
            int currentCharCount=cache.get(currentChar)+1;
            cache.put(currentChar, currentCharCount);
            int windowLength=(winEnd-winStart)+1;
            if(windowLength-Collections.max(cache.values())>k){//reduce window size
                char leftMostChar=s.charAt(winStart);
                cache.put(leftMostChar, cache.get(leftMostChar)-1);
                winStart+=1;
            }
            resultMaxLength=Math.max(resultMaxLength, winEnd-winStart+1);
            
        }
        return resultMaxLength;
        
    }
}