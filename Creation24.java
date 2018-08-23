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
public class Creation24 {
        Node root;
    
    public  void accept(){ 
        root = new Node(50);
        root.left = new Node(7);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.right.left = new Node(1);
        root.right.right = new Node(30);
  
        
        convertTree(root);
        
        printInorder(root);
  
    }
        
    public void convertTree(Node node){ 
    
        int left_data = 0, right_data = 0, diff;
  
        if (node == null
                || (node.left == null && node.right == null))
            return;
        else{
        
            convertTree(node.left);
            convertTree(node.right);
        
            if (node.left != null)
                left_data = node.left.key;
             
            if (node.right != null)
                right_data = node.right.key;
            diff = left_data + right_data - node.key;
  
            if (diff > 0)
                node.key = node.key + diff;
            if (diff < 0)
                increment(node, -diff);  
        }
    }
  
    public void increment(Node node, int diff) {
        if (node.left != null) 
        {
            node.left.key = node.left.key + diff;
            increment(node.left, diff);
        } 
        else if (node.right != null) 
        {
            node.right.key = node.right.key + diff;
            increment(node.right, diff);
        }
    }
  
    public void printInorder(Node node){ 
    
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
  
    
}
