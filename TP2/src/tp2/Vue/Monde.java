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

/**
 *
 * @author Bei Ning Pan et Emilien Perron
 */
public class Monde extends JPanel {

    private Modele modele;
    GameWindow gw;

    private ImageIcon planet1;
    private ImageIcon planet2;
    private ImageIcon planet3;
    private ImageIcon planet4;

    private Vaisseau joueur1;
    private Vaisseau joueur2;

    //creation des lbl pour les statistique
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
    
    static int threadCounter = 0;

    //liste utiliser pour les detections de collision
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
            while (true) { //Thread start here 
                
                threadCounter++;
                if (threadCounter % 500 == 1) {
                    spawnAsteroid(1);
                } // spawn un asteroid chaque un bout de temp
                    

                //verifier la collision entre les laser et les vaisseau
                for (int j=0;j<laser.size();j++) {
                    for (Vaisseau elemVaisseau: listVaisseau) {
                        
                        try {
                        
                        if (laser.get(j).getBounds().intersects(elemVaisseau.getBounds())) {
                            if(elemVaisseau.getJoueur()!=modele.getLaser().get(j).getJoueur()){
                            listLaserMod.add(laser.get(j));
                            removeLaserElem(laser.get(j));
                           
                           if ( modele.getLaser().get(j).getJoueur() == 1) {
                               modele.getJoueur1().setPointage(modele.getJoueur1().getPointage()+50);
                               modele.getJoueur1().setNbTirsTouche(modele.getJoueur1().getNbTirsTouche()+1);
                           }
                           if ( modele.getLaser().get(j).getJoueur() == 2) {
                               modele.getJoueur2().setPointage(modele.getJoueur2().getPointage()+50);
                               modele.getJoueur2().setNbTirsTouche(modele.getJoueur2().getNbTirsTouche()+1);
                           }
                           modele.getLaser().remove(j);
                            modele.perdreVie(elemVaisseau.getJoueur());
                        }
                           
                        }
                        
                        }
                        catch(IndexOutOfBoundsException e) {
                            System.out.println("Catch");
                            //You gotta catch 'em all
                        }
                        
                        
                    }
                }
                
                laser.removeAll(listLaserMod);
                listLaserMod.clear();
                    //
                
                
                // Collision entre laser et asteroid
                for (int j=0; j<laser.size();j++) {
                    for (int i = 0; i < listAsteroid.size(); i++) {
                        if ((laser.get(j).getBounds()).intersects(listAsteroid.get(i).getBounds())) {
                            
                            listAsteroid.get(i).setPointVie(listAsteroid.get(i).getPointVie() - 1);
                            listLaserMod.add(laser.get(j));
                           
                           if ( modele.getLaser().get(j).getJoueur() == 1) {
                               modele.getJoueur1().setPointage(modele.getJoueur1().getPointage()+50);
                               modele.getJoueur1().setNbTirsTouche(modele.getJoueur1().getNbTirsTouche()+1);
                           }
                           if ( modele.getLaser().get(j).getJoueur() == 2) {
                               modele.getJoueur2().setPointage(modele.getJoueur2().getPointage()+50);
                               modele.getJoueur2().setNbTirsTouche(modele.getJoueur2().getNbTirsTouche()+1);
                           }
                             modele.getLaser().remove(j);
                        }
                    }
                }

                for (Lasers elemLaser : listLaserMod) {

                    removeLaserElem(elemLaser);
                }
                laser.removeAll(listLaserMod); //to verify
                listLaserMod.clear();

                // creation de boni quand un asteroid est detruit
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

                // Detection de collision entre vasseau et boni
                for (Vaisseau elemVaisseau : listVaisseau) {
                    for (Boni elemBoni : listBoni) {
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

                // bouge les etoiles de fonds
                for (DrawBg elem : listEtoile) {
                    elem.moveStar();
                }
                for (DrawBg2 elem : listEtoile2) {
                    elem.moveStar();
                }
                //
                

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

    /**
     *
     * @param modele
     * @param gw
     * @throws IOException
     */
    public Monde(Modele modele, GameWindow gw) throws IOException {
        this.modele = modele;
        this.gw = gw;

        spawnAsteroid(5);

        joueur1 = new Vaisseau(modele, 1);
        joueur2 = new Vaisseau(modele, 2);
        listVaisseau.add(joueur1);
        listVaisseau.add(joueur2);

        planet1 = new ImageIcon(ImageIO.read(new File("planete1.gif")));
        planet2 = new ImageIcon(ImageIO.read(new File("planete2.gif")));
        planet3 = new ImageIcon(ImageIO.read(new File("planete3.gif")));
        planet4 = new ImageIcon(ImageIO.read(new File("planete4.gif")));

        setPreferredSize(new Dimension(800, 400));
        setBackground(Color.black);
        setLayout(null);

        //placement, couleur et taille des lbl
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
        lblnbTirJ2.setLocation(650, 120);
        lblnbTirJ2.setSize(150, 30);
        lblnbTirJ2.setForeground(Color.white);
        this.add(lblnbTirTouchJ1);
        lblnbTirTouchJ1.setLocation(0, 150);
        lblnbTirTouchJ1.setSize(160, 30);
        lblnbTirTouchJ1.setForeground(Color.white);
        this.add(lblnbTirTouchJ2);
        lblnbTirTouchJ2.setLocation(650, 150);
        lblnbTirTouchJ2.setSize(160, 30);
        lblnbTirTouchJ2.setForeground(Color.white);
        //
        
        initialiserVaisseau();

        //code pour afficher les planets en fond
        
//        JLabel lblPlanet1 = new JLabel(planet1);
//        JLabel lblPlanet2 = new JLabel(planet2);
//        JLabel lblPlanet3 = new JLabel(planet3);
//        JLabel lblPlanet4 = new JLabel(planet4);
//        this.add(lblPlanet1);
//        this.add(lblPlanet2);
//        this.add(lblPlanet3);
//        this.add(lblPlanet4);
//        lblPlanet1.setBounds(0, 0, 180, 180);
//        lblPlanet2.setBounds(0, 0, 252, 254);
//        lblPlanet3.setBounds(0, 0, 248, 254);
//        lblPlanet4.setBounds(0, 0, 349, 226);
//        lblPlanet1.setLocation(310, 320);
//        lblPlanet2.setLocation(500, 440);
//        lblPlanet3.setLocation(340, 20);
//        lblPlanet4.setLocation(0, 220);
        
        
        //placement des etoile de fond
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
        //
        

        thread.start();

        setVisible(true);

    }

    /**
     * dessin des etoile en inner class
     */
    public class DrawBg extends JComponent {

        public DrawBg() {
            this.setSize(9, 9);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.white);

            g.fillOval(2, 2, 3, 3);

        }

        /**
         * deplacement des etoile de fond
         */
        public void moveStar() {
            if (this.getX() > 800) {
                this.setLocation(0, this.getY());
            } else {
                this.setLocation(this.getX() + 3, this.getY());
            }
        }
    }

    /**
     * dessin des etoile de fond
     */
    public class DrawBg2 extends JComponent {

        public DrawBg2() {
            this.setSize(14, 14);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);

            g.setColor(Color.white);
            g.fillOval(5, 5, 5, 5);

        }

        /**
         * deplacement des etoile de fond
         */
        public void moveStar() {
            if (this.getX() > 800) {
                this.setLocation(0, this.getY());
            } else {
                this.setLocation(this.getX() + 1, this.getY());
            }
        }
    }

    /**
     * methode qui enleve un asteroid donne dans monde
     * @param elem
     */
    public void removeElem(Asteroid elem) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                Monde.this.remove(elem);
            }
        });
    }

    /**
     * methode qui enleve un laser donne dans monde
     * @param elem
     */
    public void removeLaserElem(Lasers elem) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                Monde.this.remove(elem);
            }
        });
    }

    /**
     * methode qui enleve un boni donne dans monde
     * @param boni
     */
    public void removeBoniElem(Boni boni) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                Monde.this.remove(boni);
            }
        });
    }

    /**
     * methode qui ajoute un boni donne dans monde
     * @param boni
     */
    public void addBoni(Boni boni) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                Monde.this.add(boni);
            }
        });
    }

    /**
     * methode appeler lorsque on commence un nouveau partie
     * enleve tous les asteroid et les boni du monde
     */
    public void resetField() {
        threadCounter = 0;
        
        for (Asteroid elemAsteroid : listAsteroid) {
            this.remove(elemAsteroid);
        }
        listAsteroid.clear();
        for (Boni elemBoni : listBoni) {
            this.remove(elemBoni);
        }
        listAsteroid.clear();
    }

    /**
     * spawn une nombre d'asteroid donne
     * @param nombre
     */
    public void spawnAsteroid(int nombre) {
        for (int i = 0; i < nombre; i++) {

            Asteroid ast = new Asteroid();
            this.add(ast);
            listAsteroid.add(ast);
            ast.setLocation(300, 0);
            ast.setLocation(ast.getPositionIniX(), ast.getPositionIniY());
        }
    }

    /**
     *  creation des vaisseau
     */
    public void initialiserVaisseau() {

        this.add(joueur1);
        joueur1.setLocation(modele.getJoueur1().getPositionX(), modele.getJoueur1().getPositionY());
        this.add(joueur2);
        joueur2.setLocation(modele.getJoueur2().getPositionX(), modele.getJoueur2().getPositionY());
    }

    /**
     *   modifier les position des joueurs
     */
    public void modifierJoueur() {
        joueur1.setLocation(modele.getJoueur1().getPositionX(), modele.getJoueur1().getPositionY());
        joueur2.setLocation(modele.getJoueur2().getPositionX(), modele.getJoueur2().getPositionY());
    }

    /**
     * methode pour creer et expirer les lasers
     */
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
