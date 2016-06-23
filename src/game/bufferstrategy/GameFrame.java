/*** In The Name of Allah ***/
package game.bufferstrategy;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.ColorConvertOp;
import java.util.ArrayList;
import java.util.Date;
import java.util.*;
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
	ArrayList<Selectable> selectables = new ArrayList<Selectable>();
	
	private BufferStrategy bufferStrategy;
	
	public GameFrame(String title) {
		super(title);
		setResizable(false);
//		setUndecorated(true);
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
		for (Drawable drawable: state.itemsToDelete){
			drawables.remove(drawable);
		}
		state.itemsToDelete.clear();

		g2d.setFont(getFont().deriveFont(20.0f));
		g2d.setPaint(Color.DARK_GRAY);
		setCursor(state.cursor);


		Image bg = Main.loadImage("bggarden.jpg");
		g2d.drawImage(bg, 0, 0, 678 * 2, GAME_HEIGHT, null);

		Image money = Main.loadImage("money.jpg");
		g2d.drawImage(money, 100, 20, 164,52, null);



		for (Drawable drawable: drawables){
			try {
				if (drawable.getStateToVisible() <= state.states)
					drawable.draw(g2d ,state);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (Selectable selectable: selectables){
			try {
				if (!selectable.isEmpty() && selectable.currentDrawable.getStateToVisible() <= state.states)
					selectable.draw(g2d ,state);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		g2d.drawString(String.valueOf(state.money), 179,48);



	}


	public void init() {
		drawables.add(new LawnMover(270, 150));
		drawables.add(new LawnMover(270, 250));
		drawables.add(new LawnMover(270, 350));
		drawables.add(new LawnMover(270, 450));
		drawables.add(new LawnMover(270, 50));
		drawables.add(new PeaShooterPicker(10, 40));
		drawables.add(new SunFlowerPicker(10, 80));
		drawables.add(new Grass(390, 200));
		drawables.add(new RollingGrass(390, 200));
		drawables.add(new Zombie(880, 200));
		drawables.add(new Sun(500, -3));
		drawables.add(new Sun(500, -30));





		for (int j = 0; j < 5; j++)
			for (int i = 0; i < 9; i++)
				selectables.add(new Selectable(395 + (i * 70), 85 + (j * 70)));
	}

	Drawable getClickedItem(int x, int y) {
		for (Drawable drawable : drawables) {
			if (
					(x >= drawable.x && x <= drawable.x + drawable.width) &&
					(y >= drawable.y && y <= drawable.y + drawable.height)
			) {
				return drawable;
			}
		}
		return null;
	}

	Selectable getClickedSelectable(int x, int y) {
		for (Selectable selectable : selectables) {
			if (
					(x >= selectable.x && x <= selectable.x + 70) &&
							(y >= selectable.y && y <= selectable.y + 70)
					) {
				return selectable;
			}
		}
		return null;
	}

	void onClick(MouseEvent e, GameState gameState) {
		Drawable clickedItem = getClickedItem(e.getX(), e.getY());
		Selectable clickedSelectable = getClickedSelectable(e.getX(), e.getY());

		if (clickedSelectable != null && gameState.selectedItem != null) {
			if (clickedSelectable.isEmpty())
				clickedSelectable.plant(gameState);
		}
		if (clickedItem != null)
			clickedItem.onclicked(gameState);
	}
	
}
