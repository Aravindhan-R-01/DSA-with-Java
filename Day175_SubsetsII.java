// Subsets II:
// You are given an array nums of integers, which may contain duplicates. Return all possible subsets.
// The solution must not contain duplicate subsets. You may return the solution in any order.
// Example 1:
// Input: nums = [1,2,1]
// Output: [[],[1],[1,2],[1,1],[1,2,1],[2]]
// Example 2:
// Input: nums = [7,7]
// Output: [[],[7], [7,7]]
// Constraints:
// 1 <= nums.length <= 11
// -20 <= nums[i] <= 20



class Solution {
    Set<List<Integer>> res = new HashSet<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0, new ArrayList<>());
        return new ArrayList<>(res);
    }
    private void backtrack(int[] nums, int i, List<Integer> subset) {
        if (i == nums.length) {
            res.add(new ArrayList<>(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(nums, i + 1, subset);
        subset.remove(subset.size() - 1);
        backtrack(nums, i + 1, subset);
    }
}
