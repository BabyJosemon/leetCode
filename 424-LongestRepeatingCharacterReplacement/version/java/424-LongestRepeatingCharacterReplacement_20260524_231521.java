// Last updated: 24/05/2026, 23:15:21
1/*I kept the Sliding Window pattern in the back of my head to help with the intuition. Based on the problem, we know that we have to:
2
3Iterate over a data structure
4Keep track of our desired state
5Find a window that satisfies our desired state
6Let’s try it on paper first. Suppose we have the following input:
7
8s = "ABABBA", k = 2
9We need to find the longest contiguous substring where k replacements are allowed to make all the characters the same. We begin iterating through the string as the first step.
10
11Now, how do we know which characters need replacing? We need to store the frequency count of the characters in our current window. A set doesn’t really help here, and an array isn’t necessary, so we use a map.
12
13As we iterate, we update the frequency map. At some point, our window might look like this:
14
15A B A B B
16map = {A: 2, B: 3}
17This represents our current window. Since k = 2, we are allowed to replace up to 2 characters to make all characters in the window the same.
18
19So what does it mean for our state to be invalid?
20To make all characters the same, we only need to replace the characters that are not the most frequent one. That means the number of replacements needed is:
21
22current window size - highest frequency character
23So our invalid state is:
24
25if (end - start + 1) - highest_frequency > k
26If we move on to the next character, the state can become invalid and we may need to move the window:
27
28A B A B B A
29map = {A: 3, B: 3}
30
31if (end - start + 1) - highest_frequency > k
32=> if 6 - 3 > 2
33=> TRUE
34At this point, we’ve exceeded the number of allowed replacements, so the window is no longer valid.
35
36How do we slide over and fix the state? We move the start pointer up by one and remove that character from the map, since it no longer represents our current window:
37
38if (end - start + 1) - highest_frequency > k:
39    map[s[start]] -= 1
40    start += 1
41
42#  A [B A B B A]
43This shrinks the window until it becomes valid again.
44
45Relating this back to a Sliding Window template */
46class Solution {
47    public int characterReplacement(String s, int k) {
48        Map<Character, Integer> charFrequency = new HashMap<>();
49        int start =0;
50        int maxFrequencyCharacter=0;
51        int maxWindowSizeSeenTillNow=0;
52        for(int end=0;end<s.length();end++){
53            char currentCharacter = s.charAt(end);
54            charFrequency.put(currentCharacter, charFrequency.getOrDefault(currentCharacter,0)+1);
55            maxFrequencyCharacter = Math.max(maxFrequencyCharacter, charFrequency.get(currentCharacter));
56            //size of valid window = Frequency of most frequent character + k
57            if((end-start+1)-maxFrequencyCharacter>k){
58                //not a valid window so contract window
59                char characterAtStart=s.charAt(start);
60                charFrequency.put(characterAtStart,charFrequency.get(characterAtStart)-1);
61                start++;
62            }
63            //after getting through the if block we have a valid window
64            //get its size
65            maxWindowSizeSeenTillNow = Math.max((end-start+1),maxWindowSizeSeenTillNow);
66        }
67        return maxWindowSizeSeenTillNow;
68        
69    }
70}