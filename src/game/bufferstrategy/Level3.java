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

        int Delays = 0;
        Delays = makeRandomZombiesOfType(ZombieType.Regular, 5, grassRows, Delays);
        makeRandomZombiesOfType(ZombieType.BucketHead, 3, grassRows, Delays);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(setDefaultPicker(new PeaShooterPicker(60, 10, state)));
        state.addDrawables(new SunFlowerPicker(112, 10, state));
        state.addDrawables(new IcedPeaShooterPicker(164, 10, state));
        state.addDrawables(new MushroomPicker(216, 10, state));

    }
}

