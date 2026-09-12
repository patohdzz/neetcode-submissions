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

    List<List<Integer>> result;
    public List<List<Integer>> levelOrder(TreeNode root) {
        result = new ArrayList<>();
        helper(root, 0);
        return result;
    }

    public void helper(TreeNode node, int level) {
        if (node == null) return;

        if (level == result.size()) {
            // first iteration, level 0 and size() is 0, so lets add a new list for this level
            result.add(new ArrayList<>());
        }
        result.get(level).add(node.val);

        helper(node.left, level + 1);
        helper(node.right, level + 1);

    }
}
