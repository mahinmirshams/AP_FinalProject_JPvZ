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

        makeRandomZombiesOfType(ZombieType.Regular, 5, grassRows);

        super.init();

        drawGrasses(grassRows);

        state.addDrawables(setDefaultPicker(new PeaShooterPicker(65, 57, state)));
        state.addDrawables(new SunFlowerPicker(130, 57, state));
    }
}
