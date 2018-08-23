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
public class Creation28 {
     
    Node root;
    public  void accept(){
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        mirrorTree(root);
 
        printInorder(root);
 
    }
    Node mirrorTree(Node node){
        if(node==null)
            return node;
        Node left=mirrorTree(node.left);
        Node right=mirrorTree(node.right);
        
        node.left=right;
        node.right=left;
        
        return node;
    }
    public void printInorder(Node node){ 
    
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
}
