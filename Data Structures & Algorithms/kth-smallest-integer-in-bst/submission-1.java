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
    
    int kth = 0;

    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;

        while (!stack.isEmpty() || cur != null) {
            // go as deep left as you can
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            // now the value on top is the node at the far left
            cur = stack.pop();
            k--;
            if (k == 0) {
                return cur.val;
            }
            cur = cur.right;
        }
        return -1;
    }
}
