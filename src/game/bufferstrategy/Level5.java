package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/29/16.
 */
class Level5 extends Level {

    Level5(GameState state) {
        super(state);
    }

    @Override
    void init() {
        int grassRows = 5;

        int Delays = 0;
        Delays = makeRandomZombiesOfType(ZombieType.Regular, 4, grassRows, Delays);
        Delays = makeRandomZombiesOfType(ZombieType.BucketHead, 2, grassRows, Delays);
        Delays = makeRandomZombiesOfType(ZombieType.PoleVaulting, 2, grassRows, Delays);
        makeRandomZombiesOfType(ZombieType.CatapultBasketBall, 5, grassRows, Delays);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(setDefaultPicker(new PeaShooterPicker(60, 10, state)));
        state.addDrawables(new SunFlowerPicker(112, 10, state));
        state.addDrawables(new IcedPeaShooterPicker(164, 10, state));
        state.addDrawables(new MushroomPicker(216, 10, state));
        state.addDrawables(new WalNutPicker(268,10, state));
        state.addDrawables(new CherryBombPicker(320, 10, state));
    }
}