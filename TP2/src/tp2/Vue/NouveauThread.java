/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import tp2.modele.Modele;

/**
 *
 * @author 1535905
 */
class NouveauThread extends Thread{
    private Modele modele;
    private Monde monde;
    public NouveauThread(Modele modele,Monde monde) {
        this.modele=modele;
        this.monde=monde;
    }
    
    @Override
public void run() {
    while(true){
    if(monde.getTouchesPesees().contains('w')){
        modele.avancer();
    }
    if(monde.getTouchesPesees().contains('s')){
        
    }
    if(monde.getTouchesPesees().contains('a')){
        
    }
    if(monde.getTouchesPesees().contains('d')){
           
    }
        try {
            Thread.sleep(1000);
            modele.maj();
        } catch (InterruptedException ex) {
         
        }
    }
}
}
