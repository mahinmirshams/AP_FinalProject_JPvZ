package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class Drawable {

    Image img;
    int x;
    int y;
    int width;
    int height;
    GameState gameState;

    int getStateToVisible() {
        return 1;
    }

    public Drawable(int x, int y, String file, int width, int height, GameState gameState) {
        this.x = x;
        this.y = y;
        this.gameState = gameState;
        this.height = height;
        this.width = width;
        img = Main.loadImage(file);
    }

    public void draw(Graphics2D g2d) throws InterruptedException {
        g2d.drawImage(img, x, y, width, height, null);
    }

    void onClick(GameState gameState) {
    }

    void setLocation(int x, int y) {
        this.x = x;
        this.y = y;
    }

    void selfDestruction() {
        gameState.deleteDrawable(this);
    }


    //TODO: placing ImageIcon


}
