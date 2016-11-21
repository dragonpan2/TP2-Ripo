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
    
    public Projectile(int vitesseX,int vitesseY,int positionX,int positionY) {
        this.vitesseX=vitesseX;
        this.vitesseY=vitesseY;
        this.positionX=positionX;
        this.positionY=positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    
    @Override
    public void bouger() {
        positionX=positionX+vitesseX;
        positionY=positionY+vitesseY;
        tempsRestant--;
    }
    
    
}
