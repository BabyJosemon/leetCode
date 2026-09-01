// Last updated: 01/09/2026, 23:19:50
1/**
2Uses the same base algo used for dfs matrix. here you dont need a visited set as if a cell is not the original starting 
3color of [sr][sc] then you can return. You only need to change the color if it is the original Color. Then recurse into
4the four directions and do the same. If the first [sr][sc] cell is already the correct color then we do not need to do 
5anything more.
6 */
7class Solution {
8    int[][] directions = {{-1,0}, {0,-1}, {1,0}, {0,1}};
9    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
10        int originalColor = image[sr][sc];
11        if(originalColor==color){
12            return image;
13        }
14        dfsHelper(image, sr, sc, color, originalColor);
15        return image;
16    }
17    public void dfsHelper(int[][] image, int row, int col, int paintColor, int originalColor){
18        //check bounds first
19        if(row<0 || row>=image.length || col<0 || col>=image[0].length){
20            return;
21        }
22        //instead of visited, if we current cell is not originalColor then dont go further into its 4 directions. just
23        //return
24        if(image[row][col]!=originalColor){
25            return;
26        }
27        //now all that will get to here are those which are in bounds and also are originalColor. We can paint these.
28        image[row][col] = paintColor;
29        //and now go into its 4 directions.
30        for(int[] direction: directions){
31            dfsHelper(image, row+direction[0], col+direction[1], paintColor, originalColor);
32        }
33        //return at the end if nothing falls
34        return;
35    }
36}