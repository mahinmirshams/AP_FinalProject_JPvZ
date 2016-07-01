package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mahin mirshams on 7/1/2016.
 */
public class Mushroom extends Plant {
    private Timer timer = new Timer();

    @Override
    int getStateToVisible() {
        return 2;
    }

    Mushroom(int x, int y, GameState state) {
        super(x, y, "mushroom.png", 70, 100, state, 0, 100);

    }

    @Override
    void deleteObject() {
        super.deleteObject();
        timer.cancel();
    }

    @Override
    void planted() {
        super.planted();
        final Mushroom me = this;
        TimerTask Task = new TimerTask() {

            @Override
            public void run() {
                MushroomBullet mushroomBullet = new MushroomBullet(me, gameState);
                gameState.addDrawables((mushroomBullet));
            }

        };

        timer.schedule(Task, 0L, 4000L);
    }
}