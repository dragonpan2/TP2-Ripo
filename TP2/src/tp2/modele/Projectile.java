package tp2.modele;

import tp2.modele.Joueur.Orientation;

/**
 *
 * @author Bei Ning Pan et Emilien Perron
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
    
    /**
     *
     * @param joueur
     * @param orientation
     * @param positionX
     * @param positionY
     */
    public Projectile(int joueur,Orientation orientation,int positionX,int positionY) {
        this.orientation=orientation;
        vitesse();
        
        this.positionX=positionX;
        this.positionY=positionY;
        this.joueur=joueur;
    }

    /**
     *
     * @return
     */
    public int getPositionX() {
        return positionX;
    }

    /**
     *
     * @return
     */
    public int getPositionY() {
        return positionY;
    }

    /**
     *
     * @return
     */
    public int getJoueur() {
        return joueur;
    }

    /**
     *
     * @return
     */
    public int getTempsRestant() {
        return tempsRestant;
        
    }

    /**
     *
     * @return
     */
    public Orientation getOrientation() {
        return orientation;
    }
    
    /**
     *   responsable des vitess
     */
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
    
    /**
     *   Methode qui coordone les deplacement du projectile
     */
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
