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
public class Creation27 {
    Node root;
    public void accept(){
        root  = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left  = new Node(4);
        root.left.right  = new Node(5);
        root.right.right = new Node(6);

        updateTree(root);

        printInorder(root);
    }
    
    int updateTree(Node node){
        if(node==null)
            return 0;
        if(node.left==null && node.right==null)
            return node.key;
        int leftsum=updateTree(node.left);
        int rightsum=updateTree(node.right);
        node.key=node.key+leftsum;
        return node.key+rightsum;
    }    
    public void printInorder(Node node){ 
    
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
}
