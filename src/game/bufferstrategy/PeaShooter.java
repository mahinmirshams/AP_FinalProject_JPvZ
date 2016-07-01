package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class PeaShooter extends Plant {
    private Timer timer = new Timer();

    @Override
    int getStateToVisible() {
        return 2;
    }

    PeaShooter(int x, int y, GameState state) {
        super(x, y, "Peashooter3.gif", 100, 100, state, 0, 100);

    }

    @Override
    void deleteObject() {
        super.deleteObject();
        timer.cancel();
    }

    @Override
    void planted() {
        super.planted();
        final PeaShooter me = this;
        TimerTask Task = new TimerTask() {

            @Override
            public void run() {
                Pea icedPea = new Pea(me, gameState);
                gameState.addDrawables((icedPea));
            }

        };

        timer.schedule(Task, 0L, 4000L);
    }
}

