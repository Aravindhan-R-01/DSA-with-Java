// Letter Combinations of a Phone Number:
// You are given a string digits made up of digits from 2 through 9 inclusive.
// Each digit (not including 1) is mapped to a set of characters as shown below:
// A digit could represent any one of the characters it maps to.
// Return all possible letter combinations that digits could represent. You may return the answer in any order.
// Example 1:
// Input: digits = "34"
// Output: ["dg","dh","di","eg","eh","ei","fg","fh","fi"]
// Example 2:
// Input: digits = ""
// Output: []
// Constraints:
// 0 <= digits.length <= 4
// 2 <= digits[i] <= 9




class Solution {
    private List<String> res = new ArrayList<>();
    private String[] digitToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };
    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        backtrack(0, "", digits);
        return res;
    }
    private void backtrack(int i, String curStr, String digits) {
        if (curStr.length() == digits.length()) {
            res.add(curStr);
            return;
        }
        String chars = digitToChar[digits.charAt(i) - '0'];
        for (char c : chars.toCharArray()) {
            backtrack(i + 1, curStr + c, digits);
        }
    }
}
