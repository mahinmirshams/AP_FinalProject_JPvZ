package game.bufferstrategy;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class LawnMover extends GameObject {



    public LawnMover(int x, int y, GameState state) {
        super(x,y,"Lawn_Mower.png",100, 85 , state, 0, 700000000);
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
        if (x>900){
            this.life=0;
        }
    }
}

