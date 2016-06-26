package game.bufferstrategy;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class Drawable {

    BufferedImage img;
    int x;
    int y;
    int width;
    int height;
    GameState gameState;
    int getStateToVisible() {
        return 1;
    }

    public Drawable(int x, int y , String file, int width, int height, GameState gameState){
        this.x = x;
        this.y = y;
        this.gameState = gameState;
        this.height = height;
        this.width = width;
        img = Main.loadImage(file);

    }
    public Drawable(){

    }
    public void draw(Graphics2D g2d) throws InterruptedException {
        g2d.drawImage(img, x, y, width,height, null);
    }
    void onclicked(GameState gameState) {
    }

    public void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void random(){
        Random rand = new Random();
        int value = rand.nextInt(50);

    }
}
