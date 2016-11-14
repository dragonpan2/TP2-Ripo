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
    Joueur joueur1;

    public Modele() {
        joueur1=new Joueur();
    }
    
    public void avancer(){
        joueur1.setPositionX(joueur1.getPositionX()+10);
        maj();
    }

    public Joueur getJoueur1() {
        return joueur1;
    }
    
    

    public void maj(){
        setChanged();
        notifyObservers();
    }
    
    
    
}
