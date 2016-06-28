package game.bufferstrategy;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class Drawable {

    BufferedImage img;
    int x;
    int y;
    int width;
    int height;

    int getStateToVisible() {
        return 1;
    }

    public Drawable(int x, int y , String file, int width, int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        img = Main.loadImage(file);

    }
    public void draw(Graphics2D g2d , GameState state) throws InterruptedException {
        g2d.drawImage(img, x, y, width,height, null);
    }
    void onclicked(GameState gameState) {
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
