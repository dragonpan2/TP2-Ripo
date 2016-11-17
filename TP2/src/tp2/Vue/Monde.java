/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import tp2.modele.Modele;

public class Monde extends JPanel{
    private Modele modele;
    GameWindow gw;
     private ImageIcon vaisseau1Down;
     private ImageIcon vaisseau1DownLeft;
     private ImageIcon vaisseau1DownRight;
     private ImageIcon vaisseau1Left;
     private ImageIcon vaisseau1Right;
     private ImageIcon vaisseau1Top;
     private ImageIcon vaisseau1TopLeft;
     private ImageIcon vaisseau1TopRight;
     private ImageIcon vaisseau2Down;
     private ImageIcon vaisseau2DownLeft;
     private ImageIcon vaisseau2DownRight;
     private ImageIcon vaisseau2Left;
     private ImageIcon vaisseau2Right;
     private ImageIcon vaisseau2Top;
     private ImageIcon vaisseau2TopLeft;
     private ImageIcon vaisseau2TopRight;
     
     
     private JLabel joueur1=new JLabel();
    
     
   

    
    
    Thread thread=new Thread(){
            @Override
public void run() {
    while(true){
    if(gw.getTouchesPesees().contains('w')){
        modele.avancer();
    }
    if(gw.getTouchesPesees().contains('s')){
        modele.reculer();
    }
    if(gw.getTouchesPesees().contains('a')){
        
         modele.tournerGauche();
    }
    if(gw.getTouchesPesees().contains('d')){
           modele.tournerDroite();
    }
    modele.bouger();
        try {
            Thread.sleep(25);
            modele.maj();
        } catch (InterruptedException ex) {
         
        }
    }
}
       };
    
    

    public Monde(Modele modele, GameWindow gw) throws IOException{
        this.modele=modele;
        this.gw=gw;
        
       
        vaisseau1Down = new ImageIcon(ImageIO.read(new File("vaisseau1down.gif")));
        vaisseau1DownLeft = new ImageIcon(ImageIO.read(new File("vaisseau1downleft.gif")));
        vaisseau1DownRight = new ImageIcon(ImageIO.read(new File("vaisseau1downright.gif")));
        vaisseau1Left = new ImageIcon(ImageIO.read(new File("vaisseau1left.gif")));
        vaisseau1Right = new ImageIcon(ImageIO.read(new File("vaisseau1right.gif")));
        vaisseau1Top = new ImageIcon(ImageIO.read(new File("vaisseau1top.gif")));
        vaisseau1TopLeft = new ImageIcon(ImageIO.read(new File("vaisseau1topleft.gif")));
        vaisseau1TopRight = new ImageIcon(ImageIO.read(new File("vaisseau1topright.gif")));
        vaisseau2Down = new ImageIcon(ImageIO.read(new File("vaisseau2down.gif")));
        vaisseau2DownLeft = new ImageIcon(ImageIO.read(new File("vaisseau2downleft.gif")));
        vaisseau2DownRight = new ImageIcon(ImageIO.read(new File("vaisseau2downright.gif")));
        vaisseau2Left = new ImageIcon(ImageIO.read(new File("vaisseau2left.gif")));
        vaisseau2Right = new ImageIcon(ImageIO.read(new File("vaisseau2right.gif")));
        vaisseau2Top = new ImageIcon(ImageIO.read(new File("vaisseau2top.gif")));
        vaisseau2TopLeft = new ImageIcon(ImageIO.read(new File("vaisseau2topleft.gif")));
        vaisseau2TopRight = new ImageIcon(ImageIO.read(new File("vaisseau2topright.gif")));
        setPreferredSize(new Dimension(800,400));
        setBackground(Color.black);
        setLayout(null);
        
        initialiserVaisseau();
        
        thread.start();
        
        setVisible(true);
        
    }

   
    
    
    
    public void initialiserVaisseau(){
       joueur1.setBounds(100,100,100,100);
       joueur1.setIcon(vaisseau1Top);
       this.add(joueur1);
       
       
    }
    
    public void modifierJoueur(){
        joueur1.setLocation(modele.getJoueur1().getPositionX(),modele.getJoueur1().getPositionY());
        switch(modele.getOrientation()){
            case TOP:joueur1.setIcon(vaisseau1Top);
            break;
            case TOPRIGHT:joueur1.setIcon(vaisseau1TopRight);
            break;
            case RIGHT:joueur1.setIcon(vaisseau1Right);
            break;
            case DOWNRIGHT:joueur1.setIcon(vaisseau1DownRight);
            break;
            case DOWN:joueur1.setIcon(vaisseau1Down);
            break;
            case DOWNLEFT:joueur1.setIcon(vaisseau1DownLeft);
            break;
            case LEFT:joueur1.setIcon(vaisseau1Left);
            break;
            case TOPLEFT:joueur1.setIcon(vaisseau1TopLeft);
            break;
        }
    }

   
}
    
    
    
    
        

