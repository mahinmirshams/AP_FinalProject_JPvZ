package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class PlantsPicker extends Drawable {
    String cursorName;
    public PlantsPicker(int x, int y, String imageName, String cursorName, GameState state) {
        super(x,y,imageName, 75, 50, state);
        this.cursorName = cursorName;

    }

    int getValue(){
        return 0;
    }

    @Override
    void onclicked(GameState gameState){
        if(gameState.money >= getValue()){
            Image image = Main.loadImage(cursorName);
            Cursor a = Toolkit.getDefaultToolkit().createCustomCursor(image, new Point(0,0), "");
            gameState.cursor = a;
            gameState.selectedItemValue = getValue();
        }
    }


}
