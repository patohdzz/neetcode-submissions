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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        // we did not find it in this path
        if (root == null) {
            return false;
        }
        // check if current path is equal
        if (sametree(root, subRoot)) {
            return true;
        }
        // check children paths
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    public boolean sametree(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 != null && root2 != null && root1.val == root2.val) {
            return sametree(root1.left, root2.left) && sametree(root1.right, root2.right);
        } else {
            return false;
        }
    }
}
