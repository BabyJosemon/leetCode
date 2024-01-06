in polish notation the operator comes before the operands, eg +3 5, means 3+5. This is reverse of it, use a stack.
Created a helper method to check if string is num using Integer.parseInt() and returning false if exception is caught.
Loop through tokens, if number is found add to stack implemented using the faster ArrayDeque() instead of Stack().
Then when operator is found pop last two numbers from stack, use another helper function to calculate the result with these numbers and operator and add the result back to the stack so that the result is propagated forward.