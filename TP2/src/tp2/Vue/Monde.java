/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;



import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Monde extends JPanel{
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
    
    
    
    
    
    

    public Monde() throws IOException{
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
        setPreferredSize(new Dimension(1600,800));
        setBackground(Color.black);
        
        
        
    }
    
    
        
}
