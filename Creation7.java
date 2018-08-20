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
public class Creation7 {
    
    int preindex=0;
    
    public void insert(){
        int pre[] = {10, 30, 20, 5, 15};
        char preLN[] = {'N', 'N', 'L', 'L', 'L'};
 
        int size = pre.length;
        Node root = constructTree(pre, preLN, size);
 
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
    
    
    Node constructTree(int pre[], char preLN[], int size) 
    {
        preindex = 0;
        return constructTreeUtil(pre, preLN, 0, size, size);
    }
    
    Node constructTreeUtil(int pre[], char preLN[], int postlow, int posthigh, int size) 
    {
        if (preindex >= size || postlow > posthigh)
            return null;
 
        Node root = new Node(pre[preindex]);
        preindex++;
         
        if (postlow == posthigh || preindex >= size)
            return root;
        int i=0;     
     
        
        if (i <= posthigh) 
        {
            root.left = constructTreeUtil(pre, preLN, postlow, i, size);
            root.right = constructTreeUtil(pre, preLN, i + 1, posthigh, size);
        }
        return root;
    }
 
 
    static void printInorder(Node root) 
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.key + " ");
        printInorder(root.right);
    }
}
