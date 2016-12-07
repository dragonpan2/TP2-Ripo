package tp2.modele;

/**
 *
 * @author Bei Ning Pan et Emilien Perron
 */
public class Joueur implements Bougeable{
   private int numeroJoueur;
   private int nbVies=3;
   private int pointage;
   private int nbTirs;
   private int nbTirsTouche;
   private int positionX=0;
   private int positionY=0;
   private int largeur=100;
   private int longueur=100;
   private int nbVictoire = 0;
   
   private double accelerationx=0;
    private double accelerationy=0;
    private double angle=90;
    private double power=0.2;
    private int tempsTir=0;
    private int TEMPS_TIR=30;
    
    /**
     * enum d'orientation
     */
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
    private Orientation orientation;

    /**
     *
     * @param numeroJoueur
     * @param posx
     * @param posy
     * @param nbVies
     */
    public Joueur(int numeroJoueur,int posx,int posy,int nbVies) {
        this.positionX=posx;
        this.positionY=posy;
        this.nbVies=nbVies;
        this.numeroJoueur=numeroJoueur;
        this.nbVictoire = 0;
        orientation=Orientation.TOP;
    }
    
    
/**
 * donne la nouvelle acceleration du vaisseau en fonction de son orientation
 */
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
    /**
 * donne la nouvelle acceleration du vaisseau en fonction de son orientation
 * si lacceleration est dans le sens opposé de lorientation, lacceleration ne sera
 * pas changé
 */
     public void reculer(){
         
         switch(orientation){
            case TOP:if((accelerationy)<=0){
                accelerationy=accelerationy+power;
            }
            break;
            case TOPRIGHT:if((accelerationy)<=0){
                accelerationy=accelerationy+power;
            }
            if((int)(accelerationx)>=0){
                accelerationx=accelerationx-power;
            }
            break;
            case RIGHT:if((accelerationx)>=0){
                accelerationx=accelerationx-power;
            }
            break;
            case DOWNRIGHT:if((accelerationy)>=0){
                accelerationy=accelerationy-power;
            }
            if((int)(accelerationx)>=0){
                accelerationx=accelerationx-power;
            }
            break;
            case DOWN:if((accelerationy)>=0){
                accelerationy=accelerationy-power;
            }
            break;
            case DOWNLEFT:if((accelerationy)>=0){
                accelerationy=accelerationy-power;
            }
            if((accelerationx)<=0){
                accelerationx=accelerationx+power;
            }
            break;
            case LEFT:if((accelerationx)<=0){
                accelerationx=accelerationx+power;
            }
            break;
            case TOPLEFT:if((accelerationx)<=0){
                accelerationx=accelerationx+power;
            }
            if((accelerationy)<=0){
                accelerationy=accelerationy+power;
            }
            break;
        
     }
            
         
         
    }
     /**
      * change langle pour pouvoir modifier lorientation apres
      */
     public void tournerDroite(){
        angle=angle-8;
        if(angle<0)angle=360;
    }
    
    /**
     *
     */
    public void tournerGauche(){
        angle=angle+8;
        if(angle>360)angle=0;
    }
    
    /**
     *
     * @return
     */
    public Projectile tirer(){
        tempsTir=TEMPS_TIR;
        Projectile laser;
        laser=new Projectile(numeroJoueur,orientation, positionX+13, positionY+13);
        return laser;
    }

    /**
     *
     */
    @Override
    /**
     * donne lorientation en fonction de langle du vaisseau
     */
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
        tempsTir--;
    }

    /**
     *
     * @return
     */
    public int getNbVictoire() {
        return nbVictoire;
    }

    /**
     *
     * @param nbVictoire
     */
    public void setNbVictoire(int nbVictoire) {
        this.nbVictoire = nbVictoire;
    }

    /**
     *
     * @param accelerationx
     */
    public void setAccelerationx(double accelerationx) {
        this.accelerationx = accelerationx;
    }

    /**
     *
     * @param accelerationy
     */
    public void setAccelerationy(double accelerationy) {
        this.accelerationy = accelerationy;
    }

    /**
     *
     * @return
     */
    public int getNumeroJoueur() {
        return numeroJoueur;
    }
    
    /**
     *
     * @param positionX
     */
    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    /**
     *
     * @param positionY
     */
    public void setPositionY(int positionY) {
        this.positionY = positionY;
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
     * @param nbVies
     */
    public void setNbVies(int nbVies) {
        this.nbVies = nbVies;
    }

    /**
     *
     * @return
     */
    public int getNbVies() {
        return nbVies;
    }

    /**
     *
     * @return
     */
    public int getNbTirs() {
        return nbTirs;
    }

    /**
     *
     * @return
     */
    public int getNbTirsTouche() {
        return nbTirsTouche;
    }

    /**
     *
     * @return
     */
    public int getPointage() {
        return pointage;
    }

    /**
     *
     * @param nbTirs
     */
    public void setNbTirs(int nbTirs) {
        this.nbTirs = nbTirs;
    }

    /**
     *
     * @param nbTirsTouche
     */
    public void setNbTirsTouche(int nbTirsTouche) {
        this.nbTirsTouche = nbTirsTouche;
    }

    /**
     *
     * @param pointage
     */
    public void setPointage(int pointage) {
        this.pointage = pointage;
    }
    
    /**
     *
     * @return
     */
    public Orientation getOrientation() {
        return orientation;
    }

    /**
     *
     * @param orientation
     */
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }

    /**
     *
     * @return
     */
    public double getTempsTir() {
        return tempsTir;
    }

    /**
     *
     * @return
     */
    public int getLargeur() {
        return largeur;
    }

    /**
     *
     * @return
     */
    public int getLongueur() {
        return longueur;
    }

    /**
     *
     * @param TEMPS_TIR
     */
    public void setTEMPS_TIR(int TEMPS_TIR) {
        this.TEMPS_TIR = TEMPS_TIR;
    }
    
    
    
    
    
    
    
   
}
