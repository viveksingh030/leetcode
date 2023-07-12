package traversal.preorder.moris;

import traversal.TreeFactory;
import traversal.TreeNode;

public class PreorderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        preorderTraversal(root);
    }

    private static void preorderTraversal(TreeNode<Integer> root) {
        TreeNode<Integer> current = root;
        while (current != null) {
            if (current.left == null) {
                System.out.print(current.val + " ");
                current = current.right;
            } else {
                TreeNode<Integer> pred = current.left;
                while (pred.right != null && pred.right != current) {
                    pred = pred.right;
                }
                if (pred.right == null) {
                    pred.right = current;
                    System.out.print(current.val + " ");
                    current = current.left;
                } else {
                    pred.right = null;
                    current = current.right;
                }
            }
        }
    }

}
