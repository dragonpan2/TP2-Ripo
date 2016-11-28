/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;

import tp2.modele.Joueur.Orientation;

/**
 *
 * @author 1566086
 */
public class Projectile implements Bougeable{
    Orientation orientation;
    int joueur;
    int vitesseX=5; 
    int vitesseY=5; 
    int dommage=1;
    int positionX;
    int positionY;
    int tempsRestant=100;
    
    public Projectile(int joueur,Orientation orientation,int positionX,int positionY) {
        this.orientation=orientation;
        vitesse();
        
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

    public int getTempsRestant() {
        return tempsRestant;
        
    }
    
    public void vitesse(){
        switch(orientation){
            case TOP:vitesseY=-vitesseY;
            vitesseX=0;
            break;
            case TOPRIGHT:vitesseY=-vitesseY;
            break;
            case RIGHT:vitesseY=0;
            break;
            case DOWNRIGHT:
            break;
            case DOWN:vitesseX=0;
            break;
            case DOWNLEFT:vitesseX=-vitesseX;
            break;
            case LEFT:vitesseX=-vitesseX;
            vitesseY=0;
            break;
            case TOPLEFT:vitesseY=-vitesseY;
            vitesseX=0;
            break;
        }
    }
    

    
    @Override
    public void bouger() {
        positionX=positionX+vitesseX;
        positionY=positionY+vitesseY;
        tempsRestant--;
    }
    
    
}
