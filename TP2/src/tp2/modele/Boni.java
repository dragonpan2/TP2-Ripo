package tp2.modele;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.Random;
import javax.swing.JComponent;

/**
 *
 * @author Bei Ning Pan et Emilien Perron
 */
public class Boni extends JComponent {
    
    Random random = new Random();
    String boniType;
    Modele modele;
    Image img = Toolkit.getDefaultToolkit().getImage("boni1.gif");
    Image img2 = Toolkit.getDefaultToolkit().getImage("boni2.gif");
    
    /**
     *
     * @param modele
     */
    public Boni(Modele modele) {
        setBackground(Color.red);        
        this.setSize(30, 27);
        this.modele = modele;
        switch(random.nextInt(2)) {
            case 0:
                boniType = "plusVie";
                break;
            case 1:
                boniType = "tirRapide";
                break;
            case 2:
                break;
            
        }
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (boniType.equals("plusVie")) {
        g.drawImage(img, 0, 0, this);
        //si boni = plus de vie, coleur = blue
        }
        if (boniType.equals("tirRapide")) {
            // si boni = tirRapide, couleur = rouge
            g.drawImage(img2, 0, 0, this);
        }
    }
    
    /**
     *
     * @param bufferedPlayer
     */
    public void applyBoni(Joueur bufferedPlayer) {
        bufferedPlayer.setPointage(bufferedPlayer.getPointage()+50);
        if ("plusVie".equals(this.boniType)) {
            bufferedPlayer.setNbVies(bufferedPlayer.getNbVies()+1);
        }
        if ("tirRapide".equals(this.boniType)) {
            modele.superVite(bufferedPlayer.getNumeroJoueur());
        }
    } // methode responsable d'appliquer le boni touche a un joueur
    
    
    
}
