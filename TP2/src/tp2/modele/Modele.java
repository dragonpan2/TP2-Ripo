/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;

import java.util.Observable;

/**
 *
 * @author 1535905
 */
public class Modele extends Observable {

    
    Joueur joueur1 = new Joueur();
    Joueur joueur2 = new Joueur();
    
    public Modele() {
        
        
        
        
    }
    
    

    public void maj(){
        setChanged();
        notifyObservers();
    }
    
    
    
}
