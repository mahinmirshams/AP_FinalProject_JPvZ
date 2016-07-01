package game.bufferstrategy;

/**
 * Created by mahin mirshams on 6/26/2016.
 */
class WalNutPicker extends PlantsPicker {

    WalNutPicker(int x, int y, GameState state) {
        super(x, y, "walnutpicker.png", "WalNut.png", state);
    }

    @Override
    int getValue() {
        return 50;
    }

    @Override
    void onClick() {
        super.onClick();
        if (gameState.money >= getValue())
            gameState.selectedItem = new WalNut(0, 0, gameState);
    }
}
