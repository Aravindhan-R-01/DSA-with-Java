// Islands and Treasure:
// You are given a (m × n) 2D grid initialized with these three possible values:
// -1 - A water cell that can not be traversed.
// 0 - A treasure chest.
// INF - A land cell that can be traversed. We use the integer 2^31 - 1 = 2147483647 to represent INF.
// Fill each land cell with the distance to its nearest treasure chest. If a land cell cannot reach a treasure chest then the value should remain INF.
// Assume the grid can only be traversed up, down, left, or right.
// Modify the grid in-place.
// Example 1:
// Input: [
//   [2147483647,-1,0,2147483647],
//   [2147483647,2147483647,2147483647,-1],
//   [2147483647,-1,2147483647,-1],
//   [0,-1,2147483647,2147483647]
// ]
// Output: [
//   [3,-1,0,1],
//   [2,2,1,-1],
//   [1,-1,2,-1],
//   [0,-1,3,4]
// ]
// Example 2:
// Input: [
//   [0,-1],
//   [2147483647,2147483647]
// ]
// Output: [
//   [0,-1],
//   [1,2]
// ]
// Constraints:
// m == grid.length
// n == grid[i].length
// 1 <= m, n <= 100
// grid[i][j] is one of {-1, 0, 2147483647}


class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private int INF = 2147483647;
    private boolean[][] visit;
    private int ROWS, COLS;
    private int dfs(int[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= ROWS || c >= COLS || grid[r][c] == -1 || visit[r][c]) return INF;
        if (grid[r][c] == 0) return 0;
        visit[r][c] = true;
        int res = INF;
        for (int[] dir : directions) {
            int cur = dfs(grid, r + dir[0], c + dir[1]);
            if (cur != INF) res = Math.min(res, 1 + cur);
        }
        visit[r][c] = false;
        return res;
    }
    public void islandsAndTreasure(int[][] grid) {
        ROWS = grid.length;
        COLS = grid[0].length;
        visit = new boolean[ROWS][COLS];
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (grid[r][c] == INF) grid[r][c] = dfs(grid, r, c);
            }
        }
    }
}
