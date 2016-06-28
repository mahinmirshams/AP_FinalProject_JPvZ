package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/26/2016 AD.
 */
class IcedPea extends GameObject {
    IcedPea(IcedPeaShooter icedPeaShooter, GameState gameState) {
        super(icedPeaShooter.x + 40, icedPeaShooter.y + 10, "Giant_Pea2.png", 20, 20, gameState, -6, Integer.MAX_VALUE);
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
            ((Zombie) gameObject).getIcy();
            gameObject.hurt(25);
            life = 0;
        }
    }
}
