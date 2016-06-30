package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/27/2016 AD.
 */
abstract class Plant extends GameObject {
    Plant(int x, int y, String file, int width, int height, GameState gameState, int speed, int life) {
        super(x, y, file, width, height, gameState, speed, life);
    }

    @Override
    void move() {
        super.move();

        if (x > 1100) {
            this.life = 0;
        }
    }
}
