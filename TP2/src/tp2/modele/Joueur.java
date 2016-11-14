/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;


public class Joueur {
   int nbVies=3;
   int pointage;
   int nbTirs;
   int nbTirsTouche;
   int positionX=100;
   int positionY=100;
    public Joueur() {
        
        
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }
    
    
   
}
