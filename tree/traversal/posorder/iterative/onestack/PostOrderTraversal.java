package traversal.posorder.iterative.onestack;

import traversal.TreeFactory;
import traversal.TreeNode;

import java.util.Stack;

public class PostOrderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        postorderTraversal(root);
    }

    public static void postorderTraversal(TreeNode<Integer> root) {
        Stack<TreeNode> stack=new Stack<>();
        while(root!=null||stack.isEmpty()==false){
            if(root!=null){
                stack.push(root);
                root=root.left;
            }
            if(root==null){
                TreeNode node=stack.peek();
                if(node.right==null){
                    System.out.print(node.val + " ");
                    node=stack.pop();
                    while(stack.isEmpty()==false && stack.peek().right==node){
                        node=stack.pop();
                        System.out.print(node.val + " ");
                    }
                }else{
                    root=node.right;
                }
            }
        }
    }
}
