package game.bufferstrategy;


class SunFlowerPicker extends PlantsPicker {

    SunFlowerPicker(int x, int y, GameState state) {
        super(x, y, "sunflowerpicker.png", "Sunflower.png", state);
    }

    @Override
    int getValue() {
        return 50;
    }

    @Override
    void onClick() {
        super.onClick();
        if (gameState.money >= getValue())
            gameState.selectedItem = new SunFlower(0, 0, gameState);
    }
}


