package game.bufferstrategy;

import game.bufferstrategy.Drawable;

import java.awt.*;

/**
 * Created by Applestore on 6/22/16.
 */
public class Grass extends Drawable {
    public Grass(int x, int y , int width) {
        super(x,y,"gr.jpg",0, 120);

    }

    @Override
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if(width < 700 ) {
             width += 5;
         }
    }
}

