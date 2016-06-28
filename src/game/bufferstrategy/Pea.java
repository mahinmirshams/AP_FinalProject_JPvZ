package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/26/2016 AD.
 */
class Pea extends GameObject {
    Pea(PeaShooter peaShooter, GameState gameState) {
        super(peaShooter.x + 40, peaShooter.y + 10, "Pea.png", 20, 20, gameState, -6, Integer.MAX_VALUE);
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


