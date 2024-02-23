here we will also use sliding window. Create 2 empty hashmaps with all characters of the
alphabet as keys and 0 values. Then iterate thrrough s1 length and for each character at i
increment the value of both dictionary keys. eg. s1 = "ab", s2 = "eidbaooo" s1Map=
{'a':1, 'b':1,'c':0,....} s2Map={'a':0, 'b':0 , ... 'e':1, ...'i':1, 'j':0....}. At first we check if these
hashmaps are equal if they are return true. If not we start our sliding window. The basic"
principle is this:
slide a window of size s1Length over s2 and everytime decrement the counter of the
character going out in and increment the counter of character coming in from s2Map.
For that:
We start at winEnd at index 1 ("i" of "eidbaooo") and run it till lengthOfS2-lengthOfS1.
Character to pushout is winEnd-1 ('e'), character to pushin is winEnd+lengthOfS1-1.
This is bcs if we check for input "abc" and "eidbcaooo", the window to start ="idb"
So we need to maintain a window size of s1's length so we add it to winEnd and
subtract 1 due to indexing.
We decrement 1 from s2WindowMap[pushOutChar] and increment 1 to
s2WindowMap[pushInChar]. At each iteration we check if s1Map.equals(s2WindowMap)
and return true.
If we run through all elements and dont find anything return false.
##### This is O(26.n) because everytime we are checking if 2 hashmaps are equal
#### but there is a way to make this O(n) using a list. We can optimise this
#### to be O(s1Map.size() . n) which will only be O(26.n) in worst case.
#### this can be done by only creating hashmaps of the windowSize.
​
​