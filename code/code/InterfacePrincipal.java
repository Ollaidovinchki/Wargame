import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.util.ArrayList;



/**
* Cette classe représente l'interface principale à partir de laquelle,
* les utilisateurs peuvent accéder aux différentes fonctionnalités du jeu comme,
* le mode joueur vs joueur, joueur vs IA , etc ...
*
* @author  IATIC3 - Groupe 7
* @version 1.0
*
*/

public class InterfacePrincipal implements ActionListener{

    protected JFrame frame;
    protected JPanel panel;
    protected JLabel label;
    protected ImageIcon image;
    protected JButton boutton1, boutton2, boutton3, boutton4;
    protected Cursor curseur;
    protected InterfacePrincipal _interface;


    /**
    *   Constructeur de la classe InterfacePrincipal.
    */

    public InterfacePrincipal(){

        ajouterFrame("Wargame - Menu principal", 998, 613);
        ajouterImage("img/img1.jpg");
        ajouterPanel(998, 613);

        curseur = new Cursor(Cursor.HAND_CURSOR);

        boutton1 = new JButton("JOUEUR VS JOUEUR");
        ajouterBoutton(boutton1, 320, 300, 300, 40, new Color(128,128,0), Color.WHITE);

        boutton2 = new JButton("JOUEUR VS IA");
        ajouterBoutton(boutton2, 320, 350, 300, 40, new Color(128,128,0), Color.WHITE);

        boutton3 = new JButton("CHARGER UNE PARTIE");
        ajouterBoutton(boutton3, 320, 410, 300, 40, new Color(128,128,0), Color.WHITE);

        boutton4 = new JButton( "QUITTER");
        ajouterBoutton(boutton4, 320, 460, 300, 40, new Color(128,128,0), Color.WHITE);


    }


    /**
     * Cette methode permet d'ajouter un JFrame (Fenêtre principale).
     *
     * @param titre : titre de la fenêtre.
     * @param largeur : largeur de la fenêtre.
     * @param hauteur : hauteur de la fenêtre.
     * @return rien.
     */

    protected void ajouterFrame(String titre, int largeur, int hauteur)
    {
        ImageIcon icon = new ImageIcon("img/wargame.png");

        frame = new JFrame(titre);
        frame.setIconImage(icon.getImage());
        frame.setSize(largeur, hauteur);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Cette methode permet d'ajouter une image.
     *
     * @param chemin : nom ou chemin vers l'image.
     * @return rien.
     */

    protected void ajouterImage(String chemin)
    {
        image = new ImageIcon(chemin);
        label = new JLabel(image);
        frame.add(label);
    }


    /**
     * Cette methode permet d'ajouter un JPanel.
     *
     * @param largeur : largeur de la fenêtre.
     * @param hauteur : hauteur de la fenêtre.
     * @return rien.
     */

    protected void ajouterPanel(int largeur, int hauteur)
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(0, 0, largeur, hauteur);
        label.add(panel);

    }

    /**
     * Cette methode permet d'ajouter du texte.
     *
     * @param texte : instance de JLabel représentant le texte à ajouter.
     * @param titre : intitulé du texte à ajouter.
     * @param x : la position en abscisse du texte.
     * @param y : la position en ordonnée du texte.
     * @param largeur : largeur de la fenêtre.
     * @param hauteur : hauteur de la fenêtre.
     * @param taille : taille de police du texte.
     * @param couleur : couleur de police du texte.
     * @return rien.
     */

    protected void ajouterTexte(JLabel texte, int x, int y, int largeur, int hauteur, int taille, Color couleur)
    {
        texte.setBounds(x, y, largeur, hauteur);
        texte.setForeground(couleur);
        texte.setFont(new Font("elephanta", Font.BOLD | Font.ITALIC, taille));
        panel.add(texte);

    }


    /**
     * Cette methode permet d'ajouter un boutton à l'interface (JButton).
     *
     * @param boutton : instance de JButton représentant le boutton à ajouter.
     * @param x : la position en abscisse du boutton à ajouter.
     * @param y : la position en ordonnée du boutton à ajouter.
     * @param largeur : largeur de la fenêtre.
     * @param hauteur : hauteur de la fenêtre.
     * @param arriere_plan : couleur de l'arrière plan du boutton.
     * @param avant_plan : couleur de l'avant plan du boutton.
     * @return rien.
     */

    protected void ajouterBoutton(JButton boutton, int x, int y, int largeur, int hauteur, Color arriere_plan, Color avant_plan)
    {
        boutton.setFont(new Font("impact", Font.PLAIN, 25));
        boutton.setBounds(x, y, largeur, hauteur);
        boutton.setBackground(arriere_plan);
        boutton.setForeground(avant_plan);
        boutton.setCursor(curseur);

        boutton.addActionListener(this);

        panel.add(boutton);
    }

    /**
     * Cette methode permet d'afficher la fenêtre.
     *
     * @param aucun.
     * @return rien.
     */

    public void afficherFenetre(){
        frame.setVisible(true);
    }


    /**
     * Cette methode permet de cacher la fenêtre.
     *
     * @param aucun.
     * @return rien.
     */

    public void cacherFenetre(){
        frame.setVisible(false);
    }


    /**
     * Cette methode permet de charger une partie sauvegardée.
     *
     * @param aucun.
     * @return rien.
     */

    public void chargerPartie(){

        int i = 0;
        File repertoire_partie_sauvegardees;
        File[] fichiers = null;
        String[] liste_fichiers = null;
        String sauvegarde;

        repertoire_partie_sauvegardees = new File("./sauvegarde");

        if(repertoire_partie_sauvegardees.isDirectory() && repertoire_partie_sauvegardees.canRead())
        {
            fichiers = repertoire_partie_sauvegardees.listFiles();
            liste_fichiers = new String[repertoire_partie_sauvegardees.listFiles().length];

            for(File fichier : fichiers)
                if(fichier.isFile())
                {
                    liste_fichiers[i] = fichier.getName();
                    i++;
                }

            if(repertoire_partie_sauvegardees.listFiles().length == 0)
            {
                JOptionPane.showMessageDialog(frame,
                "Aucune une partie n'a ete sauvegardee",
                "Warning", JOptionPane.WARNING_MESSAGE);
            }
            else
            {
                sauvegarde = JOptionPane.showInputDialog(frame,
                         "Veuiller selectionner la sauvegarde a charger \n",
                         "Charger une partie",
                         JOptionPane.PLAIN_MESSAGE, null,
                         liste_fichiers, "choix de la sauvegarde").toString();

                File fichier = new File("./sauvegarde" + sauvegarde);

                try{
                    ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(fichier)) ;
                    //Plateau plateau =(Plateau)ois.readObject();
                    String s2 = (String)ois.readObject();
                    ois.close();
                }
                catch(IOException | ClassNotFoundException e)
                {
                    JOptionPane.showMessageDialog(frame,
                    "Fichier introuvable",
                    "Warning", JOptionPane.WARNING_MESSAGE);
                }


            }
        }

    }

    /**
     * Cette methode traite et exécute les actions des joueurs.
     *
     * @param evenement : ce paramètre permet d'identifier l'action des joueurs.
     * @return rien.
     */

    @Override
    public void actionPerformed(ActionEvent evenement)
    {
        Object obj = evenement.getSource();

        if(obj == boutton1)
        {

            _interface = new InterfaceCreationEquipe1();
            _interface.afficherFenetre();

            this.cacherFenetre();
            frame.dispose();

        }
        if(obj == boutton2)
        {
        }
        if(obj == boutton3)
        {
            chargerPartie();
        }
        if(obj == boutton4)
        {
            this.cacherFenetre();
            frame.dispose();
        }




    }

}
