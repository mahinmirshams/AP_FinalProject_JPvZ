package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class SunFlower extends GameObject {
    @Override
    int getStateToVisible() {
        return 2;
    }
    public SunFlower(int x, int y, GameState state) {
        super(x,y,"sunflower.gif",70, 100, state,0,100);

    }
}
