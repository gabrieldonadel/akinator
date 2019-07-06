/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5609.akinator;

/**
 *
 * @author Dall Agnol
 */
public class Akinator{
      
    public static void main(String[] args) {
        
        DecisionTreeMapper  decisionTreeMapper= new DecisionTreeMapper();
        DecisionTree decisionTree = decisionTreeMapper.getDecisionTree();
        System.out.println(((QuestionNode)decisionTree.getRoot()).getQuestion());
    }
}
