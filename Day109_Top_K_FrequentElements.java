// Top K Frequent Elements:
// Given an integer array nums and an integer k, return the k most frequent elements within the array.
// The test cases are generated such that the answer is always unique.
// You may return the output in any order.
// Example 1:
// Input: nums = [1,2,2,3,3,3], k = 2
// Output: [2,3]
// Example 2:
// Input: nums = [7,7], k = 1
// Output: [7]

class Day109_Top_K_FrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        List<int[]> li = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            li.add(new int[]{entry.getValue(), entry.getKey()});
        }
        li.sort((a,b) -> Integer.compare(b[0],a[0]));
        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = li.get(i)[1];
        }
        return result;
    }
}
