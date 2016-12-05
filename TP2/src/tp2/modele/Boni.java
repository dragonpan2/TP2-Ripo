/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author panbe
 */
public class Boni extends JComponent {
    
    Random random = new Random();
    String boniType;

    public Boni() {
        this.setSize(30, 27);
        switch(random.nextInt(3)) {
            case 0:
                boniType = "plusVie";
                break;
            case 1:
                
                break;
            case 2:
                break;
            case 3:
                break;
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        Image img = Toolkit.getDefaultToolkit().getImage("boni1.gif");
        g.drawImage(img, 0, 0, this);
    }
    
    public void applyBoni(Joueur bufferedPlayer) {
        if ("plusVie".equals(this.boniType)) {
            bufferedPlayer.setNbVies(bufferedPlayer.getNbVies()+1);
        }
    }
    
    
    
}
