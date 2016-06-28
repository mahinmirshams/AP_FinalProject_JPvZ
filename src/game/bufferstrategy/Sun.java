package game.bufferstrategy;

import java.awt.*;
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
=======
import java.util.Timer;
>>>>>>> new code
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
public class Sun extends Drawable{

    int destination;

=======
class Sun extends Drawable {

    private int destination;

    private enum SunState {
        falling,
        standing
    }

    SunState state = SunState.falling;
>>>>>>> new code

    @Override
    int getStateToVisible() {
        return 2;
    }
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
    public Sun(GameState state , Selectable selectable) {
        super(selectable.x,-3,"Sun_pvZ2.png",70, 70, state);
        this.destination = selectable.y;
    }

    @Override

=======

    Sun(GameState state, Selectable selectable) {
        super(selectable.x, -3, "Sun_pvZ2.png", 70, 70, state);
        this.destination = selectable.y;
    }

    Sun(SunFlower sunFlower, GameState gameState) {
        super(sunFlower.x + 50, sunFlower.y, "Sun_pvZ2.png", 70, 70, gameState);
        this.destination = y;
    }

    @Override
>>>>>>> new code
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
        if(y<destination)
            y += 1;


    }

    @Override
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        gameState.money+=25;
    }

    @Override
    public void random() {
        super.random();

    }

=======

        if (y < destination)
            y += 1;
        else if (state == SunState.falling) {
            state = SunState.standing;
            Timer selfDestructionTimer = new Timer();
            TimerTask selfDestrutionTask = new TimerTask() {
                @Override
                public void run() {
                    selfDestruction();
                }
            };

            selfDestructionTimer.schedule(selfDestrutionTask, 5000L);
        }
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        gameState.money += 25;
    }
>>>>>>> new code
}


