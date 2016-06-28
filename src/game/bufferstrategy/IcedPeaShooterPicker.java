package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class IcedPeaShooterPicker extends PlantsPicker {

    IcedPeaShooterPicker(int x, int y, GameState state) {
        super(x, y, "IcedPeaShooterPicker.jpg", "Snow_Pea_(HD_size).png", state);
    }

    @Override
    int getValue() {
        return 175;
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new IcedPeaShooter(0, 0, gameState);
    }
}