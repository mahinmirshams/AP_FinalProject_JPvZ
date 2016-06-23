package game.bufferstrategy;

import java.awt.*;

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
            super.draw(g2d,gameState);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        x-=1;
    }
}
