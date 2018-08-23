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

public class Creation12 {
    
    Node root;
    
    public void accept(){
        int parent[]={1,5,5,2,2,-1,3};
        int length =parent.length;
        
        Node node=binarryTree(parent,length);
    }
    
    Node binarryTree(int parent[],int length){
    
        Node[] created = new Node[length];
        for (int i = 0; i < length; i++) 
            created[i] = null;
  
        for (int i = 0; i < length; i++)
            createNode(parent, i, created);
  
        return root;
    }
      void createNode(int parent[], int i, Node created[]) 
    {
        if (created[i] != null)
            return;
  
        created[i] = new Node(i);
  
        if (parent[i] == -1) 
        {
            root = created[i];
            return;
        }
  
        if (created[parent[i]] == null)
            createNode(parent, parent[i], created);
  
        Node temp = created[parent[i]];
  
     
        if (temp.left == null)
            temp.left = created[i];
        else 
          temp.right = created[i];
    }
}
