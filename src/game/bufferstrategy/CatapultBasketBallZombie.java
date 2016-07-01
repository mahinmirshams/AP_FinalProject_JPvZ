package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mahin mirshams on 6/28/2016.
 */
public class CatapultBasketBallZombie extends Zombie {


    ZombieState state = ZombieState.Walking;
    private int basketball;


    CatapultBasketBallZombie(int x, int y, GameState gameState) {
        super(x, y, gameState, "Catapult-Zombie.gif", "Catapult-Zombie.gif");
    }

    @Override
    void setState(ZombieState state) {
        this.state = state;
        super.setState(state);
    }

    @Override
    void update() {
        super.update();
        if (state == ZombieState.Walking) {

            move();


            if (x == 800) {
                setState(ZombieState.Shooting);
                final CatapultBasketBallZombie me = this;
                Timer ball = new Timer();
                TimerTask ballTask = new TimerTask() {
                    @Override
                    public void run() {
                        if (basketball >= 10) {
                            setState(ZombieState.Walking);
                            this.cancel();
                            return;
                        }

                        for (Selectable selectable : gameState.selectables) {
                            if (selectable.y == me.y && !selectable.isEmpty()) {
                                gameState.addDrawables(new BasketBall(me, gameState, y, x, selectable.x));
                                basketball++;
                            }
                        }
                    }
                };

                ball.schedule(ballTask, 0, 1000);
            }
        }
    }
}