package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mahin mirshams on 6/28/2016.
 */
public class CatapultBasketBallZombie extends Zombie {


    private enum CatapultZombieState {
        Walking,
        Jumping,
        Destroying,
        Shooting

    }

    CatapultZombieState state = CatapultZombieState.Walking;
    int originY;
    int shootStart;
    int shootEnd;
    int basketball = 0;


    CatapultBasketBallZombie(int x, int y, GameState gameState) {
        super(x, y, gameState, "Catapult-Zombie.gif", "Catapult-Zombie.gif");
    }

    @Override
    void update() {
        super.update();
        if (state == CatapultZombieState.Walking) {

            move();


            if (x == 800) {
                state = CatapultZombieState.Shooting;
            }
        }
        if (state == CatapultZombieState.Shooting) {
            final CatapultBasketBallZombie me = this;
            Timer ball = new Timer();
            TimerTask ballTask = new TimerTask() {
                @Override
                public void run() {
                    BasketBall ball = new BasketBall(me, gameState);
                    originY = ball.y;
                    shootStart = ball.x;
                    for (Selectable selectable : gameState.selectables) {
                            if (selectable.y == me.y && selectable != null) {
                                shootEnd = selectable.y;
                                y = (int) (originY + (0.01 * (x - shootStart) * (x - shootEnd)));
                            }

                    }
                }


            };
            basketball++;
            if (basketball < 10) {
                ball.schedule(ballTask, 1000);
            } else state = CatapultZombieState.Destroying;

        }
        if (state == CatapultZombieState.Destroying) {
            GameObject collidedZombie = getCollidedZombie();
            if (collidedZombie != null && collidedZombie instanceof Plant) {
                collidedZombie.hurt(Integer.MAX_VALUE);
            }


        }
    }
}