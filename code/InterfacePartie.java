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

    protected JLabel label_wargame;
    protected JLabel pseudo_joueur1, unite_joueur1, label_unite_joueur1,
                     label_PV_joueur1, label_attaque_joueur1,
                     label_defense_joueur1, label_depl_joueur1,
                     label_vision_joueur1;
    protected JLabel pseudo_joueur2, unite_joueur2, label_unite_joueur2,
                     label_PV_joueur2, label_attaque_joueur2,
                     label_defense_joueur2, label_depl_joueur2,
                     label_vision_joueur2;
    protected ImageIcon image_unite1, image_unite2;
    protected Plateau plateau;
    protected ListeUnite l_u;
    protected Controlleur controleur;


    public InterfacePartie(String pseudo1, String pseudo2, String equipe1,
                           String equipe2, int mode_jeu)
    {

        //boutton3 = new JButton("CHARGER UNE PARTIE");
        //ajouterBoutton(boutton3, 320, 410, 300, 40, new Color(128,128,0), Color.WHITE);


        Dimension dimension_image;

        l_u = new ListeUnite();

        plateau = new Plateau(new ListeTerrain());
        plateau.setEquipes(new Equipe(1), new Equipe(2));
        plateau.getEquipe1().CreationEquipe(l_u.getListe(), getIDUnite(equipe1));
        plateau.getEquipe2().CreationEquipe(l_u.getListe(), getIDUnite(equipe2));
        plateau.PlaceEquipe(plateau.getEquipe1(),plateau.getEquipe2());

        controleur = new Controlleur();

        ajouterFrame("Wargame - Jeu", 1400, 900);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().addMouseListener(this);
        super.ajouterImage("img/plateau.jpg");
        ajouterPanel(1400, 900);


        boutton1 = new JButton("Sauvegarder");
        ajouterBoutton(boutton1, 330, 800, 200, 30, new Color(128,128,0), Color.WHITE);

        boutton2 = new JButton("Aide");
        ajouterBoutton(boutton2, 900, 800, 200, 30, new Color(128,128,0), Color.WHITE);

        label_wargame = new JLabel("WARGAME");
        ajouterTexte(label_wargame, 550,0, 300, 100, 50, Color.BLACK);

        pseudo_joueur1 = new JLabel("Nom : " + pseudo1);
        unite_joueur1 = new JLabel("Unite : " + equipe1);
        image_unite1 = new ImageIcon(getCheminImageUnite(equipe1));
        label_unite_joueur1 = new JLabel(image_unite1);
        dimension_image = label_unite_joueur1.getPreferredSize();
        label_PV_joueur1 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe1)).getPV());
        label_attaque_joueur1 = new JLabel("P. attaque : " + l_u.getListe().get(getIDUnite(equipe1)).getP_att());
        label_defense_joueur1 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe1)).getP_def());
        label_depl_joueur1 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe1)).getDepl());
        label_vision_joueur1 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe1)).getVision());

        ajouterInfoJoueur(pseudo_joueur1, unite_joueur1, label_unite_joueur1,
                          label_PV_joueur1, label_attaque_joueur1, label_defense_joueur1,
                          label_depl_joueur1, label_vision_joueur1, 1, 98, 1, 118, 10, 80,
                          1, 138, 1, 158, 1, 178, 1, 198, 1, 226,dimension_image.width,
                          dimension_image.height);


         pseudo_joueur2 = new JLabel("Nom : " + pseudo2);
         unite_joueur2 = new JLabel("Unite : " + equipe2);
         image_unite2 = new ImageIcon(getCheminImageUnite(equipe2));
         label_unite_joueur2 = new JLabel(image_unite2);
         dimension_image = label_unite_joueur2.getPreferredSize();
         label_PV_joueur2 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe2)).getPV());
         label_attaque_joueur2 = new JLabel("P. attaque : " + l_u.getListe().get(getIDUnite(equipe2)).getP_att());
         label_defense_joueur2 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe2)).getP_def());
         label_depl_joueur2 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe2)).getDepl());
         label_vision_joueur2 = new JLabel("PV : " + l_u.getListe().get(getIDUnite(equipe2)).getVision());

          ajouterInfoJoueur(pseudo_joueur2, unite_joueur2, label_unite_joueur2,
                            label_PV_joueur2, label_attaque_joueur2, label_defense_joueur2,
                            label_depl_joueur2, label_vision_joueur2, 1150, 98, 1150, 118,
                            1150, 80, 1150, 138, 1150, 158, 1150, 178, 1150, 198, 1150, 226,
                            dimension_image.width, dimension_image.height);

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
                                   JLabel label_unite_joueur, JLabel label_PV_joueur,
                                   JLabel label_attaque_joueur, JLabel label_defense_joueur,
                                   JLabel label_depl_joueur, JLabel label_vision_joueur,
                                   int x1, int y1, int x2, int y2, int x3, int y3, int x4, int y4,
                                   int x5, int y5, int x6, int y6, int x7, int y7,
                                   int x8, int y8, int largeur, int hauteur)
    {
        ajouterTexte(pseudo_joueur, x1, y1, 100, 100, 13, Color.BLACK);
        ajouterTexte(unite_joueur, x2, y2, 100, 100, 13, Color.BLACK);
        ajouterTexte(label_PV_joueur, x4, y4, 100, 100, 13, Color.BLACK);
        ajouterTexte(label_attaque_joueur, x5, y5, 100, 100, 13, Color.BLACK);
        ajouterTexte(label_defense_joueur, x6, y6, 100, 100, 13, Color.BLACK);
        ajouterTexte(label_depl_joueur, x7, y7, 100, 100, 13, Color.BLACK);
        ajouterTexte(label_vision_joueur, x8, y8, 100, 100, 13, Color.BLACK);

        label_unite_joueur.setBounds(x3, y3, largeur, hauteur);
        panel.add(label_unite_joueur);
    }


    private int getIDUnite(String unite)
    {
        if(unite.equals("I. legere"))
            return 0;
		if(unite.equals("I. lourde"))
            return 1;
		if(unite.equals("Chevalier"))
            return 2;
		if(unite.equals("Mage"))
	       return 3;
	    if(unite.equals("Archer"))
            return 4;

        return -1;
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
            return "img/village.png";
        else
            return (String) null;
    }


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
        int[] coord_matrice = controleur.ConvertirCoordonneesEnCase(e.getX(), e.getY());
        System.out.println("ligne : " + coord_matrice[0] + " \n colonne : " + coord_matrice[1]);
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
