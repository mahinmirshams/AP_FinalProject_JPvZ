package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/22/2016 AD.
 */
public class Selectable {
    int x;
    int y;
    Drawable currentDrawable = null;
    public Selectable(int x, int y){
     this.x = x;
     this.y = y;
    }

    boolean isEmpty(){
        return currentDrawable == null;
    }

    boolean plant(GameState gameState){
        if(!isEmpty())
            return false;
        currentDrawable = gameState.selectedItem;
        currentDrawable.setLocation(x, y);
        gameState.selectedItem = null;
        gameState.cursor=null;
        gameState.money -= gameState.selectedItemValue;
        gameState.selectedItemValue = 0;
        return true;
    }

    public void draw(Graphics2D g2d , GameState state) throws InterruptedException {
        currentDrawable.draw(g2d, state);
    }
}
