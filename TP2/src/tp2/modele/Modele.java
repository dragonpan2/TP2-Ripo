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
    
    private enum Orientation{
       TOP,
       TOPRIGHT,
       RIGHT,
       DOWNRIGHT,
       DOWN,
       DOWNLEFT,
       LEFT,
       TOPLEFT,
    }
    Orientation orientation=Orientation.TOP;
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
    
    public void tournerDroite(){
        switch(orientation){
            case TOP:orientation=Orientation.TOPRIGHT;
            break;
            case TOPRIGHT:orientation=Orientation.RIGHT;
            break;
            case RIGHT:orientation=Orientation.DOWNRIGHT;
            break;
            case DOWNRIGHT:orientation=Orientation.DOWN;
            break;
            case DOWN:orientation=Orientation.DOWNLEFT;
            break;
            case DOWNLEFT:orientation=Orientation.LEFT;
            break;
            case LEFT:orientation=Orientation.TOPLEFT;
            break;
            case TOPLEFT:orientation=Orientation.TOP;
            break;
        }
        
    }
    
    public void tournerGauche(){
        switch(orientation){
            case TOP:orientation=Orientation.TOPRIGHT;
            break;
            case TOPRIGHT:orientation=Orientation.RIGHT;
            break;
            case RIGHT:orientation=Orientation.DOWNRIGHT;
            break;
            case DOWNRIGHT:orientation=Orientation.DOWN;
            break;
            case DOWN:orientation=Orientation.DOWNLEFT;
            break;
            case DOWNLEFT:orientation=Orientation.LEFT;
            break;
            case LEFT:orientation=Orientation.TOPLEFT;
            break;
            case TOPLEFT:orientation=Orientation.TOP;
            break;
        }
        
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
