// Combination Sum II:
// You are given an array of integers candidates, which may contain duplicates, and a target integer target.
// Your task is to return a list of all unique combinations of candidates where the chosen numbers sum to target.
// Each element from candidates may be chosen at most once within a combination. The solution set must not contain duplicate combinations.
// You may return the combinations in any order and the order of the numbers in each combination can be in any order.
// Example 1:
// Input: candidates = [9,2,2,4,6,1,5], target = 8
// Output: [
//   [1,2,5],
//   [2,2,4],
//   [2,6]
// ]
// Example 2:
// Input: candidates = [1,2,3,4,5], target = 7
// Output: [
//   [1,2,4],
//   [2,5],
//   [3,4]
// ]
// Constraints:
// 1 <= candidates.length <= 100
// 1 <= candidates[i] <= 50
// 1 <= target <= 30



class Solution {
    private Set<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new HashSet<>();
        Arrays.sort(candidates);
        generateSubsets(candidates, target, 0, new ArrayList<>(), 0);
        return new ArrayList<>(res);
    }
    private void generateSubsets(int[] candidates, int target, int i, List<Integer> cur, int total) {
        if (total == target) {
            res.add(new ArrayList<>(cur));
            return;
        }
        if (total > target || i == candidates.length) return;
        cur.add(candidates[i]);
        generateSubsets(candidates, target, i + 1, cur, total + candidates[i]);
        cur.remove(cur.size() - 1);
        generateSubsets(candidates, target, i + 1, cur, total);
    }
}
