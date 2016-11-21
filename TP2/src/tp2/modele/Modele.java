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
    
    
    
    public Modele() {
        joueur1=new Joueur(100,100,3);
        joueur2=new Joueur(300,100,3);
        
        
    }
    
    public void avancer1(){
        joueur1.avancer();
    }
    
    public void reculer1(){
        joueur1.reculer();
    }
    
    public void tournerDroite1(){
        joueur1.tournerDroite();
    }
    
    public void tournerGauche1(){
        joueur1.tournerGauche();
    }
    
    public void avancer2(){
        joueur2.avancer();
    }
    
    public void reculer2(){
        joueur2.reculer();
    }
    
    public void tournerDroite2(){
        joueur2.tournerDroite();
    }
    
    public void tournerGauche2(){
        joueur2.tournerGauche();
    }
    
   
    
    
    
    public void bouger(){
        joueur1.bouger();
        joueur2.bouger();
        maj();
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }
    
    public void changeHealth(int numeroJoueur, int healthChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbVies(joueur1.getNbVies()+healthChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbVies(joueur2.getNbVies()+healthChange);
        }
        maj();
    }
    
    public void changePointage(int numeroJoueur, int pointChange) {
        if (numeroJoueur == 1) {
            joueur1.setPointage(joueur1.getPointage()+pointChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setPointage(joueur2.getPointage()+pointChange);
        }
        maj();
    }
    
    public void changeNbTir(int numeroJoueur, int tirChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbTirs(joueur1.getNbTirs()+tirChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbTirs(joueur2.getNbTirs()+tirChange);
        }
        maj();
    }
    
    public void changeNbTirTouch(int numeroJoueur, int tirTouchChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbTirsTouche(joueur1.getNbTirsTouche()+tirTouchChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbTirsTouche(joueur2.getNbTirsTouche()+tirTouchChange);
        }
        maj();
    }
    
    

    public void maj(){
        setChanged();
        notifyObservers();
    } //trigger le methode update dans vue //ce methode est appeler apres chaque fois qu'il y a un change dans modele

    
    
    
    
    
}
