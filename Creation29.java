/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryconstruction;
import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;
/**
 *
 * @author shivam
 */
public class Creation29 {
    Node root;
    Node tempNode,newnode;

    public  void create(){
       
        root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);
 
        root.left.left.left = new Node(8);
        root.left.left.right = new Node(9);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(11);
        
        root.right.left.right = new Node(13);
        root.right.right.left = new Node(14);
        
        spiralLevelOrder(root);
    }
    
    void spiralLevelOrder(Node node) {
        Stack<Node> s1 = new Stack<>();
        Queue<Node> q= new LinkedList<>();
        Stack<Node> s2 = new Stack<>();
        s1.push(node);
        System.out.print("\n");
        while(!s1.isEmpty()||!s2.isEmpty()){
            while(!s1.isEmpty()){
                tempNode = s1.pop();
                if(tempNode.right!=null)
                    s2.push(tempNode.right);
                if(tempNode.left!=null)
                    s2.push(tempNode.left);
                q.add(tempNode);
            }
            while(!s2.isEmpty()){
                tempNode = s2.pop();
                if(tempNode.left!=null)
                    s1.push(tempNode.left);
                if(tempNode.right!=null)
                    s1.push(tempNode.right);
                q.add(tempNode);
            }
        }
        
        root=q.poll();
        root.left=null;
        root.right=null;
        while(!q.isEmpty()){
            newnode = q.poll();
            if(root.right==null){
                root.right=newnode;
                newnode.left=root;
                newnode.right=null;
            }
            else{
                tempNode = root;
                while(tempNode.right!=null)
                    tempNode=tempNode.right;
                tempNode.right=newnode;
                newnode.left=tempNode;
                newnode.right=null;
            }
        }
        System.out.print("\nConverting the tree to DLL without creating new space");
        tempNode=root;
        while(tempNode!=null){
            System.out.print(tempNode.key+" ");
            tempNode=tempNode.right;
        }
    }
}
