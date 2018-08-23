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
public class Creation26 {
    
    Node root;
    public  void accept(){ 
    
        root = new Node(10);
        root.left = new Node(-2);
        root.right = new Node(6);
        root.left.left = new Node(8);
        root.left.right = new Node(-4);
        root.right.left = new Node(7);
        root.right.right = new Node(5);
  
        convertTreeToSum(root);
  
        printInorder(root);
    }
    int convertTreeToSum(Node node){
        if(node==null)
            return 0;
        int old = node.key;
        node.key=convertTreeToSum(node.left)+convertTreeToSum(node.right);
        return node.key+old;
    }
    
    public void printInorder(Node node){ 
    
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
}
