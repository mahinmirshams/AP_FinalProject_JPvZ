package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
abstract class PlantsPicker extends Drawable {
    private String cursorName;

    PlantsPicker(int x, int y, String imageName, String cursorName, GameState state) {
        super(x, y, imageName, 75, 50, state);
        this.cursorName = cursorName;
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
