package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class SunFlowerPicker extends PlantsPicker {

    public SunFlowerPicker(int x, int y, GameState state) {
        super(x, y, "sunflowerpicker.jpg", "sunflower.gif",state);
    }

    @Override
    int getValue() {
        return 50;
    }

    @Override
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new SunFlower(0, 0,gameState);

    }
}


