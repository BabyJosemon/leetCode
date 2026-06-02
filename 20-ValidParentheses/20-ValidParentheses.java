// Last updated: 03/06/2026, 00:10:59
/**This is a stack question because we have an order to maintain. And stack helps maintain that order. Basically keep 
appending to stack if the currentChar is an opening brace of any kind. And then when currentChar is a closing brace we 
need to pop its matching opening char. The only reason we will not be able to pop its matching opening char is when 
1) the Top char is not the matching opening to the closing currentChar.
2) There is nothing to pop, stack empty.
To know which is the corresponding opening to a closing brace we maintain a map. And at the end when String s is done we 
can check if stack is empty in which case all braces have been processed and we have a valid testcase but not empty then 
we have leftovers and its not a valid parenthesis. Or we could check at the very start if length of input is odd then we
 definetely have a false testcase.*/
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> closingMatches = new HashMap<>();
        closingMatches.put(')','(');
        closingMatches.put(']','[');
        closingMatches.put('}','{');
        for(char currentChar : s.toCharArray()){
            //We could have also started with assuming we got a closing char as well using containsKey()
            if(closingMatches.containsValue(currentChar)){
                stack.push(currentChar);
            }else{
                //we found a closingChar, which can only be valid in the above 2 conditions
                if(stack.isEmpty() || stack.peek()!=closingMatches.get(currentChar)){
                    return false;
                }
                stack.pop();
            }
        }
        //if stack still has some left after then we invalid.
        return stack.isEmpty();
    }
}