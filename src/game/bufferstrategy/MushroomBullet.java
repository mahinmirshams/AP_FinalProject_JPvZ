package game.bufferstrategy;

/**
 * Created by mahin mirshams on 7/1/2016.
 */
public class MushroomBullet extends GameObject  {
    MushroomBullet(Mushroom mushroom, GameState gameState) {
    super(mushroom.x + 40, mushroom.y + 35, "tuff.png", 20, 20, gameState, -6, Integer.MAX_VALUE);
}

    @Override
    int getStateToVisible() {
        return 2;
    }

    @Override
    void update() {
        super.update();
        GameObject gameObject = getCollidedZombie();
        if (gameObject != null && gameObject instanceof Zombie) {
            gameObject.hurt(50);
            life = 0;
        }
    }
}
