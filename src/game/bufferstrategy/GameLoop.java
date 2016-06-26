/*** In The Name of Allah ***/
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
 * 
 * Detailed discussion on different game loop design
 * patterns is available in the following link:
 *    http://gameprogrammingpatterns.com/game-loop.html
 * 
 * @author Seyed Mohammad Ghaffarian
 */
public class GameLoop implements Runnable {
	
	/**
	 * Frame Per Second.
	 * Higher is better, but any value above 24 is fine.
	 */
	public static final int FPS = 30;
	
	private GameFrame canvas;
	private GameState state;

	public GameLoop(GameFrame frame) {
		canvas = frame;
	}
	
	/**
	 * This must be called before the game loop starts.
	 */
	public void init() {
		// Perform all initializations ...
		state = new GameState();
		canvas.addKeyListener(state.getKeyListener());
		canvas.addMouseListener(state.getMouseListener());
		canvas.addMouseMotionListener(state.getMouseMotionListener());
		canvas.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Drawable clickedItem = getClickedItem(e.getX(), e.getY());
				Selectable clickedSelectable = getClickedSelectable(e.getX(), e.getY());

				if (clickedSelectable != null && state.selectedItem != null) {
					if (clickedSelectable.isEmpty())
						clickedSelectable.plant(state);
				}
				if (clickedItem != null) {
					clickedItem.onclicked(state);
					if (clickedItem instanceof Sun) state.drawables.remove(clickedItem);
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


		state.drawables.add(new LawnMover(270, 150,state));
		state.drawables.add(new PeaShooterPicker(10, 40,state));

		state.drawables.add(new SunFlowerPicker(10, 80,state));
		state.drawables.add(new IcedPeaShooterPicker(10, 130,state));
		state.drawables.add(new Grass(390, 200 , state));
		state.drawables.add(new RollingGrass(390, 200,state));

		Random rand = new Random();
		int value = rand.nextInt(4000);
		TimerTask Task = new TimerTask() {
			@Override
			public void run() {

				Zombie z = new Zombie(880,200,state);
				state.drawables.add(z);
				state.zombies.add(z);

			}

		};
		Date day = new Date();
		Timer timer = new Timer();
		timer.schedule(Task ,day.getSeconds(),4000);




		TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {

				Random rand = new Random();
				int value = rand.nextInt(state.selectables.size());

				state.drawables.add(new Sun(state ,state.selectables.get(value)));
			}

		};
		Date date = new Date();
		timer.schedule(timerTask ,date.getSeconds() ,4000);
		System.out.print(date.getTime());


		for (int j = 0; j < 5; j++)
			for (int i = 0; i < 9; i++)
				state.selectables.add(new Selectable(395 + (i * 70), 85 + (j * 70),state));
		state.drawables.add(new LawnMover(270, 200,state));

	}

	Drawable getClickedItem(int x, int y) {
		for (int i=state.drawables.size()-1; i>0 ; i--) {
			Drawable drawable = state.drawables.get(i);
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




	//Sound sound =  new Sound();

	@Override
	public void run() {
		boolean gameOver = false;
		while (!gameOver) {
			try {
				long start = System.currentTimeMillis();
				//
				state.update();
				canvas.render(state);


				long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
				if (delay > 0)
					Thread.sleep(delay);
			} catch (InterruptedException ex) {
			}
		}
	}
}
