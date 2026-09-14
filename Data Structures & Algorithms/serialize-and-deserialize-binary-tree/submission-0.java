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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) return "[]";
        StringBuilder sb = new StringBuilder();
        dfsString(root, sb);
        return sb.toString();
    }

    public void dfsString(TreeNode node, StringBuilder sb) {
        if (node == null) { // even if null we still return a preassigned number that we will use to distinguish NULL
            sb.append("#,");
            return;
        }
        sb.append(node.val + ",");
        dfsString(node.left, sb);
        dfsString(node.right, sb);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == "[]") return null;
        // breaks apart by commas, will contains numbers and # representing null nodes
        String[] values = data.split(",");
        // every call this one, its siblings, its parent, sees that same updated value the next time they read index[0]
        int[] index = {0};
        return dfsNode(values, index);
    }

    public TreeNode dfsNode(String[] values, int[] index) {
        String val = values[index[0]];
        index[0]++;
        if (val.equals("#")) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));
        // dont need to update index since the second recursive function will see a diff value than the first
        node.left = dfsNode(values, index);
        node.right = dfsNode(values, index);
        return node;
    }
}




