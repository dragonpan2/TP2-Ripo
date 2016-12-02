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
 * @author 1566086
 */
public class Asteroid extends JComponent implements Bougeable {

    int pointVie;
    int positionX;
    int positionY;
    int vitesseX;
    int vitesseY;
    int positionIniX;
    int positionIniY;
    Random random = new Random();
    
    public Asteroid() {
        
        this.setSize(38, 38);
        this.pointVie = random.nextInt(1)+1;
        this.vitesseX = random.nextInt(2);
        this.vitesseY = random.nextInt(3)+1;
        this.positionIniX = random.nextInt(700);
        this.positionIniY = random.nextInt(400);
        
        this.setVisible(true);
    }

    @Override
    public void bouger() {
        this.setLocation(this.getX()+vitesseX, this.getY()+vitesseY);
        if (this.getY() > 405) {
            this.setLocation(this.getX(), -25);
        }
        if (this.getX() > 805) {
            this.setLocation(-25,this.getY());
        }
    }
    
    public void paintComponent(Graphics g) {
        
        Image img = Toolkit.getDefaultToolkit().getImage("asteroid1.gif");
        g.drawImage(img, 0, 0, this);
    }

    public int getPositionIniX() {
        return positionIniX;
    }

    public int getPositionIniY() {
        return positionIniY;
    }

    public int getPointVie() {
        return pointVie;
    }

    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }
    
    
    
    
    
    public void asteroidHit() {
        
        pointVie--;
        
        if (pointVie < 1) {
            
            
            
            
        }
    }
    
    
    
}
