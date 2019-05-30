
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

public class InterfacePrincipal implements ActionListener{

    protected JFrame frame;
    protected JPanel panel;
    protected JLabel label;
    protected ImageIcon image;
    protected JButton boutton1, boutton2, boutton3;
    protected Cursor curseur;
    protected InterfacePrincipal _interface;

    public InterfacePrincipal(){

        ajouterFrame("Wargame - Menu principal", 998, 613);
        ajouterImage("img1.jpg");
        ajouterPanel(998, 613);

        curseur = new Cursor(Cursor.HAND_CURSOR);

        boutton1 = new JButton("JOUEUR VS JOUEUR");
        ajouterBoutton(boutton1, 320, 300, 300, 50, new Color(128,128,0), Color.WHITE);

        boutton2 = new JButton("JOUEUR VS IA");
        ajouterBoutton(boutton2, 320, 400, 300, 50, new Color(128,128,0), Color.WHITE);

        boutton3 = new JButton( "QUITTER");
        ajouterBoutton(boutton3, 320, 500, 300, 50, new Color(128,128,0), Color.WHITE);


    }

    protected void ajouterFrame(String titre, int largeur, int hauteur)
    {

        frame = new JFrame(titre);
        frame.setSize(largeur, hauteur);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    protected void ajouterImage(String chemin)
    {
        image = new ImageIcon(chemin);
        label = new JLabel(image);
        frame.add(label);
    }

    protected void ajouterPanel(int largeur, int hauteur)
    {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setOpaque(false);
        panel.setBounds(0, 0, largeur, hauteur);
        label.add(panel);

    }


    protected void ajouterTexte(JLabel texte, String titre, int x, int y, int largeur, int hauteur, int taille, Color couleur)
    {
        texte = new JLabel(titre);
        texte.setBounds(x, y, largeur, hauteur);
        texte.setForeground(couleur);
        texte.setFont(new Font("elephanta", Font.BOLD | Font.ITALIC, taille));
        panel.add(texte);

    }

    protected void ajouterBoutton(JButton boutton, int x, int y, int largeur, int hauteur, Color arriere_plan, Color avant_plan)
    {
        boutton.setFont(new Font("impact", Font.BOLD, 25));
        boutton.setBounds(x, y, largeur, hauteur);
        boutton.setBackground(arriere_plan);
        boutton.setForeground(avant_plan);
        boutton.setCursor(curseur);

        boutton.addActionListener(this);

        panel.add(boutton);
    }

    public void afficherFenetre(){
        frame.setVisible(true);
    }

    public void cacherFenetre(){
        frame.setVisible(false);
    }


    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object obj = event.getSource();

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
            this.cacherFenetre();
            frame.dispose();
        }




    }

}
