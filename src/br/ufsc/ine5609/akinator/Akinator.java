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
import java.util.Scanner;

public class Akinator{
      
    public static void main(String[] args) {
       MainController controller = MainController.getInstance();
       QuestionNode root = (QuestionNode) controller.getDecisionTree().getRoot();
       System.out.println(root.getQuestion());
       
       Scanner scn = new Scanner(System.in);
       String decision = scn.nextLine();
       
       controller.makeChoice(decision);
       
        
    }
}
