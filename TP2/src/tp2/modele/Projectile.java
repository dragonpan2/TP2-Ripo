/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;

/**
 *
 * @author 1566086
 */
public class Projectile implements Bougeable{

    int joueur;
    int vitesseX; 
    int vitesseY; 
    int dommage=1;
    int positionX;
    int positionY;
    int tempsRestant=100;
    
    public Projectile(int joueur,int vitesseX,int vitesseY,int positionX,int positionY) {
        if(vitesseX<0){
 
        }
        else{
 
        }
        if (vitesseY<0){

        }
        else{

        }
        this.positionX=positionX;
        this.positionY=positionY;
        this.joueur=joueur;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public int getJoueur() {
        return joueur;
    }
    
    

    
    @Override
    public void bouger() {
        positionX=positionX+vitesseX;
        positionY=positionY+vitesseY;
        tempsRestant--;
    }
    
    
}
