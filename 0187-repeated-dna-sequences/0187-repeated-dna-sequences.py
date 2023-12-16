class Solution:
    def findRepeatedDnaSequences(self, s: str) -> List[str]:
        winStart=0
        result=[]
        currentString=''
        cache={}
        for winEnd in range(9, len(s)):
            if winEnd>9:
                winStart+=1
            currentString=s[winStart:winEnd+1]
            if currentString in cache:
                cache[currentString]+=1
            else:
                cache[currentString]=1
        for k,v in cache.items():
            if v>=2:
                result.append(k)
        return result
           
                
                
        