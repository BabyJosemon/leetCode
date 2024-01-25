Use 2 stacks inputstack and outputstack.
To push into queue, just ​push into inputStack
To peek from 'front' of the queue, which is actually the first added item in inputStack the way is:
  if outputStack is empty:
    pop from inputstack and add to outputstack
    this way the last element of inputstack (which is its first added element) becomes top of output stack
    then return peek the top of outputstack
To pop from 'front' of the queue, which is actually the first added item in inputStack the way is:
  peek first
  pop top of outputstack
