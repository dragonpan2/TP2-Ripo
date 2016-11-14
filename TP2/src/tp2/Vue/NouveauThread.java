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
    private ArrayList<Character>TouchesPesees=new ArrayList();
    public NouveauThread(Modele modele,Monde monde,ArrayList<Character>TouchesPesees) {
        this.modele=modele;
        this.monde=monde;
        this.TouchesPesees=TouchesPesees;
    }
    
    @Override
public void run() {
    while(true){
        
    if(TouchesPesees.contains('w')){
        modele.avancer();
    }
    if(TouchesPesees.contains('s')){
        
    }
    if(TouchesPesees.contains('a')){
        
    }
    if(TouchesPesees.contains('d')){
           
    }
        try {
            Thread.sleep(200);
            modele.maj();
        } catch (InterruptedException ex) {
            Logger.getLogger(NouveauThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
}
