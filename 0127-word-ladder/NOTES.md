Basically if we need to go from one word(node) to another word(node) that we are searching for, then we use BFS as it could be anywhere and we need the shortest. So in a way it is similar to minimum depth of tree question. We start with a deque with the first word, keep track of changes which will start at 1 as in our loop if we find it in first iteration we return it. We also keep track of visited nodes so that we dont traverse them again.
1. First If endword is not in wordList then return 0, makes no sense to go further.
2. declare an alphabet range
3. while queue(standard BFS routine)
4. find length of current queue and run a loop till this length
5. pop out word from queue(beginWord in first iteration)
6. for each word run a loop in alphabet list
7. every time we split the word into prefix and suffix so that one letter is