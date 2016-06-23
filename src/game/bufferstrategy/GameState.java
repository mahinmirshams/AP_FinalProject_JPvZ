/*** In The Name of Allah ***/
package game.bufferstrategy;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Cursor;

/**
 * This class holds the state of the game and all of its elements.
 * This class also handles user inputs, which affect the game state.
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameState {

	private KeyHandler keyHandler;
	private MouseHandler mouseHandler;
	public int money = 0;
	public int states = 1;
	ArrayList<Drawable> drawas = new ArrayList<Drawable>();

	public GameState() {
		//
		// Initialize the game state and all elements ...
		//
		keyHandler = new KeyHandler();
		mouseHandler = new MouseHandler();
	}

	/**
	 * The method which updates the game state.
	 */
	public void update() {
		//
		// Update the state of all game elements 
		//  based on user input and elapsed time ...
		//
	}

	GameFrame gamef =  new GameFrame("ds");


	public KeyListener getKeyListener() {
		return keyHandler;
	}

	public MouseListener getMouseListener() {
		return mouseHandler;
	}

	public MouseMotionListener getMouseMotionListener() {
		return mouseHandler;
	}


	/**
	 * The keyboard handler.
	 */
	class KeyHandler implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
		}

		@Override
		public void keyPressed(KeyEvent e) {
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

	}

	/**
	 * The mouse handler.
	 */
	class MouseHandler implements MouseListener, MouseMotionListener {

		@Override
		public void mouseClicked(MouseEvent e) {

		}

		@Override
		public void mousePressed(MouseEvent e) {

		}

		@Override
		public void mouseReleased(MouseEvent e) {
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			java.awt.Toolkit toolkit = java.awt.Toolkit.getDefaultToolkit();
			Image image = toolkit.getImage("images/Repeater_HD_HD.png");
			Cursor a = toolkit.createCustomCursor(image, new Point(0,0), "");
			gamef.setCursor (a);

		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mouseDragged(MouseEvent e) {
		}

		@Override
		public void mouseMoved(MouseEvent e) {
		}

	}
}

