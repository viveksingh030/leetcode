package traversal;

public class TreeFactory {

    public static TreeNode<Integer> buildTreeIntegerNode() {
        TreeNode<Integer> treeNode = new TreeNode<>(5);
        treeNode.left = new TreeNode<>(6);
        treeNode.right = new TreeNode<>(7);
        treeNode.left.left = new TreeNode<>(8);
        treeNode.left.right = new TreeNode<>(9);
        treeNode.right.left = new TreeNode<>(10);
        treeNode.right.right = new TreeNode<>(11);
        return treeNode;
    }
}
