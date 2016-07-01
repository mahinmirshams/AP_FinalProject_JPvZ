package game.bufferstrategy;

/**
 * Created by mahin mirshams on 6/28/2016.
 */
public class PoleVaultingZombie extends Zombie{

    private enum PoleZombieState {
        Walking,
        jumping,
        Chewing
    }

    public PoleVaultingZombie(int x, int y, GameState state) {

        super(x, y, state, "HD_Polevaulterzombie 2.png" , "HD_PolevaulterzombieIcy.png");
    }


}
