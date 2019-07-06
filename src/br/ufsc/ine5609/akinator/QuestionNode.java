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
public class QuestionNode extends Node{
    private String question;
    private Node yes;
    private Node no;

    public QuestionNode(String question) {
        this.question = question;
    } 

    public QuestionNode(String question, Node yes, Node no) {
        this.question = question;
        this.yes = yes;
        this.no = no;
    } 

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Node getYes() {
        return yes;
    }

    public void setYes(Node yes) {
        this.yes = yes;
    }

    public Node getNo() {
        return no;
    }

    public void setNo(Node no) {
        this.no = no;
    }

    @Override
    public boolean isQuestionNode() {
        return true;
    }
    
}
