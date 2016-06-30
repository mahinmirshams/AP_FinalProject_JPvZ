package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/22/2016 AD.
 */
class RollingGrass extends Drawable {
    enum RollingGrassState {
        Initial,
        Rolling
    }

    RollingGrassState state = RollingGrassState.Initial;

    RollingGrass(int x, int y, GameState state) {
        super(x, y, "roll.jpg", 35, 100, state);
    }

    @Override
    public void draw(Graphics2D g2d) {
        try {
            super.draw(g2d);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (state == RollingGrassState.Rolling)
            x += 6;

        for (Selectable selectable : gameState.selectables) {
            if (
                    (
                            (y >= selectable.y && y <= selectable.y + 100) ||
                            (y + height >= selectable.y && (y + height <= 100 + selectable.y))
                    )
                    && this.x >= selectable.x
            ) {
                selectable.setPlantable();
            }
        }

        if (x > 1100)
            selfDestruction();
    }
}

