package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class IcedPeaShooter extends Plant {
    private Timer timer = new Timer();

    @Override
    int getStateToVisible() {
        return 2;
    }

    IcedPeaShooter(int x, int y, GameState state) {
        super(x, y, "Snow-Pea2.gif", 100, 100, state, 0, 100);
    }

    @Override
    void deleteObject() {
        super.deleteObject();
        timer.cancel();
    }

    @Override
    void planted() {
        super.planted();
        final IcedPeaShooter me = this;
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {
                for (Drawable drawable : gameState.getDrawables()) {
                    if (drawable.y == me.y && drawable instanceof Zombie)  {
                        IcedPea icedPea = new IcedPea(me, gameState);
                        gameState.addDrawables((icedPea));
                    }
                }

            }

        };

        timer.schedule(Task, 0L, 4000L);
    }
}
