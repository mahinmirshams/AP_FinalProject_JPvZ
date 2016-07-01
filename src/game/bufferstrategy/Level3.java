package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/29/16.
 */
class Level3 extends Level {

    Level3(GameState state) {
        super(state);
    }

    @Override
    void init() {
        int grassRows = 5;

        makeRandomZombiesOfType(ZombieType.Regular, 5, grassRows);
        makeRandomZombiesOfType(ZombieType.BucketHead, 3, grassRows);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(new PeaShooterPicker(65, 57, state));
        state.addDrawables(new SunFlowerPicker(130, 57, state));
        state.addDrawables(new IcedPeaShooterPicker(195, 57, state));
    }
}

