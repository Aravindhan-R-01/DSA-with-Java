// Binary Tree Level Order Traversal:
// Given a binary tree root, return the level order traversal of it as a nested list, where each sublist contains the values of nodes at a particular level in the tree, from left to right.
// Example 1:
// Input: root = [1,2,3,4,5,6,7]
// Output: [[1],[2,3],[4,5,6,7]]
// Example 2:
// Input: root = [1]
// Output: [[1]]
// Example 3:
// Input: root = []
// Output: []
// Constraints:
// 0 <= The number of nodes in the tree <= 1000.
// -1000 <= Node.val <= 1000



/**Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode node, int depth) {
        if (node == null) return;
        if (res.size() == depth) res.add(new ArrayList<>());
        res.get(depth).add(node.val);
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}
