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

    public int diameterOfBinaryTree(TreeNode root) {
        // this is just dfs
        int[] res = new int[1]; // need this variable to work like a global
        dfs(root, res);
        return res[0];
    }

    // returns height
    public int dfs(TreeNode root, int[] res) {
        // base case
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left, res);
        int right = dfs(root.right, res);
        // store the max diameter seen so far
        res[0] = Math.max(res[0], left + right);
        // returns the greatest height, add 1 due to current depth
        return Math.max(left, right) + 1;
    }
}







