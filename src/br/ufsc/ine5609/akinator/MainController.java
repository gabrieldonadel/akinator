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
    
    private MainView mainView; 
    private DecisionTreeMapper decisionTreeMapper; 

    private MainController() {
        this.decisionTreeMapper = new DecisionTreeMapper(); 
        this.mainView = new MainView();
         
    }

    public MainView getMainprivateView() {
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
    public void makeChoice(String choice){
    
        System.out.println("123");
    }
}
