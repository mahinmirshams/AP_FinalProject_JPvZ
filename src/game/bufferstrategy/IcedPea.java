package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/26/2016 AD.
 */
public class IcedPea extends GameObject {
    public IcedPea(IcedPeaShooter icedPeaShooter,GameState gameState) {
        super(icedPeaShooter.x+40, icedPeaShooter.y+10, "Giant_Pea2.png", 20, 20, gameState, -2, Integer.MAX_VALUE);
    }

    @Override
    int getStateToVisible() {

        return 2;
    }

}
