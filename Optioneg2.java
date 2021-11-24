
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Optioneg2 extends JFrame {

    static JPanel mypanel = new JPanel();
    static JButton button1 = new JButton("warning");
    ActionListener lis;

    // array of button
    static JButton[] buttons = new JButton[6];
    // array of button names
    static String[] buttonNames = {
        "Mercator", "Albers", "Lambert",
        "Blaeu", "Muhammad", "Ortelius"
    };

    // array of path tot the image files 
    static String[] fileNames = {
        "Mercator.jpg", "Albers.jpg", "Lambert.jpg",
        "Blaeu.jpg", "Muhammad.jpg", "Ortelius.jpg"
    };

    // array of full name of cartographers
    static String[] cartographerNames = {
        "Gerardus Mercator", "Louis Albert Guislain Bacler d'Albe",
        "Johann Heinrich Lambert", "Willem Blaeu",
        "Muhammad al-Idrisi", "Abraham Ortelius"

    };
    
    // array of cartographers' information
    static String[] informations = {
        "Gerardus Mercator was a 16th-century geographer,"
        + " cosmographer and cartographer from Flanders. "
        + "He is most renowned for creating the 1569 world map"
        + " based on a new projection which represented sailing courses"
        + " of constant bearing as straight lines—an innovation that "
        + "is still employed in nautical charts",
        
        "Bacler d'Albe was a French artist, as well as the map-maker "
        + "and closest strategic advisor of Napoleon from 1796 "
        + "until 1814. He was considered one of the best "
        + "map-makers of his time",
        
        "Johann Heinrich Lambert was a Swiss polymath who made important "
        + "contributions to the subjects of mathematics, physics, "
        + "philosophy, astronomy and map projections. "
        + "Edward Tufte calls him and William Playfair \"The two great "
        + "inventors of modern graphical designs\"",
        
        "Willem Janszoon Blaeu, also abbreviated to Willem Jansz."
        + " Blaeu, was a Dutch cartographer, atlas maker and publisher."
        + " Along with his son Johannes Blaeu, Willem is considered one"
        + " of the notable figures of the Netherlandish/Dutch school of "
        + "cartography in its golden age.",
        
        "Abu Abdullah Muhammad al-Idrisi al-Qurtubi al-Hasani as-Sabti, "
        + "or simply al-Idrisi, was an Arab Muslim geographer, "
        + "cartographer and Egyptologist who lived in Palermo, "
        + "Sicily at the court of King Roger II. Muhammed al-Idrisi was "
        + "born in Ceuta then belonging to the Almoravids.",
                
        "Abraham Ortelius was a Brabantian cartographer and geographer, "
        + "conventionally recognized as the creator of the first"
        + " modern atlas, the Theatrum Orbis Terrarum."
    };

    public Optioneg2() {
        setTitle("GIS");

        lis = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Object source = ae.getSource();
                
                // iterate over the array of buttons 
                for (int i = 0; i < buttons.length; i++) {
                    
                    // look for the right one 
                    JButton button = buttons[i];
                    if (source == button) {
                        // show result on scresn
                        JFrame myfr2 = new JFrame();
                        JOptionPane.showMessageDialog(myfr2,
                                "<html><body><p style='width: 200px;'>"
                                + informations[i]
                                + "</p></body></html>",
                                cartographerNames[i],
                                JOptionPane.OK_OPTION,
                                new ImageIcon(fileNames[i]));
                        break;
                    }
                }
            }
        };

        this.setBounds(150, 150, 400, 400);
        
        // add button to the panel 
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonNames[i]);
            buttons[i].addActionListener(lis);
            mypanel.add(buttons[i]);
        }
        
        
        getContentPane().add(mypanel, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        Optioneg2 opteg2 = new Optioneg2();
        opteg2.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.out.println("Thanks, Quick Start exits");
                System.exit(0);
            }
        });
        opteg2.setVisible(true);

    }
}
