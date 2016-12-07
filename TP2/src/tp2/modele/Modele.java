package tp2.modele;

import java.util.ArrayList;
import java.util.Observable;
import javax.swing.JOptionPane;

/**
 *
 * @author Bei Ning Pan et Emilien Perron
 */
public class Modele extends Observable {
    private boolean partieFinie=false;
    private Joueur joueur1;
    private Joueur joueur2;
    
    private ArrayList <Projectile> laser=new ArrayList();
    private ArrayList <Asteroid>   listAsteroid = new ArrayList();
    
    /**
     * Constructeur du modele
     */
    public Modele() {
        joueur1=new Joueur(1,100,100,3);
        joueur2=new Joueur(2,300,100,3);
        
    }
    
    //code executer pour reset au etat initial des information contenu dans le modele
        public void resetPartie() {
        System.out.println("Resetting Round...");
        joueur1.setNbVies(3);
        joueur2.setNbVies(3);
        joueur1.setPositionX(50);
        joueur1.setPositionY(150);
        joueur2.setPositionX(700);
        joueur2.setPositionY(150);
        joueur1.setAccelerationx(0);
        joueur1.setAccelerationy(0);
        joueur2.setAccelerationx(0);
        joueur2.setAccelerationy(0);
        joueur1.setTEMPS_TIR(25);
        joueur1.setTEMPS_TIR(25);
     
        
    }
    /**
     * envoie la methode avancer au joueur 1
     */
    public void avancer1(){
        joueur1.avancer();
    }
    /**
     * envoie la methode reculer au joueur 1
     */
    public void reculer1(){
        joueur1.reculer();
    }
    /**
     * envoie la methode tourner droite au joueur 1
     */
    public void tournerDroite1(){
        joueur1.tournerDroite();
    }
    /**
     * envoie la methode tourner gauche au joueur 1
     */
    public void tournerGauche1(){
        joueur1.tournerGauche();
    }
    /**
     * envoie la methode tirer au joueur 1
     */
    public void tirer1(){
        if(joueur1.getTempsTir()<0){
        laser.add(joueur1.tirer());
        joueur1.setPointage(joueur1.getPointage()+1);
        joueur1.setNbTirs(joueur1.getNbTirs()+1);
        }
    }
    
    
    /**
     * envoie la methode avancer au joueur 2
     */
    public void avancer2(){
        joueur2.avancer();
    }
    /**
     * envoie la methode reculer au joueur 2
     */
    public void reculer2(){
        joueur2.reculer();
    }
    /**
     * envoie la methode tourner droite au joueur 2
     */
    public void tournerDroite2(){
        joueur2.tournerDroite();
    }
    
    /**
     *
     */
    public void tournerGauche2(){
        joueur2.tournerGauche();
    }
    
    /**
     * Methode pour tire le laser et verifie le temps
     */
    public void tirer2(){
        if(joueur2.getTempsTir()<0){
        laser.add(joueur2.tirer());
        joueur2.setPointage(joueur2.getPointage()+1);
        joueur2.setNbTirs(joueur2.getNbTirs()+1);
        }
        
    }
    
    /**
     *
     * @param numJoueur
     * verifie et annonce le victoire 
     * et demande que la partie soit reset
     */
    public void perdreVie(int numJoueur){
       if(numJoueur==1){
           joueur1.setNbVies(joueur1.getNbVies()-1);
           if (joueur1.getNbVies() == 0) {
               JOptionPane.showMessageDialog(null,"Le joueur 2 a gagné", "Partie Terminée", 0);
               joueur2.setNbVictoire(joueur2.getNbVictoire()+1);
               partieFinie=true;
           }
       }
        if(numJoueur==2){
           joueur2.setNbVies(joueur2.getNbVies()-1);
            
           if (joueur2.getNbVies() == 0) {
               JOptionPane.showMessageDialog(null,"Le joueur 1 a gagné", "Partie Terminée", 0);
               joueur1.setNbVictoire(joueur1.getNbVictoire()+1);
               partieFinie=true;
           }
       }
   }

    /**
     *
     * @return
     */
    public boolean getPartieFinie(){
        return partieFinie;
    }

    /**
     *
     * @param partieFinie
     */
    public void setPartieFinie(boolean partieFinie) {
        this.partieFinie = partieFinie;
    }
    
    /**
     * les deplacement des joueurs
     */
    public void bouger(){
        joueur1.bouger();
        joueur2.bouger();
        for (int i = 0; i < laser.size(); i++) {
            laser.get(i).bouger();
        }
        verifierLaserDisparu();
        maj();
    }
    
    /**
     *
     * @return
     */
    public Joueur getJoueur1() {
        return joueur1;
    }

    /**
     *
     * @return
     */
    public Joueur getJoueur2() {
        return joueur2;
    }
    
    
    //methodes appeler par le controleur pour modifier les informations du modele lors des mis a jour
    //
    /**
     *
     * @param numeroJoueur
     * @param healthChange
     */
        public void changeHealth(int numeroJoueur, int healthChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbVies(joueur1.getNbVies()+healthChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbVies(joueur2.getNbVies()+healthChange);
        }
        maj();
    }
    
    /**
     *
     * @param numeroJoueur
     * @param vicChange
     */
    public void changerNbVictoire(int numeroJoueur, int vicChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbVictoire(joueur1.getNbVictoire()+vicChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbVictoire(joueur2.getNbVictoire()+vicChange);
        }
        maj();
    }
    
    /**
     *
     * @param numeroJoueur
     * @param pointChange
     */
    public void changePointage(int numeroJoueur, int pointChange) {
        if (numeroJoueur == 1) {
            joueur1.setPointage(joueur1.getPointage()+pointChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setPointage(joueur2.getPointage()+pointChange);
        }
        maj();
    }
    
    /**
     *
     * @param numeroJoueur
     * @param tirChange
     */
    public void changeNbTir(int numeroJoueur, int tirChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbTirs(joueur1.getNbTirs()+tirChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbTirs(joueur2.getNbTirs()+tirChange);
        }
        maj();
    }
    
    /**
     *
     * @param numeroJoueur
     * @param tirTouchChange
     */
    public void changeNbTirTouch(int numeroJoueur, int tirTouchChange) {
        if (numeroJoueur == 1) {
            joueur1.setNbTirsTouche(joueur1.getNbTirsTouche()+tirTouchChange);
        }
        if (numeroJoueur == 2) {
            joueur2.setNbTirsTouche(joueur2.getNbTirsTouche()+tirTouchChange);
        }
        maj();
    }

    /**
     * responsable d'expirer les lasers
     */
    public void verifierLaserDisparu(){
        for (int i = 0; i < laser.size(); i++) {
            if(laser.get(i).getTempsRestant()==0){
                laser.remove(i);
            }
        }
    }
    
    /**
     *
     * @return laser
     */
    public ArrayList<Projectile> getLaser() {
        return laser;
    }
    
    /**
     *
     * @param joueur
     */
    public void superVite(int joueur){
        if(joueur==1){
            joueur1.setTEMPS_TIR(15);
        }
        if(joueur==2){
            joueur2.setTEMPS_TIR(15);
        }
    } // code pour le boni tirRapide
    
    /**
     *
     */
    public void maj(){
        setChanged();
        notifyObservers();
    } //trigger le methode update dans vue //ce methode est appeler apres chaque fois qu'il y a un change dans modele

    
    
    
    
    
}

