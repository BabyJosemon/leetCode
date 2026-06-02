// Last updated: 03/06/2026, 00:10:50
/*There is also a lazy solution which might be more intuitive. only using 1 stack. Basically keep adding stuff to the 
stack until you see a ]. When you do see one, start popping characters until you see a [. And while popping keep adding 
them to a temporary string. When you do reach a [ pop that out because it is of no use other than telling us that now 
after this we will see a number (the multiplier of temporary string). Start popping and keep popping while the popped
item is a number. For each popped number use it to build a multiplier. Once we are done we multiply this number to the
temporary string and add it back to the stack. Then we continue iterating the input string till we see another ] to 
start the process again. This solution uses one stack and is more "lazy" — it just throws everything onto the stack and only figures things out when it hits a ].
*/
class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        for (char currentChar : s.toCharArray()) {
            if (currentChar != ']') {
                //push everything
                stack.push(String.valueOf(currentChar));
            } else {
                //now we do the actual work
                // build the inner string (prepend to preserve order)
                StringBuilder temporaryString = new StringBuilder();
                while (!stack.isEmpty() && !stack.peek().equals("[")) {
                    temporaryString.insert(0, stack.pop());
                }
                stack.pop(); // discard the '['

                // build the number string (prepend to preserve order)
                String multiplierStr = "";
                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
                    multiplierStr = stack.pop() + multiplierStr;
                }
                int repeatCount = Integer.parseInt(multiplierStr);

                // repeat and push back
                stack.push(temporaryString.toString().repeat(repeatCount));
            }
        }

        return String.join("", stack);
    }
}