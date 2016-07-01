package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/29/16.
 */
class Level1 extends Level {

    Level1(GameState state) {
        super(state);
    }

    @Override
    void init() {
        int grassRows = 1;

        int Delays = 0;
        makeRandomZombiesOfType(ZombieType.Regular, 5, grassRows, Delays);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(setDefaultPicker(new PeaShooterPicker(60, 10, state)));
        state.addDrawables(new SunFlowerPicker(112, 10, state));
    }
}
