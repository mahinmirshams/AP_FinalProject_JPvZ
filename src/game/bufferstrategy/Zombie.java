package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class Zombie extends GameObject{

    @Override

    int getStateToVisible() {
        return 2;
    }

    public Zombie(int x, int y,GameState state) {
        super(x, y, "ZombieHD.png", 70, 100,state, 5,100);
    }

    @Override
    void update() {
        if (gameState.states == 2) {
            super.update();
            if (x <= 300) {
                for (Drawable drawable : gameState.drawables) {
                    if (drawable instanceof LawnMover && ((LawnMover) drawable).y <= 200) {
                        ((LawnMover) drawable).changeSpeed(-2);
                    }
                }
            }
        }

    }
}
