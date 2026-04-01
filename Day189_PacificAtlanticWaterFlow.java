// Pacific Atlantic Water Flow:
// You are given a rectangular island heights where heights[r][c] represents the height above sea level of the cell at coordinate (r, c).
// The islands borders the Pacific Ocean from the top and left sides, and borders the Atlantic Ocean from the bottom and right sides.
// Water can flow in four directions (up, down, left, or right) from a cell to a neighboring cell with height equal or lower. 
// Water can also flow into the ocean from cells adjacent to the ocean.
// Find all cells where water can flow from that cell to both the Pacific and Atlantic oceans. 
// Return it as a 2D list where each element is a list [r, c] representing the row and column of the cell. You may return the answer in any order.
// Example 1:
// Input: heights = [
//   [4,2,7,3,4],
//   [7,4,6,4,7],
//   [6,3,5,3,6]
// ]
// Output: [[0,2],[0,4],[1,0],[1,1],[1,2],[1,3],[1,4],[2,0]]
// Example 2:
// Input: heights = [[1],[1]]
// Output: [[0,0],[1,0]]
// Constraints:
// 1 <= heights.length, heights[r].length <= 100
// 0 <= heights[r][c] <= 1000




class Solution {
    private int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length, COLS = heights[0].length;
        boolean[][] pac = new boolean[ROWS][COLS];
        boolean[][] atl = new boolean[ROWS][COLS];
        for (int c = 0; c < COLS; c++) {
            dfs(0, c, pac, heights);
            dfs(ROWS - 1, c, atl, heights);
        }
        for (int r = 0; r < ROWS; r++) {
            dfs(r, 0, pac, heights);
            dfs(r, COLS - 1, atl, heights);
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (pac[r][c] && atl[r][c]) res.add(Arrays.asList(r, c));
            }
        }
        return res;
    }
    private void dfs(int r, int c, boolean[][] ocean, int[][] heights) {
        ocean[r][c] = true;
        for (int[] d : directions) {
            int nr = r + d[0], nc = c + d[1];
            if (nr >= 0 && nr < heights.length && nc >= 0 && nc < heights[0].length && !ocean[nr][nc] && 
                heights[nr][nc] >= heights[r][c]) dfs(nr, nc, ocean, heights);
        }
    }
}
