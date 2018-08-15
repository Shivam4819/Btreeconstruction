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

public class Creation3 extends NodeStructure{
     NodeStructure root,newnode1,temp,temp1;
    
    public void insert(){
        int in[]    = {4, 8, 10, 12, 14, 20, 22};
        int level[] = {20, 8, 22, 4, 12, 10, 14};
        int main,address1=0,flag=0,address2=0,address3=0;
        
        for(int j=0;j<7;j++){
            main=level[j];
            while(flag==0){
                for(int i=0;i<7;i++){
                    if(main==in[i]){
                        address1=i;
                        root=new NodeStructure();
                        root.left=null;
                        root.key=main;
                        root.right=null;
                    }
                }
                flag=1;
            }
            for(int i=0;i<7;i++){
                if(main==in[i]){
                    address2=i;
                    temp=root;
                    if(address2<address1){
                        if(root.left==null)
                        {
                            newnode1=new NodeStructure();
                            newnode1.left=null;
                            newnode1.key=main;
                            newnode1.right=null;
                            temp.left=newnode1;
                        }
                        
                        else{
                            temp=temp.left;
                            for(int k=0;k<7;i++){
                                if(temp.key==in[k]){
                                    address3=k;
                                    
                                    if(address2<address3){
                                        if(root.left==null)
                                        {
                                            newnode1=new NodeStructure();
                                            newnode1.left=null;
                                            newnode1.key=main;
                                            newnode1.right=null;
                                            temp.left=newnode1;
                                        }
                                    }
                                    if(address2>address3){
                                        if(root.right==null)
                                        {
                                            newnode1=new NodeStructure();
                                            newnode1.left=null;
                                            newnode1.key=main;
                                            newnode1.right=null;
                                            temp.right=newnode1;
                                        }
                                    }
                                }
                            }
                        
                        }
                    }
                    if(address2>address1){
                        if(root.right==null)
                        {
                            newnode1=new NodeStructure();
                            newnode1.left=null;
                            newnode1.key=main;
                            newnode1.right=null;
                            temp.right=newnode1;
                        }
                        else{
                            temp=temp.right;
                            for(int k=0;k<7;i++){
                                if(temp.key==in[k]){
                                    address3=k;
                                    
                                    if(address2<address3){
                                        if(root.left==null)
                                        {
                                            newnode1=new NodeStructure();
                                            newnode1.left=null;
                                            newnode1.key=main;
                                            newnode1.right=null;
                                            temp.left=newnode1;
                                        }
                                    }
                                    if(address2>address3){
                                        if(root.right==null)
                                        {
                                            newnode1=new NodeStructure();
                                            newnode1.left=null;
                                            newnode1.key=main;
                                            newnode1.right=null;
                                            temp.right=newnode1;
                                        }
                                    }
                                }
                            }
                        
                        }
                    }
                }
           
            }
        
        }
      levelOrder(root);
    }
       

    public void levelOrder(NodeStructure root){
        
        Queue<NodeStructure> q1=new LinkedList<>();
        Queue<NodeStructure> q2=new LinkedList<>();
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
     
     
     
     
     
     
     
     
     
     
     
     
     
