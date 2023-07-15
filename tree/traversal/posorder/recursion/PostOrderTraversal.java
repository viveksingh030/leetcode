package traversal.posorder.recursion;

import traversal.TreeFactory;
import traversal.TreeNode;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        postOrderTraversal(root);
    }

    private static void postOrderTraversal(TreeNode<Integer> root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.print(root.val+" ");
        }
    }
}
