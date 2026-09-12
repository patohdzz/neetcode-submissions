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

    int good = 0; // the root is always a good node

    public int goodNodes(TreeNode root) {
        helper(root, root.val);
        return good;
    }

    public void helper(TreeNode node, int max) {
        if (node == null) return;
        if (node.val >= max) {
            good++;
            max = node.val;
        }
        helper(node.left, max);
        helper(node.right, max);
    }
}
