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
public class Creation33 {
    public  void accept(){
        String exp = "a?b?c:d:e";
        
        char[] expression=exp.toCharArray(); 
        Node root = convertExpression(expression, 0);
        printInorder(root) ;
    }
    
    Node convertExpression(char[] expression, int i){
        if (i >= expression.length)
            return null;
      
        Node root = new Node(expression[i]);
        ++i;
        if (i < expression.length && expression[i]=='?')
            root.left = convertExpression(expression, i+1);
        else if (i < expression.length)
            root.right = convertExpression(expression, i+1);
      
        return root;
    }
    public void printInorder(Node node){ 
    
        if (node == null)
            return;
        printInorder(node.left);
        System.out.print(node.key + " ");
        printInorder(node.right);
    }
}
