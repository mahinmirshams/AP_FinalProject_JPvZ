package game.bufferstrategy;

import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class Sun extends Drawable {

    private int destination;

    private enum SunState {
        falling,
        standing
    }

    SunState state = SunState.falling;

    @Override
    int getStateToVisible() {
        return 2;
    }

    Sun(GameState state, Selectable selectable) {
        super(selectable.x, -3, "Sun_pvZ2.png", 70, 70, state);
        this.destination = selectable.y;
    }

    Sun(SunFlower sunFlower, GameState gameState) {
        super(sunFlower.x + 50, sunFlower.y, "Sun_pvZ2.png", 70, 70, gameState);
        this.destination = y;
    }

    @Override
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
}


