Permutation in String:
You are given two strings s1 and s2.
Return true if s2 contains a permutation of s1, or false otherwise. That means if a permutation of s1 exists as a substring of s2, then return true.
Both strings only contain lowercase letters.
Example 1:
Input: s1 = "abc", s2 = "lecabee"
Output: true
Explanation: The substring "cab" is a permutation of "abc" and is present in "lecabee".
Example 2:
Input: s1 = "abc", s2 = "lecaabee"
Output: false
Constraints:
1 <= s1.length, s2.length <= 1000

class Day122_PermutationInString {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);
        for (int i = 0; i < s2.length(); i++) {
            for (int j = i; j < s2.length(); j++) {
                char[] subStrArr = s2.substring(i, j + 1).toCharArray();
                Arrays.sort(subStrArr);
                String sortedSubStr = new String(subStrArr);
                if (sortedSubStr.equals(sortedS1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
