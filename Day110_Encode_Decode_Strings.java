// Encode and Decode Strings:
// Design an algorithm to encode a list of strings to a string. The encoded string is then sent over the network and is decoded back to the original list of strings.
// Example 1:
// Input: dummy_input = ["Hello","World"]
// Output: ["Hello","World"]
// Explanation:
// Machine 1:
// Codec encoder = new Codec();
// String msg = encoder.encode(strs);
// Machine 1 ---msg---> Machine 2
// Machine 2:
// Codec decoder = new Codec();
// String[] strs = decoder.decode(msg);
// Example 2:
// Input: dummy_input = [""]
// Output: [""]
// Constraints:
// 0 <= strs.length < 100
// 0 <= strs[i].length < 200
// strs[i] contains any possible characters out of 256 valid ASCII characters.

class Day110_Encode_Decode_Strings {
    public String encode(List<String> strs) {
        StringBuilder temp = new StringBuilder();
        for(String word : strs){
            temp.append(word.length()).append("~").append(word);
        }
        return temp.toString();
    }
    public List<String> decode(String str) {
        List<String> processed = new ArrayList<>();
        int current = 0;
        while(current < str.length()){
            int upto = current;
            while(str.charAt(upto) != '~'){
                upto++;
            }
            int length = Integer.parseInt(str.substring(current, upto));
            current = upto + 1;
            upto = current + length;
            processed.add(str.substring(current,upto));
            current = upto;
        }
        return processed;
    }
}
