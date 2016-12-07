package tp2.Controleur;

import java.io.IOException;
import tp2.Vue.GameWindow;
import tp2.modele.Modele;

/**
 *
 * @author Bei Ning Pan et Emilien Perron
 */
public class Controleur {
    
    
    private Modele modele = new Modele();
    private GameWindow gameWindow;

    /**
     *
     * @throws IOException
     */
    public Controleur() throws IOException {
        //initialisation du modele et du gameWindow
        this.gameWindow = new GameWindow(this, modele);
    }
    
    //methode responsable de modifier les données vers modele
    //
    /**
     *
     * @param numeroJoueur numero du joueur a changer soit un ou deux
     * @param healthChange quantité de point de vie a changer, peut etre negatif au necessaire
     */
        public void changeHealth(int numeroJoueur, int healthChange) {
        modele.changeHealth(numeroJoueur, healthChange);
    }
    
    /**
     *
     * @param numeroJoueur numero du joueur a changer soit un ou deux
     * @param pointChange quantité de point a changer
     */
    public void changePointage(int numeroJoueur, int pointChange) {
        modele.changePointage(numeroJoueur, pointChange);
    }
    
    /**
     *
     * @param numeroJoueur numero du joueur a changer soit un ou deux
     * @param tirChange  quantité de tir total a changer
     */
    public void changeNbTir(int numeroJoueur, int tirChange) {
        modele.changeNbTir(numeroJoueur, tirChange);
    }
    
    /**
     *
     * @param numeroJoueur numero du joueur a changer soit un ou deux
     * @param tirTouchChange quantité de tir touché a changer
     */
    public void changeNbTirTouch(int numeroJoueur, int tirTouchChange) {
        modele.changeNbTirTouch(numeroJoueur, tirTouchChange);
    }
    
    /**
     *
     * @param numeroJoueur numero du joueur a changer soit un ou deux
     * @param vicChange quantité de nombre de victoire a changer
     */
    public void changerNbVictoire(int numeroJoueur, int vicChange) {
        modele.changerNbVictoire(numeroJoueur, vicChange);
    }
    
    /**
     *
     * @param numeroJoueur numero du joueur a changer soit un ou deux
     * @param tirChange  quantité de nombre de tir a change
     */
    public void changeTir(int numeroJoueur, int tirChange) {
        modele.changeNbTir(numeroJoueur, tirChange);
    }
    
    /**
     *
     * @param numeroJoueur numero du joueur a changer soit un ou deux
     * @param tirToucheChange quantité de nombre de tir touche a change
     */
    public void changeTirTouch(int numeroJoueur, int tirToucheChange) {
        modele.changeNbTirTouch(numeroJoueur, tirToucheChange);
    }
    
}
