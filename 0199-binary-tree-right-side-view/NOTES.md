Use the same logic of BFS level order traversal using deque, just use another deque to add
all elements of currentLevel into this new deque head first. Then at the end of each level,
just get the element at head. This 2nd deque can be substituted by using a stack bcs we just
need the last inputed element, so LIFO works as well.