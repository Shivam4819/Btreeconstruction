/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryconstruction;

/**
 *
 * @author shivam
 */
public class Creation34 {
    Node root;
    public void accept(){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.right.left = new Node(4);
        root.right.right = new Node(5);

        root = flipBinaryTree(root);

        printInorder(root);
        
    }
    
    Node flipBinaryTree(Node node){
        if(node==null)
            return node;
        if(node.left==null&&node.right==null)
            return node;
        root = flipBinaryTree(node.left);
        
        node.left.left=node.right;
        node.left.right=node;
        node.left=node.right=null;
        return root;

    }
    
    public void printInorder(Node node){ 
    
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
}
