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
class newNode
{
    int data;
    newNode left,middle,right;
    public newNode(int data)
    {
        this.data = data;
        left = middle = right = null;
    }
}
public class creation13 {
     
    newNode root,tail;
    public  void accept(){
        root = new newNode(30);
        root.left = new newNode(5);
        root.middle = new newNode(11);
        root.right = new newNode(63);
        root.left.left = new newNode(1);
        root.left.middle = new newNode(4);
        root.left.right = new newNode(8);
        root.middle.left = new newNode(6);
        root.middle.middle = new newNode(7);
        root.middle.right = new newNode(15);
        root.right.left = new newNode(31);
        root.right.middle = new newNode(55);
        root.right.right = new newNode(65);
         
        // The function which initiates the list 
        // process returns the head.
        newNode head = root;  
        tail=root;
        head=ternaryTree(root,head);
        printList(head);
        
    }
    newNode ternaryTree(newNode node,newNode head){
        if(node == null)
            return node;                     
        newNode left = node.left;
        newNode middle = node.middle;
        newNode right = node.right;
        if(tail != node)
         
            push(node);             
        ternaryTree(left,head);         
        ternaryTree(middle,head);
        ternaryTree(right,head);
        return node;
    }
     public void push(newNode node)
    {
        tail.right = node;                 
         
        node.left = tail;         
        node.middle = node.right = null; 
        tail = node;             
    }
    public  void printList(newNode head) 
    {
        while(head != null)
        {
            System.out.print(head.data + " ");
            head = head.right;
        }
    }
}
