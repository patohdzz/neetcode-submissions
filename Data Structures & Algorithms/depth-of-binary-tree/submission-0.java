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
    public int maxDepth(TreeNode root) {
        // base case
        if (root == null) {
            return 0;
        }
        // if were here that means this was a valid depth, so add 1 to return
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
}
