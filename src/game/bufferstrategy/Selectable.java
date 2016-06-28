package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/22/2016 AD.
 */
class Selectable {
    int x;
    int y;
    private boolean plantable = false;

    Plant currentPlant = null;
    GameState gameState;

    Selectable(int x, int y, GameState gameState) {
        this.gameState = gameState;
        this.x = x;
        this.y = y;
    }

    boolean isEmpty() {
        return currentPlant == null;
    }

    boolean plant(GameState gameState) {
        if (!plantable || !isEmpty())
            return false;
        if (gameState.states >= gameState.selectedItem.getStateToVisible()) {
            currentPlant = gameState.selectedItem;
            currentPlant.setLocation(x, y);
            currentPlant.planted();
            gameState.selectedItem = null;
            gameState.cursor = null;
            gameState.money -= gameState.selectedItemValue;
            gameState.selectedItemValue = 0;
            return true;
        }
        return false;
    }

    void draw(Graphics2D g2d, GameState state) throws InterruptedException {
        currentPlant.draw(g2d);
    }

    void dig() {
        if (!isEmpty()) currentPlant = null;
    }

    void setPlantable() {
        plantable = true;
    }
}
