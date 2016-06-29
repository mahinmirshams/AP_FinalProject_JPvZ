package game.bufferstrategy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
/**
 * Created by mahin mirshams on 6/29/2016.
 */
public class MainMenu extends JFrame {

    private JPanel  menuPanel;
    private JLabel label ;
    private JButton button ;
    private ImageIcon img ;


    private static final long serialVersionUID = 1L;
    MyButton b1, b2, b3, b4;

    public MainMenu(String title ){

        super(title);
        setSize(1000,750);
        setLocation(200 , 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setLayout(null);

        img = new ImageIcon("D:\\unversity\\2\\AP\\Assingment\\final project\\GameStructure 2\\GameStructure\\src\\images\\MainMenu.png") ;
        label = new JLabel(img) ;

        label.setOpaque(true);
        label.setLocation(0 , -116 );
        label.setSize(1000 , 1000 );
        add(label) ;

	/*	b1 = new MyButton("play1");
		b1.setSize(300, 50);
		b1.setLocation(160, 250);
		b1.setBackground(new Color(56, 9, 1));
		b1.setForeground(new Color(221, 188, 182));
	*/
        setVisible(true);

/*
        JLabel background = new JLabel(new ImageIcon(ImageIO.read(...)));
        frame.setContentPane(background);
        frame.setLayout(...);
        frame.add(...);
*/

/*

        try {
            // Load the background image
            BufferedImage img = ImageIO.read(new File("D:\\unversity\\2\\AP\\Assingment\\final project\\GameStructure 2\\GameStructure\\src\\images\\MainMenu.png"));

            // Create the frame...

            // Set the frames content pane to use a JLabel
            // whose icon property has been set to use the image
            // we just loaded
            setContentPane(new JLabel(new ImageIcon(img)));

            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;

            add(new JLabel("Hello world") , gbc);
            add(new JLabel("I'm on top") , gbc);
            add(button , gbc);

            pack();
            setLocationRelativeTo(null);
            setVisible(true);

            // Supply a layout manager for the body of the content
            // Add stuff...
             } catch (IOException exp) {
            exp.printStackTrace();
        }

*/

        /*

        setLayout(new GridLayout());
        label = new JLabel("I`m a label");
        label.setBackground(Color.ORANGE);
        label.setOpaque(true);//mat mikone jlabel ro
        add(label  , BorderLayout.CENTER);
*/

/*
        button = new JButton("click me ");
        button.setForeground(Color.RED);
        add(button , BorderLayout.SOUTH);

        setVisible(true);*/
    }
}

