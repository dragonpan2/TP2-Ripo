/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import tp2.Controleur.Controleur;
import tp2.modele.Modele;

/**
 *
 * @author 1566086
 */
public class GameWindow extends JFrame implements Observer{

    private Controleur controleur;
    private Modele modele;
    
    Monde monde;
    
    private JMenuBar menu=new JMenuBar();
    private JMenu mnFichier=new JMenu("Fichier");
    private JMenu mnAide=new JMenu("Aide");
    private JMenuItem mnItemNouvellePartie=new JMenuItem("NouvellePartie");
    private JMenuItem mnItemQuitter=new JMenuItem("Quitter");
    
    public GameWindow(Controleur controleur, Observable observable)  {
        this.modele = (Modele) observable;
        this.controleur = controleur;
        
        
        try {
            this.monde = new Monde(modele);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        menus();
        
        
        this.add(monde);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    public void menus(){
         mnFichier.add(mnItemNouvellePartie);
        mnFichier.addSeparator();
        mnFichier.add(mnItemQuitter);
        menu.add(mnFichier);
        menu.add(mnAide);
        setJMenuBar(menu);
    }
    
    

    @Override
    public void update(Observable o, Object o1) {
        
    }
    
    
    
}
