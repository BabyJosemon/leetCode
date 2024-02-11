/*
Use sliding window and use a hashmap, iterate through string and for each character we store the char and its index as K-V pair
Keep track of maxLenght using diff between winEnd and winStart +1. If we encounter a same character we will move winStart to 
the previously known index of this character +1. This is because now the unique window that will be considered will not have 
the older occurace of this character in it.
*/
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int winStart=0;
        Map<Character, Integer> cache=new HashMap<>();
        int maxLength=0;
        for(int winEnd=0;winEnd<s.length();winEnd++){
            char current=s.charAt(winEnd);
            if(cache.containsKey(current)){
                winStart=Math.max(winStart, cache.get(current)+1);
            }
            maxLength=Math.max(maxLength, winEnd-winStart+1);
            cache.put(current,winEnd);
        }
        return maxLength;
    }
}