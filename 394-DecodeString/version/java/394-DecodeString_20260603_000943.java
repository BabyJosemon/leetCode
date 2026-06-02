// Last updated: 03/06/2026, 00:09:43
1/*There is also a lazy solution which might be more intuitive. only using 1 stack. Basically keep adding stuff to the 
2stack until you see a ]. When you do see one, start popping characters until you see a [. And while popping keep adding 
3them to a temporary string. When you do reach a [ pop that out because it is of no use other than telling us that now 
4after this we will see a number (the multiplier of temporary string). Start popping and keep popping while the popped
5item is a number. For each popped number use it to build a multiplier. Once we are done we multiply this number to the
6temporary string and add it back to the stack. Then we continue iterating the input string till we see another ] to 
7start the process again. This solution uses one stack and is more "lazy" — it just throws everything onto the stack and only figures things out when it hits a ].
8*/
9class Solution {
10    public String decodeString(String s) {
11        Stack<String> stack = new Stack<>();
12        for (char currentChar : s.toCharArray()) {
13            if (currentChar != ']') {
14                //push everything
15                stack.push(String.valueOf(currentChar));
16            } else {
17                //now we do the actual work
18                // build the inner string (prepend to preserve order)
19                StringBuilder temporaryString = new StringBuilder();
20                while (!stack.isEmpty() && !stack.peek().equals("[")) {
21                    temporaryString.insert(0, stack.pop());
22                }
23                stack.pop(); // discard the '['
24
25                // build the number string (prepend to preserve order)
26                String multiplierStr = "";
27                while (!stack.isEmpty() && Character.isDigit(stack.peek().charAt(0))) {
28                    multiplierStr = stack.pop() + multiplierStr;
29                }
30                int repeatCount = Integer.parseInt(multiplierStr);
31
32                // repeat and push back
33                stack.push(temporaryString.toString().repeat(repeatCount));
34            }
35        }
36
37        return String.join("", stack);
38    }
39}