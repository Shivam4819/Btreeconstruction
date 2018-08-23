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
public class Creation32 {
    Node root;
    
    public void accept(){
        root=new Node(0);
        root.left=new Node(1);
        root.right=new Node(0);
        root.left.left=new Node(0);
        root.left.right=new Node(1);
        root.right.left=new Node(1);
        root.right.right=new Node(1);
        
        convertToLogicalAND(root);

        printInorder(root);
    }
    public void convertToLogicalAND(Node node){
        if(node == null)
            return;
        convertToLogicalAND(node.left);
        convertToLogicalAND(node.right);
        if(node.left!=null && node.right!=null)
            node.key= (node.left.key) & (node.right.key);
    }
    public void printInorder(Node node){ 
    
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
}
