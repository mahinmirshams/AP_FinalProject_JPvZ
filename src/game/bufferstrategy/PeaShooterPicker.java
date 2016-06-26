package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class PeaShooterPicker extends PlantsPicker {

    public PeaShooterPicker(int x, int y, GameState state) {
        super(x, y, "IMG_1395-04-01 17:05:47.jpg", "Repeater_HD_HD.png", state);
    }

    @Override
    int getValue() {
        return 100;
    }

    @Override
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new PeaShooter(0, 0 , gameState);

    }
}