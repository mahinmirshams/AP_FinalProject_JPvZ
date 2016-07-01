package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mahin mirshams on 6/26/2016.
 */
class CherryBomb extends Plant {

    private int explosionradious = 100;

    @Override
    int getStateToVisible() {
        return 2;
    }

    CherryBomb(int x, int y, GameState state) {
        super(x, y, "CherryBomb.png", 70, 100, state, 0, 100);
    }

    @Override
    void planted() {
        super.planted();
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {

                for (Drawable drawables : gameState.getDrawables()) {
                    if (drawables instanceof Zombie) {
                        int distance = (int) Math.sqrt(Math.pow((drawables.x - x), 2) + Math.pow((drawables.y - y), 2));
                        if (distance <= explosionradious) {
                            ((Zombie) drawables).hurt(Integer.MAX_VALUE);
                        }
                    }
                }

                life = 0;
            }

        };

        Timer timer = new Timer();
        timer.schedule(Task, 2000);
    }
}
