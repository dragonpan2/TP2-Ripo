/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;


public class Joueur implements Bougeable{
   private int numeroJoueur;
   private int nbVies=3;
   private int pointage;
   private int nbTirs;
   private int nbTirsTouche;
   private int positionX=0;
   private int positionY=0;
   
   private double accelerationx=0;
    private double accelerationy=0;
    private double angle=90;
    private double power=0.2;
    
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
    public Joueur(int numeroJoueur,int posx,int posy,int nbVies) {
        this.positionX=posx;
        this.positionY=posy;
        this.nbVies=nbVies;
        this.numeroJoueur=numeroJoueur;
    }
    
    

    public void avancer(){
        switch(orientation){
            case TOP:accelerationy=accelerationy-power;
            break;
            case TOPRIGHT:accelerationy=accelerationy-power;
            accelerationx=accelerationx+power;
            break;
            case RIGHT:accelerationx=accelerationx+power;
            break;
            case DOWNRIGHT:accelerationy=accelerationy+power;
            accelerationx=accelerationx+power;
            break;
            case DOWN:accelerationy=accelerationy+power;
            break;
            case DOWNLEFT:accelerationy=accelerationy+power;
            accelerationx=accelerationx-power;
            break;
            case LEFT:accelerationx=accelerationx-power;
            break;
            case TOPLEFT:accelerationx=accelerationx-power;
            accelerationy=accelerationy-power;
            break;
        }
        
    }
    
     public void reculer(){
         switch(orientation){
            case TOP:accelerationy=accelerationy+power;
            break;
            case TOPRIGHT:accelerationy=accelerationy+power;
            accelerationx=accelerationx-power;
            break;
            case RIGHT:accelerationx=accelerationx-power;
            break;
            case DOWNRIGHT:accelerationy=accelerationy-power;
            accelerationx=accelerationx-power;
            break;
            case DOWN:accelerationy=accelerationy-power;
            break;
            case DOWNLEFT:accelerationy=accelerationy-power;
            accelerationx=accelerationx+power;
            break;
            case LEFT:accelerationx=accelerationx+power;
            break;
            case TOPLEFT:accelerationx=accelerationx+power;
            accelerationy=accelerationy+power;
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
    
    public Projectile tirer(){
        Projectile laser=new Projectile(numeroJoueur,(int)accelerationx, (int)accelerationy, positionX, positionY);
        
        return laser;
    }
    @Override
    public void bouger(){
        positionY=(int)(positionY+accelerationy);
        positionX=((int)(positionX+accelerationx));
        if (angle<=22.5||angle>=337.5)orientation=Orientation.RIGHT;        
        if (angle<=67.5&&angle>=22.5)orientation=Orientation.TOPRIGHT;
        if (angle<=112.5&&angle>=67.5)orientation=Orientation.TOP;
        if (angle<=157.5&&angle>=112.5)orientation=Orientation.TOPLEFT;
        if (angle<=202.5&&angle>=157.5)orientation=Orientation.LEFT;
        if (angle<=247.5&&angle>=202.5)orientation=Orientation.DOWNLEFT;
        if (angle<=292.5&&angle>=247.5)orientation=Orientation.DOWN;
        if (angle<=337.5&&angle>=292.5)orientation=Orientation.DOWNRIGHT;
        if (positionY>400)positionY=-50;
        if (positionY<-50)positionY=400;
        if (positionX>800)positionX=-50;
        if (positionX<-50)positionX=800;
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

    public void setNbVies(int nbVies) {
        this.nbVies = nbVies;
    }

    public int getNbVies() {
        return nbVies;
    }

    public int getNbTirs() {
        return nbTirs;
    }

    public int getNbTirsTouche() {
        return nbTirsTouche;
    }

    public int getPointage() {
        return pointage;
    }

    public void setNbTirs(int nbTirs) {
        this.nbTirs = nbTirs;
    }

    public void setNbTirsTouche(int nbTirsTouche) {
        this.nbTirsTouche = nbTirsTouche;
    }

    public void setPointage(int pointage) {
        this.pointage = pointage;
    }
    
    public Orientation getOrientation() {
        return orientation;
    }

    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
    
    
    
    
    
    
   
}
