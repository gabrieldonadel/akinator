/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5609.akinator;

import java.io.Serializable; 

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
        QuestionNode node = new QuestionNode(question, new DataNode(answer), wrong);
        if (root.equals(wrong)){
            root = node;
        }else{
            QuestionNode parentNode =(QuestionNode) getParentNode( wrong); 
            if(parentNode.getNo().equals(wrong)){
                parentNode.setNo(node);
            }else if(parentNode.getYes().equals(wrong)){
                parentNode.setYes(node);
            } 
        }
        
    }
    
    public Node getParentNode(Node child){ 
        Node result = null;
        if(root==null){
            return null;
        }
        if(root.isQuestionNode()){
            if(((QuestionNode)root).getYes().equals(child) || ((QuestionNode)root).getNo().equals(child)){
                return root;
            }
            Node yes = getParentNode(((QuestionNode)root).getYes(),child);
            if(yes != null){
                result = yes;
            }
            Node no = getParentNode(((QuestionNode)root).getNo(),child);
            if(no != null){
                result = no;
            }
            
        }
        return result;
    }
    public Node getParentNode(Node root, Node child){
        Node result = null;
        if(root==null){
            return null;
        }
        if(root.isQuestionNode()){
            if(((QuestionNode)root).getYes().equals(child) || ((QuestionNode)root).getNo().equals(child)){
                return root;
            }
            Node yes = getParentNode(((QuestionNode)root).getYes(),child);
            if(yes != null){
                result = yes;
            }
            Node no = getParentNode(((QuestionNode)root).getNo(),child);
            if(no != null){
                result = no;
            }
        }
        return result;
    } 
    public Node getRoot() {
        return root;
    }
    
}
