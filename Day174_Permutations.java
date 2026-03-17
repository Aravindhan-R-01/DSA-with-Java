// Permutations:
// Given an array nums of unique integers, return all the possible permutations. You may return the answer in any order.
// Example 1:
// Input: nums = [1,2,3]
// Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// Example 2:
// Input: nums = [7]
// Output: [[7]]
// Constraints:
// 1 <= nums.length <= 6
// -10 <= nums[i] <= 10



class Solution {
    public List<List<Integer>> permute(int[] nums) {
        if (nums.length == 0) return Arrays.asList(new ArrayList<>());
        List<List<Integer>> perms = permute(Arrays.copyOfRange(nums, 1, nums.length));
        List<List<Integer>> res = new ArrayList<>();
        for (List<Integer> p : perms) {
            for (int i = 0; i <= p.size(); i++) {
                List<Integer> p_copy = new ArrayList<>(p);
                p_copy.add(i, nums[0]);
                res.add(p_copy);
            }
        }
        return res;
    }
}
