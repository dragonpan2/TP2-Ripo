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
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JLabel;
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

    private static Controleur controleur;
    private static Modele modele;
    
    Monde monde;
    
    private JMenuBar menu=new JMenuBar();
    private JMenu mnFichier=new JMenu("Fichier");
    private JMenu mnAide=new JMenu("Aide");
    private JMenuItem mnItemNouvellePartie=new JMenuItem("NouvellePartie");
    private JMenuItem mnItemQuitter=new JMenuItem("Quitter");
      
     private static ArrayList<Character> touchesPesees = new ArrayList();
    
    private static KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {
            
        }

        @Override
        public void keyPressed(KeyEvent e) {  
            
            if (!(touchesPesees.contains(e.getKeyChar()))) {   
                touchesPesees.add(e.getKeyChar());
            }
            
        }

        @Override
        public void keyReleased(KeyEvent e) { 
            if (touchesPesees.contains(e.getKeyChar())) {
                touchesPesees.remove((Character) e.getKeyChar());
            }
            
        }
    };
    
    public GameWindow(Controleur controleur, Observable observable) throws IOException  {
        
        this.modele = (Modele) observable;
        modele.addObserver(this);
        this.monde = new Monde(modele,this);
        this.controleur = controleur;
        
        
        
        
        this.addKeyListener(kl);
       
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

    public static ArrayList<Character> getTouchesPesees() {
        return touchesPesees;
    }
    
    

    @Override
    public  void update(Observable o, Object o1) {
        Modele modele = (Modele) o;
        int nbVieP1 = modele.getJoueur1().getNbVies();
        int nbVieP2 = modele.getJoueur2().getNbVies();
        int pointP1 = modele.getJoueur1().getPointage();
        int pointP2 = modele.getJoueur2().getPointage();
        //set graphical change here
<<<<<<< HEAD
        
=======
        //
        Monde.lblVieJ1.setText("Point de Vie: "+Integer.toString(nbVieP1));
        Monde.lblVieJ2.setText("Point de Vie: "+Integer.toString(nbVieP2));
        Monde.lblPointJ1.setText("Pointage: "+Integer.toString(pointP1));
        Monde.lblPointJ2.setText("Pointage: "+Integer.toString(pointP2));
>>>>>>> origin/master
        monde.modifierJoueur();
    }
    
    
    
}
