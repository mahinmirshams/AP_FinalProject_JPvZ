package game.bufferstrategy;

import java.awt.*;
import java.util.TimerTask;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class Sun extends Drawable{

    int destination;


    @Override
    int getStateToVisible() {
        return 2;
    }
    public Sun(GameState state , Selectable selectable) {
        super(selectable.x,-3,"Sun_pvZ2.png",70, 70, state);
        this.destination = selectable.y;
    }

    @Override

    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(y<destination)
            y += 1;


    }

    @Override
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        gameState.money+=25;
    }

    @Override
    public void random() {
        super.random();

    }

}


