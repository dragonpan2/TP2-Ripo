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
    
    private Joueur joueur1;
    private Joueur joueur2;
    private int acceleration=0;
    public Modele() {
        joueur1=new Joueur(3);
        joueur2=new Joueur(3);
        
        
        
        
        
        
        
    }
    
    public void avancer(){
        acceleration--;
        
    }
    
    public void reculer(){
        acceleration++;
        
    }
    public void bouger(){
        joueur1.setPositionY(joueur1.getPositionY()+acceleration);
        if (joueur1.getPositionY()>400)joueur1.setPositionY(-50);
        if (joueur1.getPositionY()<-50)joueur1.setPositionY(400);
        maj();
    }

    public Joueur getJoueur1() {
        return joueur1;
    }
    
    public void changeHealth(int numeroJoueur, int healthChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbVies(joueur1.getNbVies()+healthChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbVies(joueur2.getNbVies()+healthChange);
        }
        
    }
    
    public void changePointage(int numeroJoueur, int pointChange) {
        if (numeroJoueur == 1) {
            joueur1.setPointage(joueur1.getPointage()+pointChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setPointage(joueur2.getPointage()+pointChange);
        }
    }
    
    public void changeNbTir(int numeroJoueur, int tirChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbTirs(joueur1.getNbTirs()+tirChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbTirs(joueur2.getNbTirs()+tirChange);
        }
    }
    
    public void changeNbTirTouch(int numeroJoueur, int tirTouchChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbTirsTouche(joueur1.getNbTirsTouche()+tirTouchChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbTirsTouche(joueur2.getNbTirsTouche()+tirTouchChange);
        }
    }
    
    

    public void maj(){
        setChanged();
        notifyObservers();
    }
    
    
    
}
