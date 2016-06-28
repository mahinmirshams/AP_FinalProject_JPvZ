package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
public class SunFlowerPicker extends PlantsPicker {

    public SunFlowerPicker(int x, int y, GameState state) {
        super(x, y, "sunflowerpicker.jpg", "sunflower.gif",state);
=======
class SunFlowerPicker extends PlantsPicker {

    SunFlowerPicker(int x, int y, GameState state) {
        super(x, y, "sunflowerpicker.jpg", "sunflower.gif", state);
>>>>>>> new code
    }

    @Override
    int getValue() {
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
        return 50;
    }

    @Override
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new SunFlower(0, 0,gameState);

=======
        return 0;
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new SunFlower(0, 0, gameState);
>>>>>>> new code
    }
}


