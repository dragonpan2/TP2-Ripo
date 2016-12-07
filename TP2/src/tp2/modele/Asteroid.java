package tp2.modele;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author Bei Ning Pan et Emilien Perron
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
    
    /**
     * Constructeur
     */
    public Asteroid() {
        
        this.setSize(38, 38);
        this.pointVie = random.nextInt(1)+1; // peut change la vie de asteroid, si on le desire
        this.vitesseX = random.nextInt(2);     
        this.vitesseY = random.nextInt(3)+1;   //vitesse aleatoire pour chacun des asteroid
        this.positionIniX = random.nextInt(700);  
        this.positionIniY = random.nextInt(400);   //position aleatoire 
        
        this.setVisible(true);
    }

    /**
     *  responsable du mouvement des asteroid avec les vitese
     */
    @Override
    public void bouger() {  
        this.setLocation(this.getX()+vitesseX, this.getY()+vitesseY);
        if (this.getY() > 405) {
            this.setLocation(this.getX(), -25);
        }
        if (this.getX() > 805) {
            this.setLocation(-25,this.getY());
        }
    } // 
    
    public void paintComponent(Graphics g) {
        
        Image img = Toolkit.getDefaultToolkit().getImage("asteroid1.gif");
        g.drawImage(img, 0, 0, this);
    }

    
    //setter et getter

    /**
     *
     * @return
     */
        public int getPositionIniX() {
        return positionIniX;
    }

    /**
     *
     * @return  
     */
    public int getPositionIniY() {
        return positionIniY;
    }

    /**
     *
     * @return pointvie du asteroid
     */
    public int getPointVie() {
        return pointVie;
    }

    /**
     *
     * @param pointVie
     */
    public void setPointVie(int pointVie) {
        this.pointVie = pointVie;
    }
    
    
}
