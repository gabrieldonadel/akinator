/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5609.akinator;


/**
 *
 * @author jfranca
 */
public class MainController {
    
    private static MainController mainController;
    private Node nodecursor; 
    private MainView mainView; 
    private DecisionTreeMapper decisionTreeMapper; 

    private MainController() {
        this.decisionTreeMapper = new DecisionTreeMapper(); 
        this.mainView = new MainView();
        this.nodecursor = getDecisionTree().getRoot();
    }

    public MainView getMainView() {
        return mainView;
    }
    
    public DecisionTreeMapper getDecisionTreeMapper() {
        return this.decisionTreeMapper;
    }
    public DecisionTree getDecisionTree() {
        return this.decisionTreeMapper.getDecisionTree();
    }
      
    public static MainController getInstance(){
        return (mainController == null)? mainController = new MainController() : mainController;

    }
    public void makeChoice(int choice){
        if (choice == 1){
            nodecursor = ((QuestionNode)nodecursor).getYes();
        }else if(choice == 2){
            nodecursor = ((QuestionNode)nodecursor).getNo();
        }
        getMainView().print();
    }
    public Node getNodecursor() {
        return nodecursor;
    }
    
    public void addAnswer (String animal,String question){
        getDecisionTree().addQuestion(nodecursor, question, animal);
        decisionTreeMapper.persist();
    }
}
