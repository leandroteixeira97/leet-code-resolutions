/**
 * Given the root of a binary tree, return its maximum depth.
 * A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.
 */
public class MaximumDepthOfBinaryTree {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));

        System.out.println(maxDepth(treeNode));
    }

    public static int maxDepth(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        return getDepth(root, 1);
    }

    public static int getDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) {
            return depth;
        }

        if (root.left == null) {
            return getDepth(root.right, depth + 1);
        }

        if (root.right == null) {
            return getDepth(root.left, depth + 1);
        }

        int leftDepth = getDepth(root.left, depth + 1);
        int rightDepth = getDepth(root.right, depth + 1);

        if (leftDepth > rightDepth) {
            return leftDepth;
        }

        return rightDepth;
    }
}
