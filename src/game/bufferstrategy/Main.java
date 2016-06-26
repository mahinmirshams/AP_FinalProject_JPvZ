/*** In The Name of Allah ***/
package game.bufferstrategy;

import java.awt.EventQueue;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

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
				GameFrame frame = new GameFrame("Game Title");
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

	//	Sound sound = new Sound();
	//	sound.run();
    }

	public static BufferedImage loadImage(String filename) {
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
