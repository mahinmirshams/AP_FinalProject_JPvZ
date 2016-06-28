package game.bufferstrategy;

/**
 * Created by mahin mirshams on 6/27/2016.
 */
public class BucketHeadZombie extends Zombie{

    @Override

    int getStateToVisible() {
        return 2;
    }

    public BucketHeadZombie(int x, int y,GameState state , String bucketHeadZombie  , String IcedBucketHeadZombie) {
        super(x, y, state , bucketHeadZombie , IcedBucketHeadZombie);
    }

}
