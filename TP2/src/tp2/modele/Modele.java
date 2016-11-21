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
    private double accelerationx=0;
    private double accelerationy=0;
    private double angle=90;
    
    public enum Orientation{
       TOP,
       TOPRIGHT,
       RIGHT,
       DOWNRIGHT,
       DOWN,
       DOWNLEFT,
       LEFT,
       TOPLEFT,
    }
    private Orientation orientation=Orientation.TOP;
    public Modele() {
        joueur1=new Joueur(3);
        joueur2=new Joueur(3);
        
        
        
        
        
        
        
    }
    
    public void avancer(){
        switch(orientation){
            case TOP:accelerationy--;
            break;
            case TOPRIGHT:accelerationy--;
            accelerationx++;
            break;
            case RIGHT:accelerationx++;
            break;
            case DOWNRIGHT:accelerationy++;
            accelerationx++;
            break;
            case DOWN:accelerationy++;
            break;
            case DOWNLEFT:accelerationy++;
            accelerationx--;
            break;
            case LEFT:accelerationx--;
            break;
            case TOPLEFT:accelerationx--;
            accelerationy--;
            break;
        }
        
    }
    
    public void reculer(){
         switch(orientation){
            case TOP:accelerationy++;
            break;
            case TOPRIGHT:accelerationy++;
            accelerationx--;
            break;
            case RIGHT:accelerationx--;
            break;
            case DOWNRIGHT:accelerationy--;
            accelerationx--;
            break;
            case DOWN:accelerationy--;
            break;
            case DOWNLEFT:accelerationy--;
            accelerationx++;
            break;
            case LEFT:accelerationx++;
            break;
            case TOPLEFT:accelerationx++;
            accelerationy++;
            break;
        }
    }
    
    public void tournerDroite(){
        angle=angle-8;
        if(angle<0)angle=360;
    }
    
    public void tournerGauche(){
        angle=angle+8;
        if(angle>360)angle=0;
    }
    
    public void bouger(){
        System.out.println(angle);
        joueur1.setPositionY((int)(joueur1.getPositionY()+accelerationy));
        joueur1.setPositionX((int)(joueur1.getPositionX()+accelerationx));
        if (angle<=22.5||angle>=337.5)orientation=Orientation.RIGHT;        
        if (angle<=67.5&&angle>=22.5)orientation=Orientation.TOPRIGHT;
        if (angle<=112.5&&angle>=67.5)orientation=Orientation.TOP;
        if (angle<=157.5&&angle>=112.5)orientation=Orientation.TOPLEFT;
        if (angle<=202.5&&angle>=157.5)orientation=Orientation.LEFT;
        if (angle<=247.5&&angle>=202.5)orientation=Orientation.DOWNLEFT;
        if (angle<=292.5&&angle>=247.5)orientation=Orientation.DOWN;
        if (angle<=337.5&&angle>=292.5)orientation=Orientation.DOWNRIGHT;
        if (joueur1.getPositionY()>400)joueur1.setPositionY(-50);
        if (joueur1.getPositionY()<-50)joueur1.setPositionY(400);
        if (joueur1.getPositionX()>800)joueur1.setPositionX(-50);
        if (joueur1.getPositionX()<-50)joueur1.setPositionX(800);
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

    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
    
    
    
    
}
