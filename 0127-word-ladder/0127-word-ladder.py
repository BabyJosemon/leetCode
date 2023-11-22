from collections import deque   
class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        queue=deque([beginWord])# we have to put in list otherwise popping gives us each letter and not the whole word
        changes=1
        visited=set([beginWord])
        wordList = set(wordList)
        
        if endWord not in wordList:#base case
            return 0
        
        alph="abcdefghijklmnopqrstuvwxyz"#used to find all permutations of words
        
        while queue:#standard BFS
            currentLevelSize=len(queue)#standard BFS
            for j in range(currentLevelSize):#standard BFS
                currentWord=queue.popleft()#standard BFS
                #print(currentWord)
                #print(changes)
                if currentWord==endWord:#if we find the endWord then return and stop code
                    return changes
                for i in range(len(currentWord)):#here we take each letter from the word and substitute it with all values in alph and if any of these new words is in wordList and not visited yet, we add it to queue and visited.
                    prefix=currentWord[:i]
                    suffix=currentWord[i+1:]
                    for letter in alph:
                        currentModWord=prefix+letter+suffix#modified word
                        if currentModWord in wordList and currentModWord not in visited:
                            queue.append(currentModWord)
                            visited.add(currentModWord)
            changes+=1#increment changes at the end of each level of BFS until we find.
        return 0
            
#Basically if we need to go from one word(node) to another word(node) that we are searching for, then we use BFS as it could be anywhere and we need the shortest. So in a way it is similar to minimum depth of tree question. We start with a deque with the first word, keep track of changes which will start at 1 as in our loop if we find it in first iteration we return it. We also keep track of visited nodes so that we dont traverse them again.
