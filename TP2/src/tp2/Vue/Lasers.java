package tp2.Vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import tp2.modele.Joueur.Orientation;

/**
 *
 * @author Bei Ning Pan et Emilien Perron
 */
public class Lasers extends JComponent {

    private Orientation orientation;
    
    /**
     *
     * @param orientation l'orientation du laser
     */
    public Lasers(Orientation orientation) {
            this.orientation=orientation;
            this.setSize(40,40);
        }
       
       
       
       @Override
       public void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.setColor(Color.red);
          int[]x1;
          int[]y1;
          switch (orientation){
                case TOP:
                case DOWN:
                x1=new int[]{this.getWidth()/2-2,this.getWidth()/2+2,this.getWidth()/2+2,this.getWidth()/2-2};
                y1=new int[]{0,0,this.getHeight(),this.getHeight()};
                g.fillPolygon(x1, y1, 4);
                break;
                case LEFT:
                case RIGHT:
                x1=new int[]{0,this.getWidth(),this.getWidth(),0};
                y1=new int[]{this.getHeight()/2-2,this.getHeight()/2-2,this.getHeight()/2+2,this.getHeight()/2+2};
                g.fillPolygon(x1, y1, 4);
                break;
                case TOPLEFT:
                case DOWNRIGHT:
                x1=new int[]{0,4,this.getWidth(),this.getWidth()-4};
                y1=new int[]{4,0,this.getHeight()-4,this.getHeight()};
                g.fillPolygon(x1, y1, 4);
                break;
                case TOPRIGHT:
                case DOWNLEFT:
                x1=new int[]{0,4,this.getWidth(),this.getWidth()-4};
                y1=new int[]{this.getHeight()-4,this.getHeight(),4,0};
                g.fillPolygon(x1, y1, 4);
                break; 
               //
            }
          
             
          
       }
   }
