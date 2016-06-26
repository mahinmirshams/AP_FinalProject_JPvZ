package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/22/2016 AD.
 */
public class Selectable {
    int x;
    int y;

    Drawable currentDrawable = null;
    GameState gameState;

    public Selectable(int x, int y, GameState gameState) {
        this.x = x;
        this.gameState = gameState;
        this.y = y;
    }

    boolean isEmpty() {
        return currentDrawable == null;
    }

    boolean plant(GameState gameState) {
        if (!isEmpty())
            return false;
        if (gameState.states >= gameState.selectedItem.getStateToVisible()) {
            currentDrawable = gameState.selectedItem;
            currentDrawable.setLocation(x, y);
            ((GameObject) currentDrawable).planted();
            gameState.selectedItem = null;
            gameState.cursor = null;
            gameState.money -= gameState.selectedItemValue;
            gameState.selectedItemValue = 0;
            return true;
        }
        return false;
    }

    public void draw(Graphics2D g2d, GameState state) throws InterruptedException {
        currentDrawable.draw(g2d);
    }
}
