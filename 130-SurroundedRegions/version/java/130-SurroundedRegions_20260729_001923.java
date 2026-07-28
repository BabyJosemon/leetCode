// Last updated: 29/07/2026, 00:19:23
1/**
2the problem says you should only flip Os that are fully surrounded — meaning not connected to any border O.
3
4The easier way to think about it is the reverse approach:
5
6Any O touching the border (or connected to one) is safe — it cannot be captured
7Everything else gets flipped
8
9So the correct strategy is:
10
11Start DFS from every O on the border
12Mark all Os reachable from the border as safe (e.g. temp mark as 'S')
13Then sweep the whole board — remaining Os become X, and Ss go back to O
14
15If there is a 0 at the border then all 0s directly connected to them are non coverable so find the border 0s first.
16Mark it as S (safe) first then mark all of their directly connected 0 neighbours to S as well.  */
17class Solution {
18    public void solve(char[][] board) {
19        int[][] directions = {{0,-1}, {-1,0}, {0,1}, {1,0}};
20        int rows = board.length;
21        int cols = board[0].length;
22        //Mark border 0s and their neighbours as S
23        for(int r = 0; r < rows; r++){
24            for(int c = 0; c < cols; c++){
25                if((r==0 || r==rows-1 || c==0 || c==cols-1) && board[r][c]=='O'){
26                    dfs(board, r, c, directions);
27                }
28            }
29        }
30        //now all edge 0s are Ss so the remaining 0s can be safely converted to Xs. and flip the Ss to 0s back to preserve
31        //input
32        for(int r = 0; r < rows; r++){
33            for(int c = 0; c < cols; c++){
34                if(board[r][c]=='O'){
35                    board[r][c]='X';
36                }
37                else if(board[r][c]=='S'){
38                    board[r][c]='O';
39                }
40            }
41        }
42            
43
44    }
45    public void dfs(char[][] board, int r, int c, int[][] directions){
46        //out of bounds check and the return to stop infinite loop
47        if(r<0 || r>=board.length || c<0 || c>=board[0].length || board[r][c]!='O'){
48            return;
49        }
50        board[r][c]='S';//Mark as safe
51        //Mark all its touching neighbours as S
52        for(int[] dir: directions){
53            dfs(board, r+dir[0], c+dir[1], directions);
54        }
55    }
56}