/***
 * In The Name of Allah
 ***/
package game.bufferstrategy;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.net.URL;
import java.util.Timer;
import javax.imageio.ImageIO;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Program start.
 *
 * @author Seyed Mohammad Ghaffarian
 */
public class Main {

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
        Timer soundTimer = new Timer();
        soundTimer.schedule(sound, 0L, 16000L);
        //Menu menu = new Menu( );
        MainMenu mainMenu = new MainMenu("hi");
    }

    static BufferedImage loadImage(String filename) {
        try {
            URL imageURL = ClassLoader.getSystemResource("images/" + filename);
            if (imageURL != null)
                return ImageIO.read(imageURL);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
    }
}
