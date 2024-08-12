/**
 * Given the root of a binary tree and an integer targetSum, return true if the tree has a root-to-leaf path such that adding up all the values along the path equals targetSum.
 * A leaf is a node with no children.
 */
public class PathSum {
    public static void main(String[] args) {
        PathSum pathSum = new PathSum();

        TreeNode treeNode = new TreeNode(5, new TreeNode(4, new TreeNode(11, new TreeNode(7), new TreeNode(2)), null), new TreeNode(8, new TreeNode(13), new TreeNode(4, null, new TreeNode(1))));

        boolean hasPathSum = pathSum.hasPathSum(treeNode, 22);

        System.out.println(hasPathSum);
    }

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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        int currentSum = targetSum - root.val;

        if (root.left == null && root.right == null) {
            return currentSum == 0;
        }

        if (root.left == null) {
            return hasPathSum(root.right, currentSum);
        }

        if (root.right == null) {
            return hasPathSum(root.left, currentSum);
        }

        return (hasPathSum(root.left, currentSum) || hasPathSum(root.right, currentSum));
    }
}
