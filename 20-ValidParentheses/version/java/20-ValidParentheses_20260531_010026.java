// Last updated: 31/05/2026, 01:00:26
// At first I thought checking length of String s being odd would tell me immediately if invalid and that this meant I did not need to check the size of stack at the end. But testcases like "((" will fail that. So we keep return stack.isEmpty();
1/**This is a stack question because we have an order to maintain. And stack helps maintain that order. Basically keep 
2appending to stack if the currentChar is an opening brace of any kind. And then when currentChar is a closing brace we 
3need to pop its matching opening char. The only reason we will not be able to pop its matching opening char is when 
41) the Top char is not the matching opening to the closing currentChar.
52) There is nothing to pop, stack empty.
6To know which is the corresponding opening to a closing brace we maintain a map. And at the end when String s is done we 
7can check if stack is empty in which case all braces have been processed and we have a valid testcase but not empty then 
8we have leftovers and its not a valid parenthesis. Or we could check at the very start if length of input is odd then we
9 definetely have a false testcase.*/
10class Solution {
11    public boolean isValid(String s) {
12        Stack<Character> stack = new Stack<>();
13        Map<Character, Character> closingMatches = new HashMap<>();
14        closingMatches.put(')','(');
15        closingMatches.put(']','[');
16        closingMatches.put('}','{');
17        for(char currentChar : s.toCharArray()){
18            //We could have also started with assuming we got a closing char as well using containsKey()
19            if(closingMatches.containsValue(currentChar)){
20                stack.push(currentChar);
21            }else{
22                //we found a closingChar, which can only be valid in the above 2 conditions
23                if(stack.isEmpty() || stack.peek()!=closingMatches.get(currentChar)){
24                    return false;
25                }
26                stack.pop();
27            }
28        }
29        //if stack still has some left after then we invalid.
30        return stack.isEmpty();
31    }
32}