import java.awt.Choice;
import java.awt.Color;
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
import javax.swing.JOptionPane;



public class InterfaceCreationEquipe1 extends InterfacePrincipal implements ActionListener {

    private CheckboxGroup checkboxgroup1, checkboxgroup2;
    private Checkbox[] checkboxs;
    protected JTextField pseudo1, pseudo2;

    public InterfaceCreationEquipe1(){

        checkboxgroup1 = new CheckboxGroup();
        checkboxgroup2 = new CheckboxGroup();

        checkboxs = new Checkbox[10];

        ajouterFrame("Wargame - Creation equipes", 998, 613);
		ajouterImage("img2.jpg");
        ajouterPanel(998, 613);

        ajouterCheckbox(new Checkbox("Archer", checkboxgroup1, true), 25, 430, 60, 50, 0);
        ajouterCheckbox(new Checkbox("I. legere", checkboxgroup1, false), 100, 430, 70, 50, 1);
        ajouterCheckbox(new Checkbox("I. lourde", checkboxgroup1, false), 195, 430, 70, 50, 2);
        ajouterCheckbox(new Checkbox("Mage", checkboxgroup1, false), 300, 430, 50, 50, 3);
        ajouterCheckbox(new Checkbox("Chevalier", checkboxgroup1, false), 380, 430, 70, 50, 4);

        ajouterCheckbox(new Checkbox("Archer", checkboxgroup2, true), 540, 430, 60, 50, 5);
        ajouterCheckbox(new Checkbox("I. legere", checkboxgroup2, false), 620, 430, 70, 50, 6);
        ajouterCheckbox(new Checkbox("I. lourde", checkboxgroup2, false), 715, 430, 70, 50, 7);
        ajouterCheckbox(new Checkbox("Mage", checkboxgroup2, false), 810, 430, 50, 50, 8);
        ajouterCheckbox(new Checkbox("Chevalier", checkboxgroup2, false), 890, 430, 70, 50, 9);

        pseudo1 = new JTextField();
        ajouterTextField(pseudo1, 540, 110, 250, 50);

        pseudo2 = new JTextField();
        ajouterTextField(pseudo2, 540, 170, 250, 50);

        curseur = new Cursor(Cursor.HAND_CURSOR);

        boutton1 = new JButton("Valider");
        ajouterBoutton(boutton1, 850, 150, 120, 30, Color.BLACK, Color.WHITE);

    }

    private void ajouterCheckbox(Checkbox checkbox, int x, int y, int largeur, int hauteur, int id)
    {
        checkboxs[id] = checkbox;
        checkboxs[id].setBounds(x, y, largeur, hauteur);
        panel.add(checkboxs[id]);
    }

    private void ajouterTextField(JTextField textfield, int x, int y, int largeur, int hauteur)
    {
        textfield.setBounds(x, y, largeur, hauteur);
        panel.add(textfield);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        InterfacePartie interface_jeu;
        Object obj = event.getSource();
        String champ_pseudo1 = pseudo1.getText().trim();
        String champ_pseudo2 = pseudo2.getText().trim();
        String equipe_joueur1 = checkboxgroup1.getSelectedCheckbox().getLabel();
        String equipe_joueur2 = checkboxgroup2.getSelectedCheckbox().getLabel();


        if(obj == boutton1)
        {
            if(champ_pseudo1.isEmpty() || champ_pseudo2.isEmpty())
                JOptionPane.showMessageDialog(frame, "Merci de remplir tous les champs");
            else
                {
                    interface_jeu = new InterfacePartie();
                    interface_jeu.afficherFenetre();

                    this.cacherFenetre();
                    frame.dispose();
                }
        }

    }

}
