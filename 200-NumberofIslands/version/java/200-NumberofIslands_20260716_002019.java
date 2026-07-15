// Last updated: 16/07/2026, 00:20:19
1/**This is a complex DFS question, we use DFS because we are counting distinct regions in a grid. Some points about this:
2we start from row = 0, col=0, and move forward until we see a 1. This is a start of an island and we need to explore this
3island fully. 
4For each point we recursively call dfs and check a couple of things like is it visited? is it 0? is it outside the grid?
5If it is not water (0) then we store it in a hashset so we keep track of what cords we have visited (or change to 0)
6How would a point be outside the grid? This will happen bcs after checking these above conditions we will move from our
7initial point.
8From a point (a,b) there can be 4 directions to move in a grid, left (0,-1), right (0,1), up(-1,0), down (1,0)
9and we recursively call dfs in all these directions.
10At the end of the first dfs (which will end after exploring whole island from (0,0) in eg2) we will iterate a counter.
11This is returned at the end.
12*/
13class Solution {
14    public int numIslands(char[][] grid) {
15        int rows = grid.length, cols = grid[0].length;
16        Set<String> visitedCords = new HashSet<>();
17        int[][] directions = { { 0, -1 }, { 0, 1 }, { -1, 0 }, { 1, 0 } };
18        int count = 0;
19        for (int r = 0; r < rows; r++) {
20            for (int c = 0; c < cols; c++) {
21                if (grid[r][c] == '1' && !visitedCords.contains(r + "," + c)) {
22                    dfs(grid, r, c, visitedCords, directions);
23                    count++;
24                }
25            }
26        }
27        return count;
28    }
29
30    public void dfs(char[][] grid, int row, int col, Set<String> visitedCords, int[][] directions) {
31        //our checks
32        String coordinate = row + "," + col;
33        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length)
34            return; //outside grid
35        if (grid[row][col] == '0')
36            return; //water
37        if (visitedCords.contains(coordinate))
38            return;// seen this coordinate before
39        visitedCords.add(coordinate);//must be a new 1
40        for (int[] dir : directions) {
41            dfs(grid, row + dir[0], col + dir[1], visitedCords, directions);//now we move from current position
42        }
43    }
44}