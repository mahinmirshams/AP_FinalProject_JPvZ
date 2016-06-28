package game.bufferstrategy;

<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class PeaShooter extends GameObject {
=======
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class PeaShooter extends Plant {
    private Timer timer = new Timer();

>>>>>>> new code
    @Override
    int getStateToVisible() {
        return 2;
    }
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
    public PeaShooter(int x, int y, GameState state) {
        super(x,y,"Repeater_HD_HD.png",70, 100, state ,0,100);

    }
}
=======

    PeaShooter(int x, int y, GameState state) {
        super(x, y, "Peashooter_HD.png", 70, 100, state, 0, 100);

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
                gameState.drawables.add((icedPea));
            }

        };

        timer.schedule(Task, 0L, 4000L);
    }
}

>>>>>>> new code
