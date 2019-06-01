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



public class InterfacePartie extends InterfacePrincipal implements ActionListener {


    public InterfacePartie(){

        ajouterFrame("Wargame - Jeu", 1400, 774);

        ImageIcon plateau = new ImageIcon("plateau2.jpg");
        label = new JLabel("", plateau, JLabel.LEFT);
        frame.add(label);

        ajouterPanel(1400, 774);


    }

    @Override
    public void actionPerformed(ActionEvent event)
    {
        Object obj = event.getSource();

        if(obj == boutton1)
        {

        }

    }

}
