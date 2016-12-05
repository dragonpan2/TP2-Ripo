/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;

import java.util.ArrayList;
import java.util.Observable;
import tp2.Vue.Monde;

/**
 *
 * @author 1535905
 */
public class Modele extends Observable {
    
    private Joueur joueur1;
    private Joueur joueur2;
    
    private ArrayList <Projectile> laser=new ArrayList();
    private ArrayList <Asteroid>   listAsteroid = new ArrayList();
    
    public Modele() {
        joueur1=new Joueur(1,100,100,3);
        joueur2=new Joueur(2,300,100,3);
        
    }
    
    public void resetPartie() {
        System.out.println("Resetting Round...");
        joueur1.setNbVies(3);
        joueur2.setNbVies(3);
//        joueur1.setPointage(0);
//        joueur2.setPointage(0);
        joueur1.setPositionX(50);
        joueur1.setPositionY(150);
        joueur2.setPositionX(700);
        joueur2.setPositionY(150);
        joueur1.setAccelerationx(0);
        joueur1.setAccelerationy(0);
        joueur2.setAccelerationx(0);
        joueur2.setAccelerationy(0);
      //  Monde.resetField();
        
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
    
    public void tirer1(){
        if(joueur1.getTempsTir()<0){
        laser.add(joueur1.tirer());
        }
    }
    
    public void changerNbVictoire(int numeroJoueur, int vicChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbVictoire(joueur1.getNbVictoire()+vicChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbVictoire(joueur2.getNbVictoire()+vicChange);
        }
        maj();
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
    
   public void tirer2(){
        if(joueur2.getTempsTir()<0){
        laser.add(joueur2.tirer());
        }
    }
    
    
    
    public void bouger(){
        joueur1.bouger();
        joueur2.bouger();
        for (int i = 0; i < laser.size(); i++) {
            laser.get(i).bouger();
        }
        verifierLaserDisparu();
        verifierCollisions();
        maj();
    }
    
    public void verifierCollisions(){
        
        
        //verifier les lasers
        for (int i = 0; i < laser.size(); i++) {
            
                        
            
            
            
            
        }
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

    public void verifierLaserDisparu(){
        for (int i = 0; i < laser.size(); i++) {
            if(laser.get(i).getTempsRestant()==0){
                laser.remove(i);
            }
        }
    }
    
    
    
    
    
    public ArrayList<Projectile> getLaser() {
        return laser;
    }
    
    public void superVite(int joueur){
        if(joueur==1){
            joueur1.setTEMPS_TIR(10);
        }
        if(joueur==2){
            joueur2.setTEMPS_TIR(10);
        }
    }
    
    
    

    public void maj(){
        setChanged();
        notifyObservers();
    } //trigger le methode update dans vue //ce methode est appeler apres chaque fois qu'il y a un change dans modele

    
    
    
    
    
}

