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
        QuestionNode node = new QuestionNode(question, new DataNode(answer),wrong);
        if (root.equals(wrong)){
            root = node;
        }else{
            //percorre a arvore até achar o nó pai
        }
    }

    public Node getRoot() {
        return root;
    }
    
    
     
}
