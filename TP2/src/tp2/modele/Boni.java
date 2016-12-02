/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.modele;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JComponent;

/**
 *
 * @author panbe
 */
public class Boni extends JComponent {

    public Boni() {
        this.setSize(30, 27);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        
        Image img = Toolkit.getDefaultToolkit().getImage("boni1.gif");
        g.drawImage(img, 0, 0, this);
    }
    
}
