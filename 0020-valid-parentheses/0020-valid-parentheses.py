# p1: if char is present in dictionary as a key(will only trigger for opening braces)
# p2: add the closing brace to the stack
# P3: if we encounter closing braces of any type it should be of the one corresponds to the one at top of stack
# p4: if there is only a closing brace without no starting brace then it is also invalid.
# p5: popping the stack should return most recent closing brace of an opened brace and the current encoutered character must be the same closing brace. anything else will make the input invalid and hence return False
# p6: at the end if string is valid then the stack must be empty after all popping. Checking to see if stack is empty.
class Solution:
    def isValid(self, s: str) -> bool:
        stack=[]
        possibleCharacters={'(':')',
                            '{':'}',
                            '[':']'}
        for char in s:# p1
            if char in possibleCharacters:
                stack.append(possibleCharacters[char]) # p2
            else: # p3
                if len(stack)==0: # p4
                    return False
                if  char!=stack.pop(): # p5
                    return False
        return len(stack)==0 # p6
                
                
                
        