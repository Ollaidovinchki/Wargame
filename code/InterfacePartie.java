import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.Point;
import javax.swing.JOptionPane;



/**
* Cette classe correspond à la classe à partir de laquelle, le jeu est exécuté.
*
* @author  IATIC3 - Groupe 7
* @version 1.0
*
*/


public class InterfacePartie extends InterfacePrincipal implements ActionListener, MouseListener {


    protected JLabel pseudo_joueur1, unite_joueur1, label_unite_joueur1;
    protected JLabel pseudo_joueur2, unite_joueur2, label_unite_joueur2;
    protected ImageIcon image_unite1, image_unite2;
    protected Plateau plateau;
    protected Controlleur controleur;


    public InterfacePartie(String pseudo1, String pseudo2, String equipe1,
                           String equipe2, int mode_jeu)
    {

        Dimension dimension_image;
        plateau = new Plateau(new ListeTerrain());
        controleur = new Controlleur();

        ajouterFrame("Wargame - Jeu", 1400, 900);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().addMouseListener(this);
        //super.ajouterImage("img/plateau.jpg");
        ajouterPanel(1400, 900);

        pseudo_joueur1 = new JLabel("Nom : " + pseudo1);
        unite_joueur1 = new JLabel("Unite : " + equipe1);
        image_unite1 = new ImageIcon(getCheminImageUnite(equipe1));
        label_unite_joueur1 = new JLabel(image_unite1);
        dimension_image = label_unite_joueur1.getPreferredSize();
        ajouterInfoJoueur(pseudo_joueur1, unite_joueur1, label_unite_joueur1,
                          1, 98, 1, 125, 100, 225, dimension_image.width,
                          dimension_image.height);



        pseudo_joueur2 = new JLabel("Nom : " + pseudo2);
        ajouterTexte(pseudo_joueur2, 1200, 98, 100, 100, 15, Color.BLACK);


        afficherPlateau();



    }



    private void afficherPlateau()
    {

        ImageIcon image_terrain;
        JLabel label_terrain ;
        Dimension dimensions;
        int[] points;

        for(int i=0; i<plateau.getNombreLigne(); i++)
            for(int j=0; j<plateau.getNombreColonne(); j++)
                {
                    points = controleur.ConvertirCaseEnPoint(i,j);
                    image_terrain = new ImageIcon(getCheminImageTerrain(plateau.getTerrains()[i][j]));
                    label_terrain = new JLabel(image_terrain);
                    dimensions = label_terrain.getPreferredSize();
                    label_terrain.setBounds(points[0], points[1], dimensions.width, dimensions.height);
                    panel.add(label_terrain);
                }
    }

    private void ajouterInfoJoueur(JLabel pseudo_joueur, JLabel unite_joueur,
                                   JLabel label_unite_joueur, int x1, int y1,
                                   int x2, int y2, int x3, int y3, int largeur,
                                   int hauteur)
    {
        ajouterTexte(pseudo_joueur, x1, y1, 100, 100, 13, Color.BLACK);
        ajouterTexte(unite_joueur, x2, y2, 100, 100, 13, Color.BLACK);

        label_unite_joueur.setBounds(x3, y3, largeur, hauteur);
        panel.add(label_unite_joueur);
    }


    private String getCheminImageUnite(String unite)
    {
        if(unite != null)
        {
            if(unite.equals("Archer"))
                return "img/archer.png";
            if(unite.equals("I. legere"))
                return "img/i_leger.png";
            if(unite.equals("I. lourde"))
                return "img/i_lourd.png";
            if(unite.equals("Mage"))
                return "img/mage.png";
            if(unite.equals("Chevalier"))
                return "img/chevalier.png";
        }

        return (String) null;

    }


    private String getCheminImageTerrain(Case_hexagonales c)
    {
        if(c instanceof Colline)
            return "img/colline.png";
        else if(c instanceof Eau_profonde)
            return "img/eau.png";
        else if(c instanceof Foret)
            return "img/foret.png";
        else if(c instanceof Forteresse)
            return "img/forteresse.png";
        else if(c instanceof Montagne)
            return "img/montagne.png";
        else if(c instanceof Plaine)
            return "img/plaine.png";
        else if(c instanceof Village)
            return "img/villag.png";
        else
            return (String) null;
    }

    /*public void ajouterImage()
    {

        BufferedImage image = ImageIO.read(new File("./java.jpg"));
        JLabel label = new JLabel(new ImageIcon(image));
        panel.add(label);

        // main window
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("JPanel Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // add the Jpanel to the main window
        frame.add(panel);

        frame.pack();
        frame.setVisible(true);
    }*/

    @Override
    public void mousePressed(MouseEvent e)
    {


    }


    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }


    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println("x : " + e.getX() + " \n y : " + e.getY());
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

        }

    }

}
