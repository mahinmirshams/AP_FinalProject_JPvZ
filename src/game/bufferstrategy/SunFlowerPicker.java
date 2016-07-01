package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class SunFlowerPicker extends PlantsPicker {

    SunFlowerPicker(int x, int y, GameState state) {
        super(x, y, "sunflowerpicker.png", "sunflowerPicker.png", state);
    }

    @Override
    int getValue() {
        return 0;
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new SunFlower(0, 0, gameState);
    }
}


