/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryconstruction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Arrays;
/**
 *
 * @author shivam
 */
public class Creation35 {
   NodeStructure root,temp,newnode,temp1;

    public Creation35() {
    root=null;
    }
    Queue<Integer> q4=new LinkedList<>();
        
    public void insert(){
        Queue<Integer> q1=new LinkedList<>();
        Queue<Integer> q2=new LinkedList<>();
    
        int array[] = { 5, 6, 7, 8, 9, 10, 11 };  
        System.out.println("length of post-"+array.length);
        q1.add(array[0]);
        q2.add(array[1]);
        q2.add(array[2]);
        
        newnode=new NodeStructure();
        newnode.key=0;
        newnode.left=null;
        newnode.right=null;
    
        
        if(root==null){
            root=new NodeStructure();
            root.key=q1.element();
            root.left=null;
            root.right=null;
            temp=root;
            
            if(temp.left==null){
                
                newnode=new NodeStructure();
                newnode.key=q2.element();
                newnode.left=null;
                newnode.right=null;
                temp.left=newnode;
                q1.poll();
                q1.add(q2.poll());
                //temp=root;
            }
            if(temp.right==null){
              //  System.out.println("1");
                newnode=new NodeStructure();
                newnode.key=q2.element();
                newnode.left=null;
                newnode.right=null;
                temp.right=newnode;
              //  System.out.println("2");
                q1.add(q2.poll());
  
            }
        }
        
        int length=3,i,j=2;
        while(length<array.length){
        
            int q1size=q1.size();
            
            for(i=0;i<(q1size*2);i++){
                j=j+1;
                if(j<array.length)
                    q2.add(array[j]);
            }
           length=length+i; 
        }
        
        while(!q2.isEmpty()){

            search(q1.element());

            q1.poll();

            if(!q2.isEmpty()){

                newnode=new NodeStructure();
                newnode.key=q2.element();
                newnode.left=null;
                newnode.right=null;
                temp1.left=newnode;
                q1.add(q2.poll());
            }


           if(!q2.isEmpty()){

                newnode=new NodeStructure();
                newnode.key=q2.element();
                newnode.left=null;
                newnode.right=null;
                temp1.right=newnode;
                q1.add(q2.poll());
            }
        }
        inorder(root);
        arrange();
        
    }
    public void search(int data){
        
        Queue<NodeStructure> q3=new LinkedList<>();
        Queue<NodeStructure> q4=new LinkedList<>();
        Iterator itr3=q3.iterator();
        Iterator itr4=q4.iterator();  
        q3.add(root);
        
        while(itr3.hasNext()|| itr4.hasNext()){
            while(itr3.hasNext()){
                if(q3.element().left  != null)
                    q4.add(q3.element().left);

                if(q3.element().right != null)
                     q4.add(q3.element().right);
              
                if(data==q3.element().key){
        
                    temp1=q3.element();
                }
                q3.remove();
            }
            while (itr4.hasNext())
            {
                if (q4.element().left != null)
                    q3.add(q4.element().left);

                if (q4.element().right != null)
                    q3.add(q4.element().right);
                
                if(data==q4.element().key){
                    
                    temp1=q4.element();   
                }
                q4.remove();
            }
        }
            
    }
    
    public void inorder(NodeStructure node){
       if(node==null)
           return;
       
        inorder(node.left);
        System.out.print(node.key+" ");
        q4.add(node.key);
        inorder(node.right);
    }
    
    public void arrange(){
        int num=q4.size(),temp4,count=0;
        int array[]=new int[num];
        
        for(int i=0;i<num;i++){
            array[i]=q4.poll();
        }
        for(int i=0;i<num;i++){
            System.out.println("array-"+array[i]);
        }
         for (int i = 0; i < num; i++) 
        {
            for (int j = i + 1; j < num; j++) 
            {
                if (array[i] > array[j]) 
                {
                    temp4 = array[i];
                    array[i] = array[j];
                    array[j] = temp4;
                    count++;
                }
            }
        }
         System.out.println("after sorting");
        for(int i=0;i<num;i++){
            System.out.println("array-"+array[i]);
        }
         System.out.println("value of count-"+count);
    }
}
