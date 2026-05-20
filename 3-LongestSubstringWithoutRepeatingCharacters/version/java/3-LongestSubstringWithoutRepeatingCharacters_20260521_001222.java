// Last updated: 21/05/2026, 00:12:22
1/* This is also a variable length sliding window problem. Here the window is only distict characters. "abcabcbb" logically we start from a->b->c and then we see another a. Now we know we have seen a already and the maxLength of unique substring till now is 3 (a,b,c) but because of this new a (a,b,c,a) is not a valid substring. So we move start from where it is currently (s[0]) to someplace where the substring is valid again. This substring a,b,c,a will only we valid again if we remove the double a and since we need to move ahead we will move start in a way that skips first a. So ideologically we move start to lastKnownPosition of repeated character +1. so from b so that the new string b,c,a is now valid. We continue this forward and everytime we dont need to move start we improve maxLength.  To move start to lastKnownPosition of repeated character +1, we need to keep track of positions of characters seen till now, hence the hashmap. Once we move start we will put the new location of the just seen character from last known to current position. e.g. a in previous case moves from 0 to 3.
2
3However there is still a testcase that will fail my idea "tmmzuxt" this is because at end=6 when valid substring till now is mzux my code moves start but it moves it to lastknownPosition of t +1 which is 1 making my current substring mmzuxt. This is wrong because before reaching this point start was 2 because of repeating m which makes the substring size 6. So we have to keep check that start never goes back and stays at least same or larger than current value. to start stays at 2 and we have correct size.
4One other thing that causes problem is the fact that when we move end, we move it till we have valid substring and everytime we move it, we check maxLength updated. But when we do find a duplicate we move start till the remaining window is also valid. But we were never checking the length of this new window after contracting as well .And we need to do it so we will add the maxLength check at the end irrespective of duplicate found or not in an iteration. 
5Think of it this way: after every step you've correctly positioned start and end to represent the best valid window at that point. You should always check if that window is the longest so far — not just on the steps where nothing went wrong.*/
6class Solution {
7    public int lengthOfLongestSubstring(String s) {
8        int start = 0;
9        Map<Character, Integer> charAndPosition = new HashMap<>();
10        int maxLength=0;
11        for(int end=0; end<s.length() ;end++){
12            char currentChar=s.charAt(end);
13            //if we have seen currenChar before
14            if(charAndPosition.containsKey(currentChar)){
15                //System.out.println("start was "+ start);
16                start = Math.max(start,charAndPosition.get(currentChar)+1);
17                //System.out.println("start now is "+ start);
18            }
19            charAndPosition.put(currentChar,end);
20            maxLength=Math.max(maxLength,end-start+1);
21        }
22        return maxLength;
23    }
24}