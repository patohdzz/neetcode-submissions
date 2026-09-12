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

    Map<Integer, Integer> map = new HashMap<>();
    int preIndex = 0; // next unused value in preorder

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // use the first index in preorder to get the root node
        // using that node look for the root in the inorder list
        // the nodes left of that node are in the left side of the array
        // and nodes to the right are on the right side
        
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return dfs(0, inorder.length - 1, preorder);
    }

    public TreeNode dfs(int left, int right, int[] preorder) {
        if (left > right) {
            return null;
        }
        int rootVal = preorder[preIndex];
        preIndex++;
        TreeNode root = new TreeNode(rootVal);
        int mid = map.get(rootVal);
        root.left = dfs(left, mid - 1, preorder);
        root.right = dfs(mid + 1, right, preorder);
        return root;
    }
}
