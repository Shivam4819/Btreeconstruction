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
public class Creation5 {
   
    class node 
    {
        int data;
        node left, right;
 
        public node(int data) 
        {
            this.data = data;
        }
    }
    int preindex=0;
    
    public void insert(){
        int pre[] = { 1, 2, 4, 8, 9, 5, 3, 6, 7 };
        int post[] = { 8, 9, 4, 5, 2, 6, 7, 3, 1 };
 
        int size = pre.length;
        node root = constructTree(pre, post, size);
 
        System.out.println("Inorder traversal of the constructed tree:");
        printInorder(root);
    }
    
    
    node constructTree(int pre[], int post[], int size) 
    {
        preindex = 0;
        return constructTreeUtil(pre, post, 0, size - 1, size);
    }
    
    node constructTreeUtil(int pre[], int post[], int postlow, int posthigh, int size) 
    {
        if (preindex >= size || postlow > posthigh)
            return null;
 
        node root = new node(pre[preindex]);
        preindex++;
         
        if (postlow == posthigh || preindex >= size)
            return root;
        int i;
     
        for (i = postlow; i <= posthigh; i++) 
        {
            if (post[i] == pre[preindex])
                break;
        }
        
        if (i <= posthigh) 
        {
            root.left = constructTreeUtil(pre, post, postlow, i, size);
            root.right = constructTreeUtil(pre, post, i + 1, posthigh, size);
        }
        return root;
    }
 
 
    static void printInorder(node root) 
    {
        if (root == null)
            return;
        printInorder(root.left);
        System.out.print(root.data + " ");
        printInorder(root.right);
    }
}
