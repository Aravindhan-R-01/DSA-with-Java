// Number of Islands:
// Given a 2D grid grid where '1' represents land and '0' represents water, count and return the number of islands.
// An island is formed by connecting adjacent lands horizontally or vertically and is surrounded by water. You may assume water is surrounding the grid (i.e., all the edges are water).
// Example 1:
// Input: grid = [
//     ["0","1","1","1","0"],
//     ["0","1","0","1","0"],
//     ["1","1","0","0","0"],
//     ["0","0","0","0","0"]
//   ]
// Output: 1
// Example 2:
// Input: grid = [
//     ["1","1","0","0","1"],
//     ["1","1","0","0","1"],
//     ["0","0","1","0","0"],
//     ["0","0","0","1","1"]
//   ]
// Output: 4
// Constraints:
// 1 <= grid.length, grid[i].length <= 100
// grid[i][j] is '0' or '1'.




class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int numIslands(char[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int islands = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == '1') {
                    dfs(grid, r, c);
                    islands++;
                }
            }
        }
        return islands;
    }
    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length ||
            c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] dir : directions) {
            dfs(grid, r + dir[0], c + dir[1]);
        }
    }
}
