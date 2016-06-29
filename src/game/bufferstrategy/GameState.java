/***
 * In The Name of Allah
 ***/
package game.bufferstrategy;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.awt.Cursor;
import java.util.Iterator;

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
    int states = 1;
    Cursor cursor = null;
    Plant selectedItem = null;
    ArrayList<Drawable> drawables = new ArrayList<Drawable>();
    ArrayList<Selectable> selectables = new ArrayList<Selectable>();
    int selectedItemValue = 0;
    Boolean gameOver = false;
    int level =1;



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
    void update() {
        Iterator<Drawable> drawableIterator = drawables.iterator();
        while (drawableIterator.hasNext()) {
            Drawable drawable = drawableIterator.next();
            if (drawable instanceof GameObject) {
                GameObject gameObject = (GameObject) drawable;
                gameObject.update();
                if (gameObject.isDeletable()) {
                    gameObject.deleteObject();
                    drawableIterator.remove();
                }
            }
        }

        Iterator<Selectable> selectableIterator = selectables.iterator();
        while (selectableIterator.hasNext()) {
            Selectable selectable = selectableIterator.next();
            if (!selectable.isEmpty()) {
                GameObject gameObject = selectable.currentPlant;
                gameObject.update();
                if (gameObject.isDeletable()) {
                    gameObject.deleteObject();
                    selectable.dig();
                }
            }
        }
    }


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

