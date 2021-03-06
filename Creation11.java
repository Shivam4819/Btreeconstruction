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

public class Creation11 {
    
    public void accept(){
        int inorder[] = {4, 8, 2, 5, 1, 6, 3, 7};
        int postorder[] = {8, 4, 5, 2, 6, 7, 3, 1};
        int length=inorder.length;
        int postIndex=length-1;
        Node root=buildTree(inorder,postorder,0,length-1,postIndex);    
    
        inorderTraversal(root);
    }
    Node buildTree(int inorder[],int postorder[],int start,int end,int postindex){
        
        if(start>end)
            return null;
        
        Node temp=new Node(postorder[postindex]);
        
        if(start==end)
            return temp;
        
        int indexIninorder=search(inorder,start,end,temp.key);
        
        temp.left=buildTree(inorder, postorder, start, indexIninorder-1, postindex);
        temp.right=buildTree(inorder, postorder, indexIninorder+1, end, postindex);
        
        return temp;
    }    
    
    public int search(int inoder[],int start,int end,int data){
        int i;
        for(i=start;i<=end;i++){
            if(inoder[i]==data)
                break;
        }
        return i;
    }
    
     public void inorderTraversal(Node root){
        if(root==null)
            return;
        
        inorderTraversal(root.left);
        System.out.print(root.key+" ");
        inorderTraversal(root.right);
    }
}
