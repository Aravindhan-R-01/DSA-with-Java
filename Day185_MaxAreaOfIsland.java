// Max Area of Island:
// You are given a matrix grid where grid[i] is either a 0 (representing water) or 1 (representing land).
// An island is defined as a group of 1's connected horizontally or vertically. You may assume all four edges of the grid are surrounded by water.
// The area of an island is defined as the number of cells within the island.
// Return the maximum area of an island in grid. If no island exists, return 0.
// Example 1:
// Input: grid = [
//   [0,1,1,0,1],
//   [1,0,1,0,1],
//   [0,1,1,0,1],
//   [0,1,0,0,1]
// ]
// Output: 6
// Explanation: 1's cannot be connected diagonally, so the maximum area of the island is 6.
// Constraints:
// 1 <= grid.length, grid[i].length <= 50




class Solution {
    private static final int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int maxAreaOfIsland(int[][] grid) {
        int ROWS = grid.length, COLS = grid[0].length;
        int area = 0;
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == 1) {
                    area = Math.max(area, dfs(grid, r, c));
                }
            }
        }
        return area;
    }
    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length ||
            c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int res = 1;
        for (int[] dir : directions) {
            res += dfs(grid, r + dir[0], c + dir[1]);
        }
        return res;
    }
}
