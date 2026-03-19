// Generate Parentheses:
// You are given an integer n. Return all well-formed parentheses strings that you can generate with n pairs of parentheses.
// Example 1:
// Input: n = 1
// Output: ["()"]
// Example 2:
// Input: n = 3
// Output: ["((()))","(()())","(())()","()(())","()()()"]
// You may return the answer in any order.
// Constraints:
// 1 <= n <= 7



class Solution {
    public List<String> generateParenthesis(int n) {
        List<List<String>> result = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            result.add(new ArrayList<>());
        }
        result.get(0).add("");
        for (int k = 0; k <= n; k++) {
            for (int i = 0; i < k; i++) {
                for (String left : result.get(i)) {
                    for (String right : result.get(k - i - 1)) {
                        result.get(k).add("(" + left + ")" + right);
                    }
                }
            }
        }
        return result.get(n);
    }
}
