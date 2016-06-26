package game.bufferstrategy;

import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class IcedPeaShooter extends GameObject {
    @Override
    int getStateToVisible() {
        return 2;
    }
    public IcedPeaShooter(int x, int y, GameState state) {
        super(x,y,"Snow_Pea_(HD_size).png",70, 100, state ,0,100);

    }

    @Override
    void planted() {
        super.planted();
//        Random rand = new Random();
//        int value = rand.nextInt(4000);
        final IcedPeaShooter me = this;
        TimerTask Task = new TimerTask() {
            @Override
            public void run() {
                IcedPea icedPea = new IcedPea(me, gameState);
                gameState.drawables.add((icedPea));

            }

        };
        Date day = new Date();
        Timer timer = new Timer();
        timer.schedule(Task ,day.getSeconds(),4000);

        new  IcedPea(this,gameState);

    }
}
