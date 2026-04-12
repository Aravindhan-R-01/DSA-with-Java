// Swim in Rising Water
// You are given a square 2-D matrix of distinct integers grid where each integer grid[i][j] represents the elevation at position (i, j).
// Rain starts to fall at time = 0, which causes the water level to rise. At time t, the water level across the entire grid is t.
// You may swim either horizontally or vertically in the grid between two adjacent squares if the original elevation of both squares is less than or equal to the water level at time t.
// Starting from the top left square (0, 0), return the minimum amount of time it will take until it is possible to reach the bottom right square (n - 1, n - 1).
// Example 1:
// Input: grid = [[0,1],[2,3]]
// Output: 3
// Explanation: For a path to exist to the bottom right square grid[1][1] the water elevation must be at least 3. At time t = 3, the water level is 3.
// Example 2:
// Input: grid = [
//   [0,1,2,10],
//   [9,14,4,13],
//   [12,3,8,15],
//   [11,5,7,6]
// ]
// Output: 8
// Explanation: The water level must be at least 8 to reach the bottom right square. The path is [0, 1, 2, 4, 8, 7, 6].
// Constraints:
// grid.length == grid[i].length
// 1 <= grid.length <= 50
// 0 <= grid[i][j] < n^2



class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visit = new boolean[n][n];
        int minH = grid[0][0], maxH = grid[0][0];
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                maxH = Math.max(maxH, grid[row][col]);
                minH = Math.min(minH, grid[row][col]);
            }
        }
        for (int t = minH; t < maxH; t++) {
            if (dfs(grid, visit, 0, 0, t)) return t;
            for (int r = 0; r < n; r++) Arrays.fill(visit[r], false);
        }
        return maxH;
    }
    private boolean dfs(int[][] grid, boolean[][] visit, int r, int c, int t) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid.length || visit[r][c] || grid[r][c] > t) {
            return false;
        }
        if (r == grid.length - 1 && c == grid.length - 1) return true;
        visit[r][c] = true;
        return dfs(grid, visit, r + 1, c, t) ||
               dfs(grid, visit, r - 1, c, t) ||
               dfs(grid, visit, r, c + 1, t) ||
               dfs(grid, visit, r, c - 1, t);
    }
}
