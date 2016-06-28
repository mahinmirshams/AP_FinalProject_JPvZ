package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
class LawnMover extends GameObject {

    LawnMover(int x, int y, GameState state) {
        super(x, y, "Lawn_Mower.png", 100, 85, state, 0, 700000000);
    }

    @Override
    public void draw(Graphics2D g2d) throws InterruptedException {
        super.draw(g2d);
    }

    @Override
    void move() {
        super.move();

        for (Zombie z : gameState.zombies) {
            if (x >= z.x) {
                z.hurt(500000000);
            }
        }

        if (x > 800) {
            this.life = 0;
        }
    }
}

