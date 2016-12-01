/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import tp2.modele.Joueur.Orientation;
import tp2.modele.Modele;

/**
 *
 * @author 1535905
 */
public class Vaisseau extends JComponent{
    Modele modele;

    public Vaisseau(Modele modele) {
        this.modele=modele;
        setSize(64,64);
        
        
    }
    
    @Override
    public void paintComponent(Graphics g) {
        Image img;
        switch(modele.getJoueur1().getOrientation()){
            case TOP:img=Toolkit.getDefaultToolkit().getImage("vaisseau1top.gif");
            break;
            case TOPRIGHT:img=Toolkit.getDefaultToolkit().getImage("vaisseau1topright.gif");
            break;
            case RIGHT:img=Toolkit.getDefaultToolkit().getImage("vaisseau1right.gif");
            break;
            case DOWNRIGHT:img=Toolkit.getDefaultToolkit().getImage("vaisseau1downRight.gif");
            break;
            case DOWN:img=Toolkit.getDefaultToolkit().getImage("vaisseau1down.gif");
            break;
            case DOWNLEFT:img=Toolkit.getDefaultToolkit().getImage("vaisseau1downleft.gif");
            break;
            case LEFT:img=Toolkit.getDefaultToolkit().getImage("vaisseau1left.gif");
            break;
            case TOPLEFT:img=Toolkit.getDefaultToolkit().getImage("vaisseau1topleft.gif");
            break;
        }
        img=Toolkit.getDefaultToolkit().getImage("vaisseau1down.gif");
        g.drawImage(img, 0, 0, this);
    }
    
}
