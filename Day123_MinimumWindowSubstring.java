// Minimum Window Substring:
// Given two strings s and t, return the shortest substring of s such that every character in t, including duplicates, is present in the substring. If such a substring does not exist, return an empty string "".
// You may assume that the correct output is always unique.
// Example 1:
// Input: s = "OUZODYXAZV", t = "XYZ"
// Output: "YXAZ"
// Explanation: "YXAZ" is the shortest substring that includes "X", "Y", and "Z" from string t.
// Example 2:
// Input: s = "xyz", t = "xyz"
// Output: "xyz"
// Example 3:
// Input: s = "x", t = "xy"
// Output: ""
// Constraints:
// 1 <= s.length <= 1000
// 1 <= t.length <= 1000
// s and t consist of uppercase and lowercase English letters.


class Day123_MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        if(t.isEmpty()) return "";
        Map<Character, Integer> mapT = new HashMap<>();
        for(char i : t.toCharArray()) {
            mapT.put(i, mapT.getOrDefault(i , 0) + 1);
        }
        int[] result = {-1, -1};
        int resultLength = Integer.MAX_VALUE;
        for(int x = 0; x < s.length(); x++){
            Map<Character, Integer> mapS = new HashMap<>();
            for(int y = x; y < s.length(); y++){
                mapS.put(s.charAt(y), mapS.getOrDefault(s.charAt(y), 0) + 1);
                boolean condition = true;
                for(char ch : mapT.keySet()){
                    if(mapS.getOrDefault(ch, 0) < mapT.get(ch)) {
                        condition = false; 
                        break;
                    }
                }
                if(condition && (y - x + 1) < resultLength){
                    resultLength = y - x + 1;
                    result[0] = x;
                    result[1] = y;
                }
            }
        }
        return resultLength == Integer.MAX_VALUE ? "" : s.substring(result[0], result[1] + 1);
    }
}
