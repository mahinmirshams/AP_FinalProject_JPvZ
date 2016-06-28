package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
public class IcedPeaShooterPicker extends PlantsPicker {

    public IcedPeaShooterPicker(int x, int y, GameState state) {
        super(x, y, "IcedPeaShooter.jpg", "Snow_Pea_(HD_size).png", state);
=======
class IcedPeaShooterPicker extends PlantsPicker {

    IcedPeaShooterPicker(int x, int y, GameState state) {
        super(x, y, "IcedPeaShooterPicker.jpg", "Snow_Pea_(HD_size).png", state);
>>>>>>> new code
    }

    @Override
    int getValue() {
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
        return 0;
    }

    @Override
    void onclicked(GameState gameState) {
        super.onclicked(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new IcedPeaShooter(0, 0 , gameState);

=======
        return 175;
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new IcedPeaShooter(0, 0, gameState);
>>>>>>> new code
    }
}