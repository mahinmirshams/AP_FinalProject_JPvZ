package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
class PlantsPicker extends Drawable {
    private String cursorName;

    PlantsPicker(int x, int y, String imageName, String cursorName, GameState state) {
        super(x, y, imageName, 50, 60, state);
        this.cursorName = cursorName;
        Main.loadImage(cursorName);
    }

    int getValue() {
        return 0;
    }

    @Override
    void onClick(GameState gameState) {
        if (gameState.money >= getValue()) {
            Image image = Main.loadImage(cursorName);
            Toolkit defaultToolkit = Toolkit.getDefaultToolkit();
            gameState.cursor = defaultToolkit.createCustomCursor(image, new Point(0, 0), "");
            gameState.selectedItemValue = getValue();
        }
    }
}
