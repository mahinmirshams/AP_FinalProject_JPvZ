package game.bufferstrategy;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */

abstract class Zombie extends GameObject {

    private enum ZombieState {
        Walking,
        Jumping,
        Chewing
    }

    ZombieState state = ZombieState.Walking;
    private Timer freezeTimer = new Timer();
    private String normalZombieImg;
    private String icedZombieImg;
    private Unfreeze unfreeze = null;
    private boolean isFrozen = false;
    private int chewStrength = 20;
    private Timer chewTimer = new Timer();
    private TimerTask chewTimerTask = null;
    boolean hasJumped = false;

    int originY;
    int jumpStart;
    int jumpEnd;

    @Override
    int getStateToVisible() {
        return 2;
    }

    Zombie(int x, int y, GameState state, String normalZombieImg, String icedZombieImg) {
        super(x, y, normalZombieImg, 70, 85, state, 2, 100);
        this.normalZombieImg = normalZombieImg;
        this.icedZombieImg = icedZombieImg;
    }

    @Override
    void update() {
        if (gameState.states == 2) {
            if (state == ZombieState.Walking) {
                // Walking
                move();

                if (x <= 230) {
                    gameState.gameOver  = true;
                }

                GameObject collidedObject = getCollidedPlant();
                if (collidedObject != null && collidedObject instanceof Plant) {
                    if(!(this instanceof PoleVaultingZombie)  || ((this instanceof PoleVaultingZombie) && hasJumped == true) ) {
                        state = ZombieState.Chewing;
                        chewTimerTask = new TimerTask() {
                            @Override
                            public void run() {
                                GameObject collidedPlant = getCollidedPlant();
                                if (collidedPlant != null) {
                                    collidedPlant.hurt(chewStrength);
                                }
                            }
                        };

                        chewTimer.schedule(chewTimerTask, 0L, 500L);
                    }
                    else {
                        state = ZombieState.Jumping;
                        originY = y;
                        jumpStart = x;
                        jumpEnd = getCollidedPlant().x - 100;
                        hasJumped =true;
                    }
                }
            }
            else if(state == ZombieState.Chewing) {
                // Chewing
                GameObject collidedObject = getCollidedPlant();
                if (collidedObject == null) {
                    state = ZombieState.Walking;
                    chewTimerTask.cancel();
                    chewTimerTask = null;
                    chewTimer.purge();
                }
            }
            else if(state == ZombieState.Jumping){
                if (x > jumpEnd)
                    y = (int) (originY + (0.01 * (x-jumpStart) * (x-jumpEnd)));
                else
                    state = ZombieState.Walking;
                move();
            }

        }
    }


    @Override
    void hurt(int strength) {
        super.hurt(strength);
    }

    private class Unfreeze extends TimerTask {
        @Override
        public void run() {
            img = Main.loadImage(normalZombieImg);
            changeSpeed(speed * 2);
            isFrozen = false;
        }
    }

    void getIcy() {
        if (unfreeze != null) unfreeze.cancel();
        freezeTimer.purge();
        unfreeze = new Unfreeze();

        if (!isFrozen) {
            this.img = Main.loadImage(icedZombieImg);
            this.changeSpeed(speed / 2);
        }
        isFrozen = true;

        freezeTimer.schedule(unfreeze, 8000);
    }

    @Override
    void deleteObject() {
        if (chewTimerTask != null) chewTimerTask.cancel();
        if (unfreeze != null) unfreeze.cancel();
        gameState.killedZombie++;
        System.out.println(gameState.killedZombie);
        super.deleteObject();
    }
}

