package game.bufferstrategy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by saeedehspg on 6/22/16.
 */
class Grass extends Drawable {

    enum GrassState {
        Initial,
        Growing
    }

    GrassState state = GrassState.Initial;

    private int cropWidth = 1;
    private BufferedImage fullImage;

    Grass(int x, int y, GameState state) {
        super(x, y, "gr.png", 0, 110, state);
        fullImage = img;
    }

    @Override
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (state == GrassState.Growing) {
            if (cropWidth < 700) {
                img = fullImage.getSubimage(0, 0, cropWidth, height);
                cropWidth += 6;
                width += 6;
            } else if (gameState.states == 1) gameState.states = 2;
        }
    }
}

