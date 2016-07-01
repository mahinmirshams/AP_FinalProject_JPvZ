/***
 * In The Name of Allah
 ***/
package game.bufferstrategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.HashMap;
import javax.imageio.ImageIO;
import javax.swing.*;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Program start.
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class Main {

    private static HashMap<String, Image> cachedImages = new HashMap<String, Image>();

    public static void main(String[] args) {
        // Initialize the global thread-pool
        ThreadPool.init();

        // Show the game menu ...

        // After the player clicks 'PLAY' ...
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                GameFrame frame = new GameFrame("Java Plants vs Zombies");
                frame.setLocationRelativeTo(null); // put frame at center of screen
                frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
                frame.setVisible(true);
                frame.initBufferStrategy();
                // Create and execute the game-loop
                GameLoop game = new GameLoop(frame);
                game.init();
                ThreadPool.execute(game);
                // and the game starts ...
            }
        });

        Sound sound = new Sound();
        //Timer soundTimer = new Timer();
        //soundTimer.schedule(sound, 0L, 16000L);
        //Menu menu = new Menu( );
        MainMenu mainMenu = new MainMenu("hi");
    }

    static Image loadImage(String filename) {
        if (cachedImages.containsKey(filename)) return cachedImages.get(filename);

        Image image = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);

        try {
            URL imageURL = ClassLoader.getSystemResource("images/" + filename);
            if (imageURL != null) {
                if (imageURL.toString().toLowerCase().endsWith(".gif"))
                    image = (new ImageIcon(imageURL)).getImage();
                else
                    image = ImageIO.read(imageURL);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cachedImages.put(filename, image);

        System.out.println("Loaded " + filename);  // TODO: Delete me

        return image;
    }
}
