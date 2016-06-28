package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
public class PeaShooterPicker extends PlantsPicker {

    public PeaShooterPicker(int x, int y, GameState state) {
=======
class PeaShooterPicker extends PlantsPicker {

    PeaShooterPicker(int x, int y, GameState state) {
>>>>>>> new code
        super(x, y, "IMG_1395-04-01 17:05:47.jpg", "Repeater_HD_HD.png", state);
    }

    @Override
    int getValue() {
        return 100;
    }

    @Override
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new PeaShooter(0, 0 , gameState);

=======
    void onClick(GameState gameState) {
        super.onClick(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new PeaShooter(0, 0, gameState);
>>>>>>> new code
    }
}