/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JComponent;
import tp2.modele.Joueur.Orientation;



public class Lasers extends JComponent {

    private Orientation orientation;
    
    
        public Lasers(Orientation orientation) {
            this.orientation=orientation;
            this.setSize(64,64);
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
                x1=new int[]{30,34,34,30};
                y1=new int[]{0,0,this.getHeight(),this.getHeight()};
                g.fillPolygon(x1, y1, 4);
                break;
                case LEFT:
                case RIGHT:
                x1=new int[]{0,this.getWidth(),this.getWidth(),0};
                y1=new int[]{30,34,34,30};
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
               
            }
          
             
          
       }
   }
