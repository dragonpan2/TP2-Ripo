/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Controleur;

import tp2.Vue.GameWindow;
import tp2.modele.Modele;

/**
 *
 * @author 1535905
 */
public class Controleur {
    
    
    private Modele modele = new Modele();
    private GameWindow gameWindow = new GameWindow(this, modele);
}
