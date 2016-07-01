package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by mahin mirshams on 6/28/2016.
 */
class CatapultBasketBallZombie extends Zombie {


    ZombieState state = ZombieState.Walking;
    private int basketball;
    Timer timer = new Timer();


    CatapultBasketBallZombie(int x, int y, GameState gameState) {
        super(x, y, gameState, "Catapult-Zombie.gif", "Catapult-Zombie.gif");
    }

    @Override
    void setState(ZombieState state) {
        this.state = state;
        super.setState(state);
    }

    @Override
    void deleteObject() {
        timer.cancel();
        super.deleteObject();
    }

    @Override
    void update() {
        super.update();
        if (state == ZombieState.Walking) {

            move();

            if (x >= 800 && x <= 810) {
                setState(ZombieState.Shooting);
                final CatapultBasketBallZombie me = this;
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
                                return;
                            }
                        }
                        setState(ZombieState.Walking);
                    }
                };

                timer.schedule(ballTask, 0, 1000);
            }
        }
    }
}