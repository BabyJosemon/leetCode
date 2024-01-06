
class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int firstOperand, secondOperand, answer, temp;
        for(String s: tokens){
            if(isNum(s)){
                temp=Integer.parseInt(s);
                stack.addFirst(temp);
            }else{
                secondOperand=stack.removeFirst();
                firstOperand=stack.removeFirst();
                answer=solve(firstOperand, secondOperand, s);
                stack.addFirst(answer);
            }    
        }
        return stack.peekFirst();
    }
    public boolean isNum(String num){
        try{
            int numC=Integer.parseInt(num);
        }catch(NumberFormatException nfe){
            return false;
        }    
        return true;
    }
    
    public int solve(int first, int second, String operator){
        int answer=0;
        switch(operator){
            case "+": answer=first+second;
                break;
            case "-": answer=first-second;
                break;
            case "*": answer=first*second;
                break;
            case "/": 
                answer=first/second;
                break;
        }
        return answer;
    }
}