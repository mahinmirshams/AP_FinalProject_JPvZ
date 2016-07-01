package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/22/2016 AD.
 */
class Selectable {
    int x;
    int y;
    private boolean plantable = false;
    private boolean isPointing;

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

    boolean plant() {
        if (!plantable || !isEmpty())
            return false;
        if (gameState.selectedItem != null && gameState.states >= gameState.selectedItem.getStateToVisible()) {
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
        if (!isEmpty()) {
            if (currentPlant.getStateToVisible() <= state.states)
                currentPlant.draw(g2d);
        }
        else if (isPointing && !state.pointingToPicker) {
            Stroke previousStroke = g2d.getStroke();
            Paint previousPaint = g2d.getPaint();

            g2d.setStroke(new BasicStroke(2));
            g2d.setPaint(Color.red);
            g2d.drawRect(x, y, 70, 100);

            g2d.setStroke(previousStroke);
            g2d.setPaint(previousPaint);
        }
    }

    void dig() {
        if (!isEmpty()) {
            currentPlant.deleteObject();
            currentPlant = null;
        }
    }
    void setPlantable() {
        plantable = true;
    }
    void setUnPlantable() {
        plantable = false;
    }

    boolean isPlantable() {
        return plantable;
    }

    void setPointing(boolean pointing) {
        this.isPointing = pointing;
    }
}
