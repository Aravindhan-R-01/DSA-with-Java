Longest Substring Without Repeating Characters:
Given a string s, find the length of the longest substring without duplicate characters.
A substring is a contiguous sequence of characters within a string.
Example 1:
Input: s = "zxyzxyz"
Output: 3
Explanation: The string "xyz" is the longest without duplicate characters.
Example 2:
Input: s = "xxxx"
Output: 1
Constraints:
0 <= s.length <= 1000
s may consist of printable ASCII characters.


class Day120_LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int duplicate = 0;
        int result = 0;
        for(int current = 0; current < s.length(); current++){
            while(set.contains(s.charAt(current))){
                set.remove(s.charAt(duplicate));
                duplicate++;
            }
            set.add(s.charAt(current));
            result = Math.max(result, (current - duplicate + 1));
        }
        return result;
    }
}
