package game.bufferstrategy;

import java.awt.*;

/**
 * A class which is extended from GameObject that controlls
 */
class LawnMover extends GameObject {

    LawnMover(int x, int y, GameState state) {
        super(x, y, "Lawn_Mower.png", 100, 80, state, 0, 700000000);
    }

    @Override
    public void draw(Graphics2D g2d) throws InterruptedException {
        super.draw(g2d);
    }

    @Override
    void update() {
        super.update();
        GameObject collidedZombie = getCollidedZombie();
        if (collidedZombie != null && collidedZombie instanceof Zombie){
            collidedZombie.hurt(Integer.MAX_VALUE);
            this.changeSpeed(-2);
        }
    }
}

