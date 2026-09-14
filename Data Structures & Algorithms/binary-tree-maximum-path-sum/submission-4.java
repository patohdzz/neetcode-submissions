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

    private int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }

    public int dfs(TreeNode node) {
        if (node == null) return 0;

        int leftSide = Math.max(dfs(node.left), 0);
        int rightSide = Math.max(dfs(node.right), 0);

        maxSum = Math.max(maxSum, node.val + leftSide + rightSide);

        return node.val + Math.max(leftSide, rightSide);
    }
}




