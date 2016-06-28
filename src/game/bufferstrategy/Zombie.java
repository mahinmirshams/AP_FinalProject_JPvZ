package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class Zombie extends Drawable {
    @Override
    int getStateToVisible() {
        return 2;
    }
    public Zombie(int x, int y) {
        super(x,y,"ZombieHD.png",70, 100);

    }

    @Override
    public void draw(Graphics2D g2d , GameState gameState) {
        try {
            super.draw(g2d, gameState);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (x > 393)
            x -= 1;
        else x=393;
    }
}
