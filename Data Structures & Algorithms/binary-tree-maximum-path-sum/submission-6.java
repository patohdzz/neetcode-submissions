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
        // we basically want to return the sum of a parent node and its children
        maxSum = root.val;
        dfs(root);
        return maxSum;
    }
    
    public int dfs(TreeNode node) {
        if (node == null) return 0;
        // If a subtree's best contribution is negative, it would only hurt to include it.
        int leftSide = Math.max(dfs(node.left), 0);
        int rightSide = Math.max(dfs(node.right), 0);

        maxSum = Math.max(maxSum, node.val + leftSide + rightSide);
        // A path, once it bends, is done bending — it can never bend a second time
        // pass to your parent only one path since we cant send both
        return node.val + Math.max(leftSide, rightSide);
    }
}




