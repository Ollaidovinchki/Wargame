import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.util.Map;
import java.awt.Graphics;
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


    public InterfacePartie(String pseudo1, String pseudo2, String equipe1, String equipe2, int mode_jeu){


        //JLabel pseudo_joueur2;

        ajouterFrame("Wargame - Jeu", 1400, 900);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.getContentPane().addMouseListener(this);
        ajouterImage("img/plateau.jpg");
        ajouterPanel(1400, 900);

        JLabel pseudo_joueur1 = new JLabel("Joueur 1 :");
        ajouterTexte(pseudo_joueur1, 1, 98, 100, 100, 15, Color.BLACK);

        



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
