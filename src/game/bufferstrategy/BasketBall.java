package game.bufferstrategy;

/**
 * Created by saeedehspg on 7/1/16.
 */
public class BasketBall extends GameObject {
    BasketBall(CatapultBasketBallZombie catapultBasketBallZombie, GameState gameState) {
        super(catapultBasketBallZombie.x + 40, catapultBasketBallZombie.y + 10, "ball.jpg", 20, 20, gameState, 6, Integer.MAX_VALUE);
    }
}
