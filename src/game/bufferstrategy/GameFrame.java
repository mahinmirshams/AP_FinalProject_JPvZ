/*** In The Name of Allah ***/
package game.bufferstrategy;

import java.awt.*;
import java.awt.image.BufferStrategy;
import java.util.ArrayList;
import javax.swing.*;

/**
 * The window on which the rendering is performed.
 * This structure uses the modern BufferStrategy approach for 
 * double-buffering; actually, it performs triple-buffering!
 * For more information on BufferStrategy check out:
 *    http://docs.oracle.com/javase/tutorial/extra/fullscreen/bufferstrategy.html
 *    http://docs.oracle.com/javase/8/docs/api/java/awt/image/BufferStrategy.html
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameFrame extends JFrame {
	
	public static final int GAME_HEIGHT = 287 * 2;
	public static final int GAME_WIDTH = 530 * 2;
	ArrayList<Drawable> drawables = new ArrayList<Drawable>();
	
	private BufferStrategy bufferStrategy;
	
	public GameFrame(String title) {
		super(title);
		setResizable(false);
		setSize(GAME_WIDTH, GAME_HEIGHT);
		//
		// Initialize the JFrame ...
		//
	}
	
	/**
	 * This must be called once after the JFrame is shown:
	 *    frame.setVisible(true);
	 * and before any rendering is started.
	 */
	public void initBufferStrategy() {
		// Triple-buffering
		createBufferStrategy(3);
		bufferStrategy = getBufferStrategy();
	}

	
	/**
	 * Game rendering with triple-buffering using BufferStrategy.
	 */
	public void render(GameState state) {
		// Get a new graphics context to render the current frame
		Graphics2D graphics = (Graphics2D) bufferStrategy.getDrawGraphics();
		try {
			// Do the rendering
			doRendering(graphics, state);
		} finally {
			// Dispose the graphics, because it is no more needed
			graphics.dispose();
		}
		// Display the buffer
		bufferStrategy.show();
		// Tell the system to do the drawing NOW;
		// otherwise it can take a few extra ms and will feel jerky!
		Toolkit.getDefaultToolkit().sync();
	}
	
	/**
	 * Rendering all game elements based on the game state.
	 */
	private void doRendering(Graphics2D g2d, GameState state) {
		//
		// Draw all game elements according 
		//  to the game 'state' using 'g2d' ...
		//
		g2d.setFont(getFont().deriveFont(20.0f));



		Image bg = Toolkit.getDefaultToolkit().getImage("D:\\unversity\\2\\AP\\Assingment\\final project\\GameStructure\\out\\production\\GameStructure\\game\\bufferstrategy\\images\\bggarden.jpg");
		g2d.drawImage(bg, 0, 0, 678 * 2, GAME_HEIGHT, null);

		Image money = Toolkit.getDefaultToolkit().getImage("D:\\unversity\\2\\AP\\Assingment\\final project\\GameStructure\\out\\production\\GameStructure\\game\\bufferstrategy\\images\\money.jpg");
		g2d.drawImage(money, 100, 20, 164,52, null);



		for (Drawable drawable: drawables){
			try {
				drawable.draw(g2d);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		g2d.drawString(String.valueOf(state.money), 200,20);



	}


	public void init(){
		drawables.add(new LawnMover(270, 150));
		drawables.add(new LawnMover(270, 250));
		drawables.add(new LawnMover(270, 350));
		drawables.add(new LawnMover(270, 450));
		drawables.add(new LawnMover(270, 50));
		drawables.add(new Zombie(590,50));
		drawables.add(new PlantsPicker(10,40));
		drawables.add(new Grass(390,200 , 0));
	}
	
}
