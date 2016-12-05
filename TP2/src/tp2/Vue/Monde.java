/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2.Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import tp2.modele.Asteroid;
import tp2.modele.Boni;
import tp2.modele.Modele;

public class Monde extends JPanel {

    private Modele modele;
    GameWindow gw;
    

    private ImageIcon planet1;
    private ImageIcon planet2;
    private ImageIcon planet3;
    private ImageIcon planet4;

    private Vaisseau joueur1;
    private Vaisseau joueur2;

    static JLabel lblJ1 = new JLabel("--Joueur 1--");
    static JLabel lblJ2 = new JLabel("--Joueur 2--");
    static JLabel lblVieJ1 = new JLabel("Point de Vie: 0");
    static JLabel lblVieJ2 = new JLabel("Point de Vie: 0");
    static JLabel lblPointJ1 = new JLabel("Pointage: 0");
    static JLabel lblPointJ2 = new JLabel("Pointage: 0");
    static JLabel lblnbVicJ1 = new JLabel("Nombre de Victoire: 0");
    static JLabel lblnbVicJ2 = new JLabel("Nombre de Victoire: 0");
    static JLabel lblnbTirJ1 = new JLabel("Nombre de laser tiré : 0");
    static JLabel lblnbTirJ2 = new JLabel("Nombre de laser tiré : 0");
    static JLabel lblnbTirTouchJ1 = new JLabel("Nombre de laser touché : 0");
    static JLabel lblnbTirTouchJ2 = new JLabel("Nombre de laser touché : 0");
    

    private static ArrayList<Lasers> laser = new ArrayList();
    private static ArrayList<Lasers> listLaserMod = new ArrayList();
    private static ArrayList<DrawBg> listEtoile = new ArrayList();
    private static ArrayList<DrawBg2> listEtoile2 = new ArrayList();
    private static ArrayList<Asteroid> listAsteroid = new ArrayList();
    private static ArrayList<Asteroid> listAsteroidMod = new ArrayList();
    private static ArrayList<Boni> listBoni = new ArrayList();
    private static ArrayList<Boni> listBoniMod = new ArrayList();
    private static ArrayList<Vaisseau> listVaisseau = new ArrayList();

    Thread thread = new Thread() {
        @Override
        public void run() {
            while (true) {

                //
                for (Lasers elemLaser : laser) {
                    for (int i = 0; i < listAsteroid.size(); i++) {

                        if (elemLaser.getBounds().intersects(listAsteroid.get(i).getBounds())) {
                            listAsteroid.get(i).setPointVie(listAsteroid.get(i).getPointVie() - 1);
                            listLaserMod.add(elemLaser);
                        }
                    }
                }

                for (Lasers elemLaser : listLaserMod) {
                    
                    removeLaserElem(elemLaser);
                }
                laser.removeAll(listLaserMod); //to verify
                listLaserMod.clear();
                
                //

                for (Asteroid elem : listAsteroid) {
                    elem.bouger();
                    if (elem.getPointVie() <= 0) {
                        Boni boni = new Boni(modele);
                        boni.setLocation(elem.getX(), elem.getY());
                        removeElem(elem);
                        listAsteroidMod.add(elem);
                        listBoni.add(boni);
                        addBoni(boni);
                        revalidate();
                        repaint();

                    }
                }

                listAsteroid.removeAll(listAsteroidMod);
                listAsteroidMod.clear();

                //
                for (Vaisseau elemVaisseau: listVaisseau) {
                    for (Boni elemBoni: listBoni) {
                        if (elemVaisseau.getBounds().intersects(elemBoni.getBounds())) {
                            listBoniMod.add(elemBoni);
                            removeBoniElem(elemBoni);
                            if (elemVaisseau.getJoueur() == 1) {
                            elemBoni.applyBoni(modele.getJoueur1());
                            }
                            if (elemVaisseau.getJoueur() == 2) {
                                elemBoni.applyBoni(modele.getJoueur2());
                            }
                        }
                        
                        
                    }
                }
                //
                listBoni.removeAll(listBoniMod);
                listBoniMod.clear();
                
                //
                
                for (DrawBg elem : listEtoile) {
                    elem.moveStar();
                }
                for (DrawBg2 elem : listEtoile2) {
                    elem.moveStar();
                }

                if (gw.getTouchesPesees().contains('w')) {
                    modele.avancer1();
                }
                if (gw.getTouchesPesees().contains('s')) {
                    modele.reculer1();
                }
                if (gw.getTouchesPesees().contains('a')) {
                    modele.tournerGauche1();
                }
                if (gw.getTouchesPesees().contains('d')) {
                    modele.tournerDroite1();
                }
                if (gw.getTouchesPesees().contains('8')) {
                    modele.avancer2();
                }
                if (gw.getTouchesPesees().contains('5')) {
                    modele.reculer2();
                }
                if (gw.getTouchesPesees().contains('4')) {
                    modele.tournerGauche2();
                }
                if (gw.getTouchesPesees().contains('6')) {
                    modele.tournerDroite2();
                }
                if (gw.getTouchesPesees().contains(' ')) {
                    modele.tirer1();
                }
                if (gw.getTouchesPesees().contains('0')) {
                    modele.tirer2();
                }

                modele.bouger();
                try {
                    Thread.sleep(25);
                    modele.maj();
                } catch (InterruptedException ex) {

                }
            }
        }
    };

    public Monde(Modele modele, GameWindow gw) throws IOException {
        this.modele = modele;
        this.gw = gw;
        
       

        spawnAsteroid();

        joueur1= new Vaisseau(modele,1);
        joueur2= new Vaisseau(modele,2);
        listVaisseau.add(joueur1);
        listVaisseau.add(joueur2);
        for (int i = 0; i < 10; i++) {

            Asteroid ast = new Asteroid();
            this.add(ast);
            listAsteroid.add(ast);
            ast.setLocation(300, 0);
            ast.setLocation(ast.getPositionIniX(), ast.getPositionIniY());
        }


        planet1 = new ImageIcon(ImageIO.read(new File("planete1.gif")));
        planet2 = new ImageIcon(ImageIO.read(new File("planete2.gif")));
        planet3 = new ImageIcon(ImageIO.read(new File("planete3.gif")));
        planet4 = new ImageIcon(ImageIO.read(new File("planete4.gif")));

        
        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.black);
        setLayout(null);

        this.add(lblJ1);
        lblJ1.setLocation(0, 0);
        lblJ1.setSize(100, 30);
        lblJ1.setForeground(Color.white);
        this.add(lblJ2);
        lblJ2.setLocation(650, 0);
        lblJ2.setSize(100, 30);
        lblJ2.setForeground(Color.white);
        this.add(lblVieJ1);
        lblVieJ1.setLocation(0, 30);
        lblVieJ1.setSize(100, 30);
        lblVieJ1.setForeground(Color.white);
        this.add(lblVieJ2);
        lblVieJ2.setLocation(650, 30);
        lblVieJ2.setSize(100, 30);
        lblVieJ2.setForeground(Color.white);
        this.add(lblPointJ1);
        lblPointJ1.setLocation(0, 60);
        lblPointJ1.setSize(100, 30);
        lblPointJ1.setForeground(Color.white);
        this.add(lblPointJ2);
        lblPointJ2.setForeground(Color.white);
        lblPointJ2.setSize(100, 30);
        lblPointJ2.setLocation(650, 60);
        this.add(lblnbVicJ1);
        lblnbVicJ1.setLocation(0, 90);
        lblnbVicJ1.setSize(150, 30);
        lblnbVicJ1.setForeground(Color.white);
        this.add(lblnbVicJ2);
        lblnbVicJ2.setLocation(650, 90);
        lblnbVicJ2.setSize(150, 30);
        lblnbVicJ2.setForeground(Color.white);
        this.add(lblnbTirJ1);
        lblnbTirJ1.setLocation(0, 120);
        lblnbTirJ1.setSize(150, 30);
        lblnbTirJ1.setForeground(Color.white);
        this.add(lblnbTirJ2);
        lblnbTirJ2.setLocation(0, 150);
        lblnbTirJ2.setSize(150, 30);
        lblnbTirJ2.setForeground(Color.white);
        this.add(lblnbTirTouchJ1);
        lblnbTirTouchJ1.setLocation(650, 120);
        lblnbTirTouchJ1.setSize(160, 30);
        lblnbTirTouchJ1.setForeground(Color.white);
        this.add(lblnbTirTouchJ2);
        lblnbTirTouchJ2.setLocation(650, 150);
        lblnbTirTouchJ2.setSize(160, 30);
        lblnbTirTouchJ2.setForeground(Color.white);

        initialiserVaisseau();

        JLabel lblPlanet1 = new JLabel(planet1);
        JLabel lblPlanet2 = new JLabel(planet2);
        JLabel lblPlanet3 = new JLabel(planet3);
        JLabel lblPlanet4 = new JLabel(planet4);
        this.add(lblPlanet1);
        this.add(lblPlanet2);
        this.add(lblPlanet3);
        this.add(lblPlanet4);
        lblPlanet1.setBounds(0, 0, 180, 180);
        lblPlanet2.setBounds(0, 0, 252, 254);
        lblPlanet3.setBounds(0, 0, 248, 254);
        lblPlanet4.setBounds(0, 0, 349, 226);
        lblPlanet1.setLocation(310, 320);
        lblPlanet2.setLocation(500, 440);
        lblPlanet3.setLocation(340, 20);
        lblPlanet4.setLocation(0, 220);

        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            DrawBg drawBg = new DrawBg();
            this.add(drawBg);
            listEtoile.add(drawBg);
            drawBg.setLocation(1 * random.nextInt(800), 1 * random.nextInt(500));
        }

        for (int i = 0; i < 50; i++) {
            DrawBg2 drawBg2 = new DrawBg2();
            this.add(drawBg2);
            listEtoile2.add(drawBg2);
            drawBg2.setLocation(1 * random.nextInt(800), 1 * random.nextInt(500));
        }

        thread.start();

        setVisible(true);

    }

    public class DrawBg extends JComponent {

        public DrawBg() {
            this.setSize(9, 9);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.white);
//           g.fillOval(3, 3, 5, 5);
            g.fillOval(2, 2, 3, 3);

        }

        public void moveStar() {
            if (this.getX() > 800) {
                this.setLocation(0, this.getY());
            } else {
                this.setLocation(this.getX() + 3, this.getY());
            }
        }
    }

    public class DrawBg2 extends JComponent {

        public DrawBg2() {
            this.setSize(14, 14);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.white);
            g.fillOval(5, 5, 5, 5);
//           g.fillOval(2, 2, 3, 3);

        }

        public void moveStar() {
            if (this.getX() > 800) {
                this.setLocation(0, this.getY());
            } else {
                this.setLocation(this.getX() + 1, this.getY());
            }
        }
    }

    
    
    public void removeElem(Asteroid elem) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        
        Monde.this.remove(elem);
             }
        });
    }

    public void removeLaserElem(Lasers elem) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        
        Monde.this.remove(elem);
             }
        });
    }
    
    public void removeBoniElem(Boni boni) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        
        Monde.this.remove(boni);
             }
        });
    }

    public void addBoni(Boni boni) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
        
        Monde.this.add(boni);
             }
        });
    }
    
    public void resetField() {
        for (Asteroid elemAsteroid: listAsteroid) {
            this.remove(elemAsteroid);
        }
        listAsteroid.clear();
        for (Boni elemBoni: listBoni) {
            this.remove(elemBoni);
        }
        listAsteroid.clear();
    }
    
    public void spawnAsteroid() {
        for (int i = 0; i < 10; i++) {

            Asteroid ast = new Asteroid();
            this.add(ast);
            listAsteroid.add(ast);
            ast.setLocation(300, 0);
            ast.setLocation(ast.getPositionIniX(), ast.getPositionIniY());
        }
    }

    public void initialiserVaisseau() {
        
        this.add(joueur1);
        joueur1.setLocation(modele.getJoueur1().getPositionX(), modele.getJoueur1().getPositionY());
        this.add(joueur2);
        joueur2.setLocation(modele.getJoueur2().getPositionX(), modele.getJoueur2().getPositionY());
    }

    public void modifierJoueur() {
        joueur1.setLocation(modele.getJoueur1().getPositionX(), modele.getJoueur1().getPositionY());
        joueur2.setLocation(modele.getJoueur2().getPositionX(), modele.getJoueur2().getPositionY());
    }

    public void modifierLaser() {
        for (int i = 0; i < laser.size(); i++) {
            this.remove(laser.get(i));
        }

        laser.clear();
        for (int i = 0; i < modele.getLaser().size(); i++) {

            Lasers drawLaser = new Lasers(modele.getLaser().get(i).getOrientation());
            laser.add(drawLaser);
            this.add(drawLaser);
        }
        for (int i = 0; i < laser.size(); i++) {
            laser.get(i).setLocation(modele.getLaser().get(i).getPositionX(), modele.getLaser().get(i).getPositionY());
        }
        
    }

   

}
