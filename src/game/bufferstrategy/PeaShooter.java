package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/2016 AD.
 */
public class PeaShooter extends GameObject {
    @Override
    int getStateToVisible() {
        return 2;
    }
    public PeaShooter(int x, int y, GameState state) {
        super(x,y,"Repeater_HD_HD.png",70, 100, state ,0,100);

    }
}
