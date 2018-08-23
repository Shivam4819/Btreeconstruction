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
public class Creation20 {
     Node root;
     
  
    public  void accept(){
        
  
        root = new Node(10);
        root.left = new Node(12);
        root.right = new Node(15);
        root.left.left = new Node(25);
        root.left.right = new Node(30);
        root.right.left = new Node(36);
  
        Node head = bintree2list(root);
        printlinkList(head);
    }
    
    Node bintree2listUtil(Node node){
        if (node == null)
            return node;
  
        if (node.left != null) {
            
            Node left = bintree2listUtil(node.left);
  
            for (; left.right != null; left = left.right);
 
            left.right = node;
  
            node.left = left;
        }
  
        if (node.right != null) {
            
            Node right = bintree2listUtil(node.right);
  
            for (; right.left != null; right = right.left);
  
            right.left = node;
  
            node.right = right;
        }
  
        return node;
    }
  
      
    Node bintree2list(Node node) {
        
        if (node == null)
            return node;
  
        node = bintree2listUtil(node);
  
        while (node.left != null)
            node = node.left;
  
        return node;
    }
    void printlinkList(Node node) {
        
        while (node != null) {
            
            System.out.print(node.key + " ");
            node = node.right;
        }
    }

}
