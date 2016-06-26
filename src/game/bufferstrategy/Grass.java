package game.bufferstrategy;

import game.bufferstrategy.Drawable;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by saeedehspg on 6/22/16.
 */
public class Grass extends Drawable {
    private int cropWidth = 1;
    private BufferedImage fullImage;

    public Grass(int x, int y,GameState state) {
        super(x,y,"gr.jpg",0, 120 , state );
        fullImage = img;
    }

    @Override
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (cropWidth < 700 ) {
            img = fullImage.getSubimage(0, 0, cropWidth, height);
            cropWidth += 5;
            width += 5;
        }
        else if (gameState.states == 1) gameState.states = 2;


    }
}

