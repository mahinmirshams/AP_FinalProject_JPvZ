package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class PeaShooterPicker extends PlantsPicker {

    PeaShooterPicker(int x, int y, GameState state) {
        super(x, y, "peashooterpicker.jpg", "Repeater_HD_HD.png", state);
    }

    @Override
    int getValue() {
        return 0;
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new PeaShooter(0, 0, gameState);
    }
}