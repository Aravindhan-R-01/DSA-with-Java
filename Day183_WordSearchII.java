// Word Search II:
// Given a 2-D grid of characters board and a list of strings words, return all words that are present in the grid.
// For a word to be present it must be possible to form the word with a path in the board with horizontally or vertically neighboring cells. 
// The same cell may not be used more than once in a word.
// Example 1:
// Input:
// board = [
//   ["a","b","c","d"],
//   ["s","a","a","t"],
//   ["a","c","k","e"],
//   ["a","c","d","n"]
// ],
// words = ["bat","cat","back","backend","stack"]
// Output: ["cat","back","backend"]
// Example 2:
// Input:
// board = [
//   ["x","o"],
//   ["x","o"]
// ],
// words = ["xoxo"]
// Output: []
// Constraints:
// 1 <= board.length, board[i].length <= 12
// board[i] consists only of lowercase English letter.
// 1 <= words.length <= 30,000
// 1 <= words[i].length <= 10
// words[i] consists only of lowercase English letters.
// All strings within words are distinct.



class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        int ROWS = board.length, COLS = board[0].length;
        List<String> res = new ArrayList<>();
        for (String word : words) {
            boolean flag = false;
            for (int r = 0; r < ROWS && !flag; r++) {
                for (int c = 0; c < COLS; c++) {
                    if (board[r][c] != word.charAt(0)) continue;
                    if (backtrack(board, r, c, word, 0)) {
                        res.add(word);
                        flag = true;
                        break;
                    }
                }
            }
        }
        return res;
    }
    private boolean backtrack(char[][] board, int r, int c, String word, int i) {
        if (i == word.length()) return true;
        if (r < 0 || c < 0 || r >= board.length || c >= board[0].length || board[r][c] != word.charAt(i)) return false;
        board[r][c] = '*';
        boolean ret = backtrack(board, r + 1, c, word, i + 1) || backtrack(board, r - 1, c, word, i + 1) ||
                      backtrack(board, r, c + 1, word, i + 1) || backtrack(board, r, c - 1, word, i + 1);
        board[r][c] = word.charAt(i);
        return ret;
    }
}
