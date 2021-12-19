package Recusion2;


public class ValidateBinaryTree {

    public static void main(String[] args) {
        ValidateBinaryTree validateBinaryTree = new ValidateBinaryTree();
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return true;
        } else if (root.left == null) {
            return isValidBST(root.right);
        } else if (root.right == null) {
            return isValidBST(root.left);
        } else if (root.left != null && root.right != null) {
            boolean wishLeft = isValidBST(root.left);
            boolean wishRight = isValidBST(root.right);
            boolean current = root.val > root.left.val && root.val < root.right.val;
            return current && wishLeft && wishRight;
        } else {
            System.out.println(root.left);
            System.out.println(root.right);
            return true;
        }
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
