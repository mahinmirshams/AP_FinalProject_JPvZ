package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class Zombie extends Drawable {
    public Zombie(int x, int y) {
        super(x,y,"ZombieHD.png",150, 180);

    }

    @Override
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x-=1;
    }
}
