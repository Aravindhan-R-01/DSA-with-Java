// Count Good Nodes in Binary Tree:
// Within a binary tree, a node x is considered good if the path from the root of the tree to the node x contains no nodes with a value greater than the value of node x
// Given the root of a binary tree root, return the number of good nodes within the tree.
// Example 1:
// Input: root = [2,1,1,3,null,1,5]
// Output: 3
// Example 2:
// Input: root = [1,2,-1,3,4]
// Output: 4
// Constraints:
// 1 <= number of nodes in the tree <= 100
// -100 <= Node.val <= 100



/**
 * Definition for a binary tree node.
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
     public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }
    private int dfs(TreeNode node, int maxVal) {
        if (node == null) return 0;
        int res = (node.val >= maxVal) ? 1 : 0;
        maxVal = Math.max(maxVal, node.val);
        res += dfs(node.left, maxVal);
        res += dfs(node.right, maxVal);
        return res;
    }
}
