// Longest Repeating Character Replacement:
// You are given a string s consisting of only uppercase english characters and an integer k. You can choose up to k characters of the string and replace them with any other uppercase English character.
// After performing at most k replacements, return the length of the longest substring which contains only one distinct character.
// Example 1:
// Input: s = "XYYX", k = 2
// Output: 4
// Explanation: Either replace the 'X's with 'Y's, or replace the 'Y's with 'X's.
// Example 2:
// Input: s = "AAABABB", k = 1
// Output: 5
// Constraints:
// 1 <= s.length <= 1000
// 0 <= k <= s.length


class Day121_LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new LinkedHashMap<>();
        int result = 0;
        int l = 0, maxf = 0;
        for (int x = 0; x < s.length(); x++) {
            map.put(s.charAt(x), map.getOrDefault(s.charAt(x), 0) + 1);
            maxf = Math.max(maxf, map.get(s.charAt(x)));
            while ((x - l + 1) - maxf > k) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l++;
            }
            result = Math.max(result, x - l + 1);
        }
        return result;
    }
}
