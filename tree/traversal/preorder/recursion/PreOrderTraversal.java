package traversal.preorder.recursion;

import traversal.TreeFactory;
import traversal.TreeNode;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        preorderTraversal(root);
    }

    private static void preorderTraversal(TreeNode<Integer> root) {
        if (root != null) {
            System.out.print(root.val+" ");
            preorderTraversal(root.right);
            preorderTraversal(root.right);
        }
    }
}
