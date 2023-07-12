package traversal.inorder.iterative;

import traversal.TreeFactory;
import traversal.TreeNode;

import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNode<Integer> root) {
        Stack<TreeNode<Integer>> stack=new Stack<>();
        while (!stack.isEmpty()||root!=null){
            while (root!=null){
                stack.push(root);
                root=root.left;
            }
            TreeNode<Integer> node = stack.pop();
            System.out.print(root.val+" ");
            if(node.right!=null){
                root=node.right;
            }
        }
    }
}
