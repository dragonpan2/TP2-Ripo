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
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 *
 * @author 1566086
 */
public class GameWindow extends JFrame {

    Monde monde;
    
    private JMenuBar menu=new JMenuBar();
    private JMenu mnFichier=new JMenu("Fichier");
    private JMenu mnAide=new JMenu("Aide");
    private JMenuItem mnItemNouvellePartie=new JMenuItem("NouvellePartie");
    private JMenuItem mnItemQuitter=new JMenuItem("Quitter");
    
    public GameWindow() throws IOException  {
        this.monde = new Monde();
        
        mnFichier.add(mnItemNouvellePartie);
        mnFichier.addSeparator();
        mnFichier.add(mnItemQuitter);
        menu.add(mnFichier);
        menu.add(mnAide);
        setJMenuBar(menu);
        
        
        this.add(monde);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        
    }
    
    
    
}
