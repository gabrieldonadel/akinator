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
public class MainView {

    public MainView() {
        wellcomeView();
    }
    public void wellcomeView(){
        cleanView();
        System.out.println("    BEM-VINDO AO AKINATOR   \n");
        System.out.println("1. Pense em um animal ?");
        System.out.println("2. Vou tentar adivinhar o animal que você pensou! \n");
        System.out.println("Vamos lá... \n");
        comands();

    }
    public void cleanView(){
        System.out.println("\n\n\n\n\n\n\n\n\n\n");
    }
    
    public void comands(){
        System.out.println("[1] PARA SIM\n[2] PARA NÃO\n");
    } 
}
