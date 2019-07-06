/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5609.akinator;

 /**
 *
 * @author Usuario
 */
import java.util.Scanner;
public class MainView {

    public MainView() {
        
    }
    public void wellcomeView(){
        cleanView();
        System.out.println("    BEM-VINDO AO AKINATOR   \n");
        System.out.println("1. Pense em um animal ?");
        System.out.println("2. Vou tentar adivinhar o animal que você pensou! \n");
        System.out.println("Vamos lá... \n");
        comands();
        print();
        
    }
    public void cleanView(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
    
    public void comands(){
        System.out.println("[1] PARA SIM | [2] PARA NÃO\n");
    }
    
    public void scanner (){
       Scanner scn = new Scanner(System.in);
       System.out.print("RESPONDA [ 1 / 2 ]: ");
       int decision = scn.nextInt();
       
       MainController.getInstance().makeChoice(decision);
    }
    
    public void print(){
        Node node = MainController.getInstance().getNodecursor();
        if (node.isQuestionNode()){
           QuestionNode root = (QuestionNode) MainController.getInstance().getNodecursor();
           System.out.println(root.getQuestion()+ " ?");
           scanner();
           
        }else{
            System.out.println("Já sei o que você estava pensando é um: " + ((DataNode)node).getAnswer());
            System.out.println("Acertei ?");
            finalAnswer();
        }     
    }
    public void finalAnswer(){
       Scanner scn = new Scanner(System.in);
       System.out.print("RESPONDA [ 1 / 2 ]: ");
       int decision = scn.nextInt();
       
       if (decision == 1){
           return;
       }else{
           System.out.println("Então qual é o animal que você pensou?");
           System.out.print("RESPONDA [ TEXTO ]: ");
           scn.nextLine();
           String newAnimal = scn.nextLine();
           System.out.println("O que diferência um(a) " + ((DataNode)MainController.getInstance().getNodecursor()).getAnswer() + " de um(a) " + newAnimal +" ?");
           System.out.print("RESPONDA [ TEXTO ]: ");
           String newQuestion = scn.nextLine();
           MainController.getInstance().addAnswer(newAnimal, newQuestion);
           System.out.println("Na proxima não errarei!");
       }    
    }
}
