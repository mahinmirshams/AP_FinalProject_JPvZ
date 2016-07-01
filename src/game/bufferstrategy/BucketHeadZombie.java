package game.bufferstrategy;

/**
 * Created by mahin mirshams on 6/27/2016.
 */
public class BucketHeadZombie extends Zombie{

    @Override

    int getStateToVisible() {
        return 2;
    }

    BucketHeadZombie(int x, int y, GameState state) {
        super(x, y, state, "conehead.gif", "coneheadicy.png");  //TODO : fix the icy
    }
}
