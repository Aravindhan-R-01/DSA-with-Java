// Balanced Binary Tree:
// Given a binary tree, return true if it is height-balanced and false otherwise.
// A height-balanced binary tree is defined as a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
// Example 1:
// Input: root = [1,2,3,null,null,4]
// Output: true
// Example 2:
// Input: root = [1,2,3,null,null,4,null,5]
// Output: false
// Example 3:
// Input: root = []
// Output: true
// Constraints:
// The number of nodes in the tree is in the range [0, 1000].
// -1000 <= Node.val <= 1000


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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left = height(root.left);
        int right = height(root.right);
        return Math.abs(left-right)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode node){
        if(node == null) return 0;
        return 1+Math.max(height(node.left),height(node.right));
    }
}
