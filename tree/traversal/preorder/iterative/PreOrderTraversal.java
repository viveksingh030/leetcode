package traversal.preorder.iterative;

import traversal.TreeFactory;
import traversal.TreeNode;

import java.util.Stack;

public class PreOrderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        preorderTraversal(root);
    }

    private static void preorderTraversal(TreeNode<Integer> root) {
        Stack<TreeNode> stack=new Stack<>();
        while (!stack.isEmpty() ||root!=null){
            System.out.print(root.val+" ");
            if(root.right!=null){
                stack.push(root.right);
            }
            root=root.left;
            if(root==null){
                if (stack.isEmpty()){
                    break;
                }
                root=stack.pop();
            }
        }
    }
}
