/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufsc.ine5609.akinator;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

/**
 *
 * @author Dall Agnol
 */
public class DecisionTreeMapper {
    
    private DecisionTree cacheDecisionTree;
    private final String filename = "decisiontree.blob";
    
    public DecisionTreeMapper(){
        this.cacheDecisionTree = new DecisionTree("Gato");

        cacheDecisionTree.addQuestion(cacheDecisionTree.getRoot(), "É o melhor amigo do Homem", "Cachorro");
        Node no = ((QuestionNode) cacheDecisionTree.getRoot()).getNo();
        cacheDecisionTree.addQuestion(no, "Este animal coloca ovo", "Galinha");

        load();
    }
    public void load(){
        try{
            FileInputStream fIS = new FileInputStream(filename);
            ObjectInputStream oIS = new ObjectInputStream(fIS);
        
            this.cacheDecisionTree =  (DecisionTree) oIS.readObject();
            
            fIS.close();
            oIS.close();
            
        }catch(FileNotFoundException e){
            System.out.println("Arquivo nao encontrado.");
            persist();
        }catch(IOException e){
            System.out.println(e);
        }catch(ClassNotFoundException e){
            System.out.println(e);
        }
    }
    public void persist(){
        
        try{
            
            FileOutputStream fOS = new FileOutputStream(filename);
            
            ObjectOutputStream oOS = new ObjectOutputStream(fOS);
            
            oOS.writeObject(cacheDecisionTree);
            
            
            fOS.flush();
            oOS.flush();
            fOS.close();
            oOS.close();
            
        
        }catch(FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
        load();
    }
    public DecisionTree getDecisionTree(){
        return (cacheDecisionTree != null) ? cacheDecisionTree : null;
    }
    
    public void setDecisionTree(DecisionTree decisionTree){
        this.cacheDecisionTree = decisionTree;
    }
    
}
