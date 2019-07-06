/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5609.akinator;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author Dall Agnol
 */
public class DecisionTree implements Serializable{
    Node root;

    public DecisionTree(String answer) {
        this.root = new DataNode(answer);
    }
    
    public void addQuestion(Node wrong, String question, String answer){
        QuestionNode node = new QuestionNode(question, new DataNode(answer),wrong);
        if (root.equals(wrong)){
            root = node;
        }else{
          QuestionNode parentNode =(QuestionNode) inOrderTraversal(root, wrong);
          if(parentNode.getNo().equals(wrong)){
              parentNode.setNo(node);
          }else if(parentNode.getYes().equals(wrong)){
              parentNode.setYes(node);
          }
        }
    }
    
    public QuestionNode getParentNode(Node node){
        QuestionNode result = this.root.isQuestionNode() ? (QuestionNode)this.root :null;
        while(result.getNo() != node){
        
        }
            
        return result;
    }
    
    public Node t2(Node root){
        
        Stack<Node> parentStack = new Stack<Node>();
        Node parent = null;
            if(root != null && root.isQuestionNode()){
                if(parentStack.size()==0){
                    parentStack.push(root);
                }
                System.out.println(" 's parent is "+((QuestionNode)root).getQuestion());
                 
                if(((QuestionNode)root).getNo()!=null){
                    parentStack.push(root); 
                    t2(((QuestionNode)root).getNo());  
                }
                parent = parentStack.pop();
                
                if(((QuestionNode)root).getYes()!=null){
                    parentStack.push(root);
                    t2(((QuestionNode)root).getNo());
                }
                if(!root.isQuestionNode()){
                    System.out.println("deu ruim");
                }
            }
            else{
                if(root==null){System.err.println("Can't process a empty root tree");}
            }
        return parent;
    }
    
   

    public Node inOrderTraversal(Node root, Node key){
        
        Stack<Node> parentStack = new Stack<Node>();
        Node parent = null;
            if(root != null && root.isQuestionNode()){
                if(parentStack.size()==0){
                    parentStack.push(root);
                }
                System.out.println(" 's parent is "+((QuestionNode)root).getQuestion());
                if(key.equals(root)){System.out.println("ae carai");
                return root;
                }
                if(((QuestionNode)root).getNo()!=null){
                    parentStack.push(root); 
                    inOrderTraversal(((QuestionNode)root).getNo(), key);  
                }
                parent = parentStack.pop();
                
                if(((QuestionNode)root).getYes()!=null){
                    parentStack.push(root);
                    inOrderTraversal(((QuestionNode)root).getNo(), key);
                }
                if(!root.isQuestionNode()){
                    System.out.println("deu ruim");
                }
            }
            else{
                if(root==null){System.err.println("Can't process a empty root tree");}
            }
        return parent;
    }
    
 

    public Node getRoot() {
        return root;
    }
    
    
     
}
