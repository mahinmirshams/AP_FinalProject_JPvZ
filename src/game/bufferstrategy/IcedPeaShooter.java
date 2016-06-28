package game.bufferstrategy;

<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
import java.util.Date;
import java.util.Random;
=======
>>>>>>> new code
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
public class IcedPeaShooter extends GameObject {
=======
class IcedPeaShooter extends Plant {
    private Timer timer = new Timer();

>>>>>>> new code
    @Override
    int getStateToVisible() {
        return 2;
    }
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
    public IcedPeaShooter(int x, int y, GameState state) {
        super(x,y,"Snow_Pea_(HD_size).png",70, 100, state ,0,100);

=======

    IcedPeaShooter(int x, int y, GameState state) {
        super(x, y, "Snow_Pea_(HD_size).png", 70, 100, state, 0, 100);
    }

    @Override
    void deleteObject() {
        super.deleteObject();
        timer.cancel();
>>>>>>> new code
    }

    @Override
    void planted() {
        super.planted();
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
//        Random rand = new Random();
//        int value = rand.nextInt(4000);
=======
>>>>>>> new code
        final IcedPeaShooter me = this;
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {
                IcedPea icedPea = new IcedPea(me, gameState);
                gameState.drawables.add((icedPea));
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06

            }

        };
        Date day = new Date();
        Timer timer = new Timer();
        timer.schedule(Task ,day.getSeconds(),4000);

        new  IcedPea(this,gameState);

=======
            }

        };

        timer.schedule(Task, 0L, 4000L);
>>>>>>> new code
    }
}
