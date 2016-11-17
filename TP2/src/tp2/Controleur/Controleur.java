/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Controleur;

import java.io.IOException;
import tp2.Vue.GameWindow;
import tp2.modele.Modele;

/**
 *
 * @author 1535905
 */
public class Controleur {
    
    
    private Modele modele = new Modele();
    private GameWindow gameWindow;

    public Controleur() throws IOException {
        this.gameWindow = new GameWindow(this, modele);
    }
    
    public void changeHealth(int numeroJoueur, int healthChange) {
        modele.changeHealth(numeroJoueur, healthChange);
    }
    
    public void changePointage(int numeroJoueur, int pointChange) {
        modele.changePointage(numeroJoueur, pointChange);
    }
    
    public void changeNbTir(int numeroJoueur, int tirChange) {
        modele.changeNbTir(numeroJoueur, tirChange);
    }
    
    public void changeNbTirTouch(int numeroJoueur, int tirTouchChange) {
        modele.changeNbTirTouch(numeroJoueur, tirTouchChange);
    }
    
}
