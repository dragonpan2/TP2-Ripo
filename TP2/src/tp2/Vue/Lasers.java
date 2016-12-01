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

    private int orientation;
    private boolean diagoDroite=false;
    private boolean diagoGauche=false;
    
    
        public Lasers(Orientation orientation) {
            switch (orientation){
                case TOP:
                case DOWN:this.setSize(5, 40);
                break;
                case LEFT:
                case RIGHT:this.setSize(40, 5);
                break;
                case TOPLEFT:
                case DOWNRIGHT:this.setSize(40,40);
                diagoGauche=true;
                break;
                case TOPRIGHT:
                case DOWNLEFT:this.setSize(40,40);
                diagoDroite=true;
                break; 
               
            }
            
        }
       
       
       
       @Override
       public void paintComponent(Graphics g) {
          super.paintComponent(g);
          g.setColor(Color.red);
          if(diagoGauche){
              int[]x1={0,4,this.getWidth(),this.getWidth()-4};
              int[]y1={4,0,this.getHeight()-4,this.getHeight()};
              g.fillPolygon(x1, y1, 4);
          }
          else if(diagoDroite){
              int[]x1={0,4,this.getWidth(),this.getWidth()-4};
              int[]y1={this.getHeight()-4,this.getHeight(),4,0};
              g.fillPolygon(x1, y1, 4);
          }
          else{
             g.fillRect(0, 0, this.getWidth(),this.getHeight()); 
          }
          
       }
   }
