class Solution:
    def groupAnagrams(self, strs: List[str]) -> List[List[str]]:
        cache={}#this will store our key:value(list) pairs
        for word in strs:
            temp=''.join(sorted(word))#temp is the word formed by sorting the letters of the word
            if temp not in cache:
                cache[temp]=[word]#if its the first add to dictionary
            else:
                cache[temp].append(word)#append if already exists
        return list(cache.values())#just return the values