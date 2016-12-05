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
    private Orientation orientation;
    private int joueur;
    private int vitesseX=5; 
    private int vitesseY=5; 
    private int dommage=1;
    private int positionX;
    private int positionY;
    private int tempsRestant=60;
    
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

    public Orientation getOrientation() {
        return orientation;
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
            vitesseX=-vitesseX;
            break;
        }
    }
    

    
    @Override
    public void bouger() {
        positionX=positionX+vitesseX;
        positionY=positionY+vitesseY;
        if (positionY>400)positionY=-50;
        if (positionY<-50)positionY=400;
        if (positionX>800)positionX=-50;
        if (positionX<-50)positionX=800;
        tempsRestant--;
    }
    
    
}
