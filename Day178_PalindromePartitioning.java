// Palindrome Partitioning:
// Given a string s, split s into substrings where every substring is a palindrome. Return all possible lists of palindromic substrings.
// You may return the solution in any order.
// Example 1:
// Input: s = "aab"
// Output: [["a","a","b"],["aa","b"]]
// Example 2:
// Input: s = "a"
// Output: [["a"]]
// Constraints:
// 1 <= s.length <= 20
// s contains only lowercase English letters.



class Solution {
    private List<List<String>> res = new ArrayList<>();
    private List<String> part = new ArrayList<>();
    public List<List<String>> partition(String s) {
        dfs(0, 0, s);
        return res;
    }
    private void dfs(int j, int i, String s) {
        if (i >= s.length()) {
            if (i == j) {
                res.add(new ArrayList<>(part));
            }
            return;
        }
        if (isPali(s, j, i)) {
            part.add(s.substring(j, i + 1));
            dfs(i + 1, i + 1, s);
            part.remove(part.size() - 1);
        }
        dfs(j, i + 1, s);
    }
    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
