/***
 * In The Name of Allah
 ***/
package game.bufferstrategy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * A very simple structure for the main game loop.
 * THIS IS NOT PERFECT, but works for most situations.
 * Note that to make this work, none of the 2 methods
 * in the while loop (update() and render()) should be
 * long running! Both must execute very quickly, without
 * any waiting and blocking!
 * <p>
 * Detailed discussion on different game loop design
 * patterns is available in the following link:
 * http://gameprogrammingpatterns.com/game-loop.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
class GameLoop implements Runnable {

    /**
     * Frame Per Second.
     * Higher is better, but any value above 24 is fine.
     */
    private static final int FPS = 30;


    private GameFrame canvas;
    private GameState state;


    GameLoop(GameFrame frame) {
        canvas = frame;
        state = new GameState();
    }

    /**
     * This must be called before the game loop starts.
     */
    void init() {
        // Perform all initializations ...
        state.currentLevel = new Level5(state);
        state.currentLevel.init();

        canvas.addKeyListener(state.getKeyListener());
        canvas.addMouseListener(state.getMouseListener());
        canvas.addMouseMotionListener(state.getMouseMotionListener());
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Drawable clickedItem = getClickedItem(e.getX(), e.getY());
                Selectable clickedSelectable = getClickedSelectable(e.getX(), e.getY());

                if (clickedSelectable != null) {
                    if (state.digISOn) {
                        clickedSelectable.dig();
                        state.digISOn = false;
                        state.cursor = null;
                    } else if (state.selectedItem != null && clickedSelectable.isEmpty())
                        clickedSelectable.plant();
                }
                if (clickedItem != null) {
                    clickedItem.onClick();
                    if (clickedItem instanceof Sun) state.deleteDrawable(clickedItem);
                }
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
        });

        for (int j = 0; j < 5; j++)
            for (int i = 0; i < 9; i++)
                state.selectables.add(new Selectable(395 + (i * 75), 40 + (j * 105), state));

        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                makeSun();

            }

        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 0L, 6000L);
    }



    private Drawable getClickedItem(int x, int y) {
        for (int i = state.getDrawables().size() - 1; i >= 0; i--) {
            Drawable drawable = state.getDrawables().get(i);
            if (
                    (x >= drawable.x && x <= drawable.x + drawable.width) &&
                            (y >= drawable.y && y <= drawable.y + drawable.height)
                    ) {
                return drawable;
            }
        }
        return null;
    }





    private Selectable getClickedSelectable(int x, int y) {
        for (Selectable selectable : state.selectables) {
            if (
                    (x >= selectable.x && x <= selectable.x + 70) &&
                            (y >= selectable.y && y <= selectable.y + 70)
                    ) {
                return selectable;
            }
        }
        return null;
    }

    private void makeSun() {
        if (state.states == 2) {
            Random rand = new Random();
            int value = rand.nextInt(state.selectables.size());
            state.addDrawables(new Sun(state, state.selectables.get(value)));
        }
    }

    @Override
    public void run() {
        boolean gameOver = false;
        while (!gameOver) {
            try {
                gameOver = state.gameOver;
                long start = System.currentTimeMillis();
                //
                state.update();
                state.currentLevel.update();
                canvas.render(state);

                long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                if (delay > 0)
                    Thread.sleep(delay);
            } catch (InterruptedException ignored) {
            }
        }
    }
}

