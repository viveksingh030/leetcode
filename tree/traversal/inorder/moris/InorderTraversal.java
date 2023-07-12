package traversal.inorder.moris;

import traversal.TreeFactory;
import traversal.TreeNode;

import java.util.Stack;

public class InorderTraversal {
    public static void main(String[] args) {
        TreeNode<Integer> root = TreeFactory.buildTreeIntegerNode();
        inorderTraversal(root);
    }

    private static void inorderTraversal(TreeNode<Integer> root) {
       TreeNode<Integer> current=root;
       while (current!=null){
           if(current.left==null){
               System.out.print(current.val+" ");
               current=current.right;
           }
           else{
               TreeNode<Integer> prev=current.left;
               while (prev.right!=null && prev.right!=current) {
                   prev = prev.right;
               }
               if(prev.right==null){
                   prev.right=current;
                   current=current.left;
               }else{
                   prev.right = null;
                   System.out.print(current.val + " ");
                   current = current.right;
               }
           }
       }
    }
}
