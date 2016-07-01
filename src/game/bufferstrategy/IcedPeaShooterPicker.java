package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
class IcedPeaShooterPicker extends PlantsPicker {

    IcedPeaShooterPicker(int x, int y, GameState state) {
        super(x, y, "Icedpeashooter2.png", "Snow_Pea_(HD_size).png", state);
    }

    @Override
    int getValue() {
        return 0;
    }

    @Override
    void onClick() {
        super.onClick();
        if (gameState.money >= getValue())
            gameState.selectedItem = new IcedPeaShooter(0, 0, gameState);
    }
}