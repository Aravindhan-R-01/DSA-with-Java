// Combination Sum:
// You are given an array of distinct integers nums and a target integer target.
// Your task is to return a list of all unique combinations of nums where the chosen numbers sum to target.
// The same number may be chosen from nums an unlimited number of times. 
// Two combinations are the same if the frequency of each of the chosen numbers is the same, otherwise they are different.
// You may return the combinations in any order and the order of the numbers in each combination can be in any order.
// Example 1:
// Input:
// nums = [2,5,6,9]
// target = 9
// Output: [[2,2,5],[9]]
// Explanation:
// 2 + 2 + 5 = 9. We use 2 twice, and 5 once.
// 9 = 9. We use 9 once.
// Example 2:
// Input:
// nums = [3,4,5]
// target = 16
// Output: [[3,3,3,3,4],[3,3,5,5],[4,4,4,4],[3,4,4,5]]
// Example 3:
// Input:
// nums = [3]
// target = 5
// Output: []
// Constraints:
// All elements of nums are distinct.
// 1 <= nums.length <= 20
// 2 <= nums[i] <= 30
// 2 <= target <= 30



class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, new ArrayList<>(), 0, nums, target);
        return res;
    }
    private void dfs(int i, List<Integer> cur, int total, int[] nums, int target) {
        if (total == target) {
            res.add(new ArrayList<>(cur)); 
            return;
        }
        for (int j = i; j < nums.length; j++) {
            if (total + nums[j] > target) {
                return;
            }
            cur.add(nums[j]);
            dfs(j, cur, total + nums[j], nums, target);
            cur.remove(cur.size() - 1);
        }
    }
}
