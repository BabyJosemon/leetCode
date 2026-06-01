// Last updated: 02/06/2026, 00:14:29
1/*This is a very game like question where you have save states and loading. Basically you use a stack as your save/load point. And you need to save both string 
2and numbers. We will also use currentString and currentNumber which represent the currently building string and the last seen number. We will save these in 
3the stack. The challenge is nesting — you need to finish the inner 2[c] before you can do the outer 3[...]. When you hit a [, you're saying "pause what I'm
4 building, save my states on the stacks start something fresh (this is why we reset)". When you hit a ], you're saying "I'm done inside, resume what I paused and attach the repeated result to it".
5*/
6class Solution {
7    public String decodeString(String s) {
8        Stack<String> stringNotepad = new Stack<>();
9        Stack<Integer> numberNotepad = new Stack<>();
10        String currentString = "";
11        Integer currentNumber = 0;
12        for(char currentChar: s.toCharArray()){
13            //first check the mind goes for:
14            //if currentChar is Char? currentString.append(currentChar)
15            //if currentChar is Digit? currentNumber = (Integer)currentChar
16            if(currentChar=='['){
17                //save your progress
18                stringNotepad.push(currentString);
19                numberNotepad.push(currentNumber);
20                //reset your states
21                currentString = "";
22                currentNumber = 0;
23            }else if(currentChar==']'){
24                //we are done with innerloop so append whatever we made to currentString.
25                String previousString = stringNotepad.pop();
26                Integer previousNumber = numberNotepad.pop();
27                //eg. is 2[c] We append by adding the currentString multiplied 2 times (number of times req.) to the
28                //previously saved string (a in this case) 
29                currentString = previousString + currentString.repeat(previousNumber);
30            }else if(Character.isDigit(currentChar)){
31                //if a (String)number  then we need to convert it and store it as current
32                //c - '0' converts a digit character to an actual integer, The * 10 part handles multi-digit numbers
33                //Imagine reading 123 one character at a time:
34                currentNumber = (currentNumber*10)+(currentChar-'0');
35            }else{
36                //just append to currently building string.
37                currentString+=currentChar;
38            }
39        }
40        return currentString;
41    }
42}