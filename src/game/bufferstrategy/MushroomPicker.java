package game.bufferstrategy;

/**
 * Created by mahin mirshams on 7/1/2016.
 */
public class MushroomPicker extends PlantsPicker {
    MushroomPicker(int x, int y, GameState state) {
        super(x, y, "mushroompicker .png", "mushroom.png", state);
    }

    @Override
    int getValue() {
        return 0;
    }

    @Override
    void onClick() {
        super.onClick();
        if (gameState.money >= getValue())
            gameState.selectedItem = new Mushroom(0, 0, gameState);
    }
}
