package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/29/16.
 */
class Level2 extends Level {

    Level2(GameState state) {
        super(state);
    }

    @Override
    void init() {
        int grassRows = 3;

        makeRandomZombiesOfType(ZombieType.Regular, 10, grassRows);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(new PeaShooterPicker(65, 57, state));
        state.addDrawables(new SunFlowerPicker(130, 57, state));
        state.addDrawables(new IcedPeaShooterPicker(195, 57, state));
    }
}