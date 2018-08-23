/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package binaryconstruction;
import java.util.Stack;
/**
 *
 * @author shivam
 */
public class Creation18 {
    
    Node root,newNode;
    public void accept(){
        String str = "4(2(3)(1))(6(5))";
        char[] exp=str.toCharArray(); 

        Node root = treeFromString(exp, 0, str.length() - 1);
        preOrder(root);
    }
    
    Node treeFromString(char[] str, int si, int ei){
    if (si > ei)
        return null;
 
    Node root = new Node(str[si] - '0');
    int index = -1;
 
    if (si + 1 <= ei && str[si + 1] == '(')
        index = findIndex(str, si + 1, ei);
 
    if (index != -1) {
 
        root.left = treeFromString(str, si + 2, index - 1);
 
        root.right = treeFromString(str, index + 2, ei - 1);
    }
    return root;
    }
    
    int findIndex(char[] str, int si, int ei){
    if (si > ei)
        return -1;
 
    Stack stack=new Stack();
 
    for (int i = si; i <= ei; i++) {
 
        if (str[i] == '(')
            stack.push(str[i]);
 
        else if (str[i] == ')') {
            char top=stack.peek();
            if (top == '(') {
                stack.pop();
 
                if (stack.empty())
                    return i;
            }
        }
    }
    return -1;
    }
    
    public void preOrder(Node node){
    if (node == null)
        return;
    System.out.println(node.key);
    preOrder(node.left);
    preOrder(node.right);
    }
}
