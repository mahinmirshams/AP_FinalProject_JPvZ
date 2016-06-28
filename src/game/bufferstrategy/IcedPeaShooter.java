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
        super(x, y, "Snow_Pea_(HD_size).png", 70, 100, state, 0, 100);
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
                IcedPea icedPea = new IcedPea(me, gameState);
                gameState.drawables.add((icedPea));
            }

        };

        timer.schedule(Task, 0L, 4000L);
    }
}
