package traversal.inorder.recursion;

import traversal.TreeFactory;
import traversal.TreeNode;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNode<Integer> root) {
        if (root != null) {
            inorderTraversal(root.left);
            System.out.print(root.val+" ");
            inorderTraversal(root.right);
        }
    }
}
