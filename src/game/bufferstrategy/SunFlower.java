package game.bufferstrategy;

<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class SunFlower extends GameObject {
=======
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class SunFlower extends Plant {
    private Timer timer = new Timer();

>>>>>>> new code
    @Override
    int getStateToVisible() {
        return 2;
    }
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
    public SunFlower(int x, int y, GameState state) {
        super(x,y,"sunflower.gif",70, 100, state,0,100);

=======

    SunFlower(int x, int y, GameState state) {
        super(x, y, "sunflower.gif", 70, 100, state, 0, 100);
        makeSun();
    }

    private void makeSun() {
        final SunFlower me = this;
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {
                Sun sun = new Sun(me, gameState);
                gameState.drawables.add(sun);
            }

        };

        timer.schedule(Task, 0L, 7000L);
    }

    @Override
    void deleteObject() {
        timer.cancel();
        super.deleteObject();
>>>>>>> new code
    }
}
