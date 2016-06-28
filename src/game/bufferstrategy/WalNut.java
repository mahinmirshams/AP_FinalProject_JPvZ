package game.bufferstrategy;

/**
 * Created by mahin mirshams on 6/26/2016.
 */
class WalNut extends Plant {

    @Override
    int getStateToVisible() {
        return 2;
    }

    WalNut(int x, int y, GameState state) {
        super(x, y, "WalNut.png", 70, 100, state, 0, 300);
    }
}
