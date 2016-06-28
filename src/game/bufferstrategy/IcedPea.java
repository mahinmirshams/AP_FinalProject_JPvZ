package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/26/2016 AD.
 */
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
public class IcedPea extends GameObject {
    public IcedPea(IcedPeaShooter icedPeaShooter,GameState gameState) {
        super(icedPeaShooter.x+40, icedPeaShooter.y+10, "Giant_Pea2.png", 20, 20, gameState, -2, Integer.MAX_VALUE);
=======
class IcedPea extends GameObject {
    IcedPea(IcedPeaShooter icedPeaShooter, GameState gameState) {
        super(icedPeaShooter.x + 40, icedPeaShooter.y + 10, "Giant_Pea2.png", 20, 20, gameState, -6, Integer.MAX_VALUE);
>>>>>>> new code
    }

    @Override
    int getStateToVisible() {
<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06

        return 2;
    }

=======
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
>>>>>>> new code
}
