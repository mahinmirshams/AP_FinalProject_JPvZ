package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class IcedPeaShooterPicker extends PlantsPicker {

    public IcedPeaShooterPicker(int x, int y, GameState state) {
        super(x, y, "IcedPeaShooter.jpg", "Snow_Pea_(HD_size).png", state);
    }

    @Override
    int getValue() {
        return 0;
    }

    @Override
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new IcedPeaShooter(0, 0 , gameState);

    }
}