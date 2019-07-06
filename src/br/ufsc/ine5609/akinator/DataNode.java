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
public class DataNode extends Node{
    private String answer; 

    public DataNode(String answer) {
        this.answer = answer;
    }

    @Override
    public boolean isQuestionNode() {
       return false;
    }
    
    
    
}
