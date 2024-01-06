/* p1: if char is present in dictionary as a key(will only trigger for opening braces)
# p2: add the closing brace to the stack
# P3: if we encounter closing braces of any type it should be of the one corresponds to the one at top of stack
# p4: if there is only a closing brace without no starting brace then it is also invalid.
# p5: popping the stack should return most recent closing brace of an opened brace and the current encoutered character must be the same closing brace. anything else will make the input invalid and hence return False
# p6: at the end if string is valid then the stack must be empty after all popping. Checking to see if stack is empty. */

class Solution {
    public boolean isValid(String s) {
       Map<Character, Character> mapper = new HashMap<>();
        mapper.put('[',']');
        mapper.put('(',')');
        mapper.put('{','}');
        Stack<Character> stacker = new Stack<>();
        for(char chr:s.toCharArray()){
            if(mapper.containsKey(chr)){//p1
                stacker.push(mapper.get(chr));//p2
            }else{
                if(stacker.empty()){//p4
                    return false;
                }
                if(chr!=stacker.pop()){//p5
                    return false;    
                }
            }
        }
        if(stacker.empty()){
            return true;//p6
        }else{
            return false;
        }
        
        
        
    }
}