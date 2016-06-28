package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/22/2016 AD.
 */
public class RollingGrass extends Drawable {
    public RollingGrass(int x, int y) {
        super(x,y,"roll.jpg",35, 120);

    }

    @Override
    public void draw(Graphics2D g2d , GameState gameState) {
        try {
            super.draw(g2d , gameState);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x+=5;

    }
}

