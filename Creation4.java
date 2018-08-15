/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryconstruction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *
 * @author shivam
 */
public class Creation4 extends NodeStructure{
      NodeStructure root;

    Scanner scanner =new Scanner(System.in);
    Queue<Integer> q1=new LinkedList<>();
    Queue<Integer> q2=new LinkedList<>();
    Iterator itr=q1.iterator();
    Iterator itr2=q2.iterator();  
    //q1.add(root);
    int[] array=new int[10];
    int num,data;
    NodeStructure temp,newnode,temp1;
    public Creation4() {
    root=null;
    }
      
    
    
    public void insert(){
        
        System.out.print("enter the no of data-");
        num=scanner.nextInt();
        
        System.out.print("enter "+num+" data-");
        for(int j=0;j<num;j++){
            data=scanner.nextInt();
            array[j]=data;
        }    
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
        while(length<num){
        
            int q1size=q1.size();
            
            for(i=0;i<(q1size*2);i++){
                j=j+1;
                if(j<num)
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
        inorder(node.right);
    }
}
