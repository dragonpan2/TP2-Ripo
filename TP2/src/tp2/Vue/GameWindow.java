package tp2.Vue;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import tp2.Controleur.Controleur;
import tp2.modele.Modele;

/**
 *
 * @author 1566086
 */
public class GameWindow extends JFrame implements Observer {

    private static Controleur controleur;
    private static Modele modele;

    Monde monde;

    //initialisation des objet du menu
    private JMenuBar menu = new JMenuBar();
    private JMenu mnFichier = new JMenu("Fichier");
    private JMenu mnAide = new JMenu("Aide");
    private JMenuItem mnItemNouvellePartie = new JMenuItem("NouvellePartie");
    private JMenuItem mnItemQuitter = new JMenuItem("Quitter");
    private JMenuItem mnItemAide = new JMenuItem("Aide");
    //

    //
    private static ArrayList<Character> touchesPesees = new ArrayList();

    private static KeyListener kl = new KeyListener() {
        @Override
        public void keyTyped(KeyEvent e) {

        }

        @Override
        public void keyPressed(KeyEvent e) {

            if (!(touchesPesees.contains(e.getKeyChar()))) {
                touchesPesees.add(e.getKeyChar());
            }

        }

        @Override
        public void keyReleased(KeyEvent e) {
            if (touchesPesees.contains(e.getKeyChar())) {
                touchesPesees.remove((Character) e.getKeyChar());
            }

        }
    };

    /**
     *
     * @param controleur
     * @param observable
     * @throws IOException
     * constructeur du gameWindow
     * inclu les code pour MVC et la taille du jeu
     */
    public GameWindow(Controleur controleur, Observable observable) throws IOException {

        this.modele = (Modele) observable;
        modele.addObserver(this);
        this.monde = new Monde(modele, this);
        this.controleur = controleur;

        this.addKeyListener(kl);
        menus();

        this.add(monde);
        this.pack();
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);

    }

    /**
     *    methode responsable de lajoute des menus
     */
    public void menus() {
        mnFichier.add(mnItemNouvellePartie);
        mnFichier.addSeparator();
        mnFichier.add(mnItemQuitter);
        menu.add(mnFichier);
        menu.add(mnAide);
        mnAide.add(mnItemAide);
        eventQuitter();
        eventAide();
        eventNouvellePartie();
        setJMenuBar(menu);
    }

    /**
     * code execute lors quon appuis sur le menu quitter
     */
    public void eventQuitter() {
        mnItemQuitter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);

            }

        });
    }

    /**
     * code execute lors quon appuis sur le menu aide
     */
    public void eventAide() {
        mnItemAide.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Emilien, Bei Ning, date final du Build: 2016-12-07", "Aide", JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    /**
     *     code execute lors quon apuis sur nouvelle partie
     */
    public void eventNouvellePartie() {
        mnItemNouvellePartie.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nouvellePartie();
            }
        });
    }

    /**
     *
     * @return les touche pesees a execute
     */
    public static ArrayList<Character> getTouchesPesees() {
        return touchesPesees;
    }

    /**
     * Mis a jour des statistique en temps reel
     */
    public void infos() {
        int nbVieP1 = modele.getJoueur1().getNbVies();
        int nbVieP2 = modele.getJoueur2().getNbVies();
        int pointP1 = modele.getJoueur1().getPointage();
        int pointP2 = modele.getJoueur2().getPointage();
        int nbVicP1 = modele.getJoueur1().getNbVictoire();
        int nbVicP2 = modele.getJoueur2().getNbVictoire();
        int nbTirP1 = modele.getJoueur1().getNbTirs();
        int nbTirP2 = modele.getJoueur2().getNbTirs();
        int nbTirTouchP1 = modele.getJoueur1().getNbTirsTouche();
        int nbTirTouchP2 = modele.getJoueur2().getNbTirsTouche();
        //set graphical change here

        //
        Monde.lblVieJ1.setText("Point de Vie: " + Integer.toString(nbVieP1));
        Monde.lblVieJ2.setText("Point de Vie: " + Integer.toString(nbVieP2));
        Monde.lblPointJ1.setText("Pointage: " + Integer.toString(pointP1));
        Monde.lblPointJ2.setText("Pointage: " + Integer.toString(pointP2));
        Monde.lblnbVicJ1.setText("Nombre de Victoire: "+Integer.toString(nbVicP1));
        Monde.lblnbVicJ2.setText("Nombre de Victoire: "+Integer.toString(nbVicP2));
        Monde.lblnbTirJ1.setText("Nombre de laser tiré : "+Integer.toString(nbTirP1));
        Monde.lblnbTirJ2.setText("Nombre de laser tiré : "+Integer.toString(nbTirP2));
        Monde.lblnbTirTouchJ1.setText("Nombre de laser touché : "+Integer.toString(nbTirTouchP1));
        Monde.lblnbTirTouchJ2.setText("Nombre de laser touché : "+Integer.toString(nbTirTouchP2));
    }

    @Override
    public void update(Observable o, Object o1) {
        Modele modele = (Modele) o;
        infos();
        if (modele.getPartieFinie()){
            nouvellePartie();
            modele.setPartieFinie(false);
        }
        monde.modifierJoueur();
        monde.modifierLaser();
        monde.revalidate();
        monde.repaint();
    }

    /**
     *tous les methode necessaire a apelle pour un nouvelle partie fonctionel
     */
    public void nouvellePartie(){
        modele.resetPartie();
        monde.resetField();
        monde.spawnAsteroid(5);
    } 
}
