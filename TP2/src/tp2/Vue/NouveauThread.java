/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;

import java.util.logging.Level;
import java.util.logging.Logger;
import tp2.modele.Modele;

/**
 *
 * @author 1535905
 */
class NouveauThread extends Thread{
Modele modele;
    public NouveauThread(Modele modele) {
        this.modele=modele;
    }
    
    @Override
public void run() {
    while(true){
    if(Monde.getTouchesPesees().contains('w')){
        
    }
    if(Monde.getTouchesPesees().contains('s')){
        
    }
    if(Monde.getTouchesPesees().contains('a')){
        
    }
    if(Monde.getTouchesPesees().contains('d')){
           
    }
        try {
            Thread.sleep(1000);
            Modele.maj();
        } catch (InterruptedException ex) {
            Logger.getLogger(NouveauThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
