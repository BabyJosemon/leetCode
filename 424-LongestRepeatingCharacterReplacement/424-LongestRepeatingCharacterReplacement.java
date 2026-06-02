// Last updated: 03/06/2026, 00:10:45
/*I kept the Sliding Window pattern in the back of my head to help with the intuition. Based on the problem, we know that we have to:

Iterate over a data structure
Keep track of our desired state
Find a window that satisfies our desired state
Let’s try it on paper first. Suppose we have the following input:

s = "ABABBA", k = 2
We need to find the longest contiguous substring where k replacements are allowed to make all the characters the same. We begin iterating through the string as the first step.

Now, how do we know which characters need replacing? We need to store the frequency count of the characters in our current window. A set doesn’t really help here, and an array isn’t necessary, so we use a map.

As we iterate, we update the frequency map. At some point, our window might look like this:

A B A B B
map = {A: 2, B: 3}
This represents our current window. Since k = 2, we are allowed to replace up to 2 characters to make all characters in the window the same.

So what does it mean for our state to be invalid?
To make all characters the same, we only need to replace the characters that are not the most frequent one. That means the number of replacements needed is:

current window size - highest frequency character
So our invalid state is:

if (end - start + 1) - highest_frequency > k
If we move on to the next character, the state can become invalid and we may need to move the window:

A B A B B A
map = {A: 3, B: 3}

if (end - start + 1) - highest_frequency > k
=> if 6 - 3 > 2
=> TRUE
At this point, we’ve exceeded the number of allowed replacements, so the window is no longer valid.

How do we slide over and fix the state? We move the start pointer up by one and remove that character from the map, since it no longer represents our current window:

if (end - start + 1) - highest_frequency > k:
    map[s[start]] -= 1
    start += 1

#  A [B A B B A]
This shrinks the window until it becomes valid again.

Relating this back to a Sliding Window template */
class Solution {
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> charFrequency = new HashMap<>();
        int start =0;
        int maxFrequencyCharacter=0;
        int maxWindowSizeSeenTillNow=0;
        for(int end=0;end<s.length();end++){
            char currentCharacter = s.charAt(end);
            charFrequency.put(currentCharacter, charFrequency.getOrDefault(currentCharacter,0)+1);
            maxFrequencyCharacter = Math.max(maxFrequencyCharacter, charFrequency.get(currentCharacter));
            //size of valid window = Frequency of most frequent character + k
            if((end-start+1)-maxFrequencyCharacter>k){
                //not a valid window so contract window
                char characterAtStart=s.charAt(start);
                charFrequency.put(characterAtStart,charFrequency.get(characterAtStart)-1);
                start++;
            }
            //after getting through the if block we have a valid window
            //get its size
            maxWindowSizeSeenTillNow = Math.max((end-start+1),maxWindowSizeSeenTillNow);
        }
        return maxWindowSizeSeenTillNow;
        
    }
}