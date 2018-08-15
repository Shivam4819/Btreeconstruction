/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryconstruction;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author shivam
 */
class Node1{
     protected char key;
    protected Node1 left,right;
    
}
public class Creation1 extends Node1{
     Node1 root,newnode,temp;

    public Creation1() {
    root=null;
    }
    
    
    public void accept(){
        char in[]={'D','B','E','A','F','C'};
        char pre[] = {'A', 'B', 'D', 'E', 'C', 'F'};
        int rootIndex=0,index1=0,index2=0;
        boolean flag=true;
        root=new Node1();
        root.key=pre[0];
        root.left=null;
        root.right=null;
        
        for (int i = 0; i < 6; i++) {
            if(pre[0]==in[i]){
               rootIndex=i;
            }
        }
        System.out.println("k->"+rootIndex);
        System.out.println("root.key"+root.key);
        
        for (int i = 1; i < 5; i++) {
            char data=pre[i];
            for (int j = 0; j < 6; j++) {
                if(data==in[j]){
                    index1=j;
                }
            }
            while(flag==true){
                if(index1<rootIndex && root.left==null){
                    temp=root;
                    newnode=new Node1();
                    newnode.key=data;
                    newnode.left=null;
                    newnode.right=null;
                    temp.left=newnode;
                    flag=false;
                }
                else{
                    temp=temp.left;
                    char tempData=temp.key;
                    for (int k = 0; k < 6; k++) {
                          if(tempData==in[k]){
                            index2=k;
                        }
                    }
                    if(index2<index1 && temp.left==null){
                        temp=root;
                        newnode=new Node1();
                        newnode.key=data;
                        newnode.left=null;
                        newnode.right=null;
                        temp.left=newnode;
                        flag=false;
                    }

                    if(index2>index1 && temp.right==null){
                        temp=root;
                        newnode=new Node1();
                        newnode.key=data;
                        newnode.left=null;
                        newnode.right=null;
                        temp.right=newnode;
                        flag=false;
                    }
                }
            }
            flag=true;
            
            while(flag==true){
                if(index1>rootIndex && root.right==null){
                    temp=root;
                    newnode=new Node1();
                    newnode.key=data;
                    newnode.left=null;
                    newnode.right=null;
                    temp.right=newnode;
                    flag=false;
                }
                else{
                    temp=temp.right;
                    char tempData1=temp.key;
                    
                    for (int k = 0; k < 6; k++) {
                          if(tempData1==in[k]){
                            index2=k;
                        }
                    }
                    if(index2<index1 && temp.left==null){
                        temp=root;
                        newnode=new Node1();
                        newnode.key=data;
                        newnode.left=null;
                        newnode.right=null;
                        temp.left=newnode;
                        flag=false;
                    }

                    if(index2>index1 && temp.right==null){
                        temp=root;
                        newnode=new Node1();
                        newnode.key=data;
                        newnode.left=null;
                        newnode.right=null;
                        temp.right=newnode;
                        flag=false;
                    }
                }
            }
            flag=true;
        
        }
        levelOrder(root);
    }
    
    public void levelOrder(Node1 root){
        
        Queue<Node1> q1=new LinkedList<>();
        Queue<Node1> q2=new LinkedList<>();
        Iterator itr=q1.iterator();
        Iterator itr2=q2.iterator();  
        q1.add(root);
        
        while(itr.hasNext()|| itr2.hasNext()){
            while(itr.hasNext()){
                if(q1.element().left  != null)
                    q2.add(q1.element().left);

                if(q1.element().right != null)
                     q2.add(q1.element().right);
              
                System.out.print(q1.element().key+" ");
                q1.remove();
            }
            while (itr2.hasNext())
            {
                if (q2.element().left != null)
                    q1.add(q2.element().left);

                if (q2.element().right != null)
                    q1.add(q2.element().right);
                
                System.out.print(q2.element().key+" ");
                q2.remove();
            }
        }
        
    }
    
}
