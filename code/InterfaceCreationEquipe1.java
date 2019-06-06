

import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private JCheckBox[] check;/* = new JCheckBox("Archer");
	private JCheckBox check2 = new JCheckBox("I Leg");
	private JCheckBox check3 = new JCheckBox("Lourde");
	private JCheckBox check4 = new JCheckBox("Mage");
	private JCheckBox check5 = new JCheckBox("Chevalier");*/
    private CheckboxGroup checkboxgroup1, checkboxgroup2;
    //private Checkbox[] checkboxs;
    protected JTextField champ_pseudo1, champ_pseudo2;

    public InterfaceCreationEquipe1(){
    	
    	//ButtonGroup bg = new ButtonGroup();
        //checkboxgroup1 = new CheckboxGroup();
       // checkboxgroup2 = new CheckboxGroup();

        check = new JCheckBox[10];

        ajouterFrame("Wargame - Creation equipes", 998, 613);
		ajouterImage("img/img2.jpg");
        ajouterPanel(998, 613);

        ajouterCheckbox(new JCheckBox("Archer"), 25, 430, 60, 50, 0);
        ajouterCheckbox(new JCheckBox("I. legere"), 100, 430, 70, 50, 1);
        ajouterCheckbox(new JCheckBox("I. lourde"), 195, 430, 70, 50, 2);
        ajouterCheckbox(new JCheckBox("Mage"), 300, 430, 50, 50, 3);
        ajouterCheckbox(new JCheckBox("Chevalier"), 380, 430, 70, 50, 4);

        ajouterCheckbox(new JCheckBox("Archer"), 540, 430, 60, 50, 5);
        ajouterCheckbox(new JCheckBox("I. legere"), 620, 430, 70, 50, 6);
        ajouterCheckbox(new JCheckBox("I. lourde"), 715, 430, 70, 50, 7);
        ajouterCheckbox(new JCheckBox("Mage"), 810, 430, 50, 50, 8);
        ajouterCheckbox(new JCheckBox("Chevalier"), 890, 430, 70, 50, 9);

        champ_pseudo1 = new JTextField(30);
        ajouterTextField(champ_pseudo1, 540, 110, 250, 50);

        champ_pseudo2 = new JTextField(30);
        ajouterTextField(champ_pseudo2, 540, 170, 250, 50);

        curseur = new Cursor(Cursor.HAND_CURSOR);

        boutton1 = new JButton("Valider");
        ajouterBoutton(boutton1, 850, 150, 120, 30, Color.BLACK, Color.WHITE);

    }

    private void ajouterCheckbox(JCheckBox checkbox, int x, int y, int largeur, int hauteur, int id)
    {
        check[id] = checkbox;
        check[id].setBounds(x, y, largeur, hauteur);
        panel.add(check[id]);
    }

    private void ajouterTextField(JTextField textfield, int x, int y, int largeur, int hauteur)
    {
        textfield.setBounds(x, y, largeur, hauteur);
        textfield.setFont(new Font("impact", Font.PLAIN, 25));
        panel.add(textfield);
    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        InterfacePartie interface_jeu;
        Object obj = event.getSource();
        String pseudo1 = champ_pseudo1.getText().trim();
        String pseudo2 = champ_pseudo2.getText().trim();
        String equipe_joueur1 = checkboxgroup1.getSelectedCheckbox().getLabel();
        String equipe_joueur2 = checkboxgroup2.getSelectedCheckbox().getLabel();


        if(obj == boutton1)
        {
            if(pseudo1.isEmpty() || pseudo2.isEmpty())
                JOptionPane.showMessageDialog(frame, "Merci de remplir tous les champs", "Warning", JOptionPane.WARNING_MESSAGE);
            else
                {
                    interface_jeu = new InterfacePartie(pseudo1, pseudo2, equipe_joueur1, equipe_joueur2, 1);
                    interface_jeu.afficherFenetre();

                    this.cacherFenetre();
                    frame.dispose();
                }
        }

    }

}
