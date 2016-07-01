package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/29/16.
 */
class Level4 extends Level {

    Level4(GameState state) {
        super(state);
    }

    @Override
    void init() {
        int grassRows = 5;

        makeRandomZombiesOfType(ZombieType.Regular, 4, grassRows);
        makeRandomZombiesOfType(ZombieType.BucketHead, 2, grassRows);
        makeRandomZombiesOfType(ZombieType.PoleVaulting, 2, grassRows);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(setDefaultPicker(new PeaShooterPicker(60, 10, state)));
        state.addDrawables(new SunFlowerPicker(112, 10, state));
        state.addDrawables(new IcedPeaShooterPicker(164, 10, state));
        state.addDrawables(new MushroomPicker(216, 10, state));
        state.addDrawables(new WalNutPicker(268,10, state));
    }
}