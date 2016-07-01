package game.bufferstrategy;

/**
 * Created by saeedehspg on 7/1/16.
 */
class BasketBall extends GameObject {
    private int originY;
    private int shootStart;
    private int shootEnd;

    BasketBall(CatapultBasketBallZombie catapultBasketBallZombie, GameState gameState, int y, int startX, int endX) {
        super(catapultBasketBallZombie.x, catapultBasketBallZombie.y, "ball.jpg", 20, 20, gameState, 6, Integer.MAX_VALUE);
        originY = y;
        shootStart = startX;
        shootEnd = endX;
    }

    @Override
    void move() {
        super.move();
        if (x > shootEnd)
            y = (int) (originY + (0.005 * (x-shootStart) * (x-shootEnd)));
    }
    @Override
    void update() {
        super.update();

        GameObject collidedPlant = getCollidedPlant();
        if (collidedPlant != null) {
            collidedPlant.hurt(15);
            life = 0;
        }
    }
}
