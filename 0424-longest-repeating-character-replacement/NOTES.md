Eg."AABABBA", k=1 The Question asks us what is the longest window we can get by
substituting less than or equal to k values. The idea is this:
If we were to take a sample window eg. "BABB" how would we know that this window is
valid? Well if we were to make it valid we would replace the least frequent characters.
Here it is just 1 (A) so only 1 substitution required so this is valid. The formula here
would be if lengthOfWindow-mostFrequentCount<=k then it is valid.
So at start creating a window while also keeping track of the char with maxFrequency.
At each window check IF lengthOfWindow-mostFrequentCount<=k then just keep
track of this max(lengthOfWindow)
ELSE
if lengthOfWindow-mostFrequentCount>k, (eg "ABAB" lengthOfWindow=4, mostF=2)
then we need to keep reducing this window till it gets valid again. (eg."BAB",
lengthOfWindow=3, mostF=3, ) So we need to keep track of maxF at that gets changed if
we reduce the size. MostF can be calculated using Collections.max(cache.values()) or
by using a MaxHeap:
```
PriorityQueue<Integer> pQueue=new PriorityQueue<>(Collections.reverseOrder());
pQueue.add(20);
pQueue.add(10);
System.out.println("Head value using peek function:" + pQueue.peek());
System.out.println("Remove head value to get= "+pQueue.poll());
```
This makes our code O(26.n). We can make it O(n) by simply not checking for the
updated mostFrequentCharactersCount.
```
class Solution {
public int characterReplacement(String s, int k) {
Map<Character, Integer> cache=new HashMap<>();
int winStart=0,  resultMaxLength=0, winEnd;
int mostFrequentCharCount=0,
for(winEnd=0;winEnd<s.length();winEnd++){
char currentChar=s.charAt(winEnd);
if(!cache.containsKey(currentChar)){
cache.put(currentChar,0);
}
int currentCharCount=cache.get(currentChar)+1;
cache.put(currentChar, currentCharCount);
mostFrequentCharCount=Math.max(mostFrequentCharCount, currentCharCount);
int windowLength=(winEnd-winStart)+1;
if(windowLength-mostFrequentCharCount>k){//reduce window size
char leftMostChar=s.charAt(winStart);
cache.put(leftMostChar, cache.get(leftMostChar)-1);
winStart+=1;
}
resultMaxLength=Math.max(resultMaxLength, windowLength);
}
return resultMaxLength;
}
}
```
​