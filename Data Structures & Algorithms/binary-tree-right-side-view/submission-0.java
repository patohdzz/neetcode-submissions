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

    List<Integer> result;
    public List<Integer> rightSideView(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode node, int level) {
        if (node == null) return;
        // "If this is the first node I've ever reached at this particular depth, record it. 
        // Otherwise, ignore it."
        if (level == result.size()) {
            result.add(node.val);
        }
        helper(node.right, level + 1);
        helper(node.left, level + 1);

    }
}







