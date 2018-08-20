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
public class Creation10 {
    
    Node root=null;
    public void accept(){
        
        int inorder[]={5,10,40,30,20};
        int len=inorder.length;
        Node mainroot=Binarytree(inorder,0,len-1,root);
        
        inorderTraversal(mainroot);
    }
    
    public void inorderTraversal(Node mainroot){
        if(mainroot==null)
            return;
        
        inorderTraversal(mainroot.left);
        System.out.print(mainroot.key+" ");
        inorderTraversal(mainroot.right);
    }
    Node Binarytree(int inorder[],int start,int end,Node node){
        
        if(start<end)
            return null;
        
        int i=max(inorder,start,end);
        
        node=new Node(inorder[i]);
        
        if(start==end)
            return node;
        
        node.left=Binarytree(inorder, start, i-1, node.left);
        node.right=Binarytree(inorder, i+1, end, node.right);
        
        return node;
    }
    
    public int max(int inorder[],int start,int end){
        int i, max = inorder[start], maxindex = start;
        for (i = start ; i < end; i++) 
        {
            if (inorder[i] > max) 
            {
                max = inorder[i];
                maxindex = i;
            }
        }
        return maxindex;
    }
    
    
    
}
