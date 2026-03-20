// Word Search:
// Given a 2-D grid of characters board and a string word, return true if the word is present in the grid, otherwise return false.
// For the word to be present it must be possible to form it with a path in the board with horizontally or vertically neighboring cells. The same cell may not be used more than once in a word.
// Example 1:
// Input: 
// board = [
//   ["A","B","C","D"],
//   ["S","A","A","T"],
//   ["A","C","A","E"]
// ],
// word = "CAT"
// Output: true
// Example 2:
// Input: 
// board = [
//   ["A","B","C","D"],
//   ["S","A","A","T"],
//   ["A","C","A","E"]
// ],
// word = "BAT"
// Output: false
// Constraints:
// 1 <= board.length, board[i].length <= 5
// 1 <= word.length <= 10
// board and word consists of only lowercase and uppercase English letters.



class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, word, i, j, 0)) return true;
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int index){
        if(index == word.length()) return true;
        if(i < 0 || j < 0 || i >= board.length || j >= board[0].length
           || board[i][j] != word.charAt(index)){
            return false;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        boolean found = dfs(board, word, i+1, j, index+1) ||   
                        dfs(board, word, i-1, j, index+1) ||   
                        dfs(board, word, i, j+1, index+1) ||   
                        dfs(board, word, i, j-1, index+1);     

        board[i][j] = temp;
        return found;
    }
}
