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

        makeRandomZombiesOfType(ZombieType.Regular, 4, grassRows);
        makeRandomZombiesOfType(ZombieType.BucketHead, 2, grassRows);
        makeRandomZombiesOfType(ZombieType.PoleVaulting, 2, grassRows);
        makeRandomZombiesOfType(ZombieType.CatapultBasketBall, 5, grassRows);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(setDefaultPicker(new PeaShooterPicker(65, 57, state)));
        state.addDrawables(new SunFlowerPicker(130, 57, state));
        state.addDrawables(new IcedPeaShooterPicker(195, 57, state));
        state.addDrawables(new WalNutPicker(260,57, state));
        state.addDrawables(new CherryBombPicker(325, 57, state));
    }
}