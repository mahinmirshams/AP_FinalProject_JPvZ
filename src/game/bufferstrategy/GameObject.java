package game.bufferstrategy;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by saeedehspg on 6/25/2016 AD.
 */
abstract class GameObject extends Drawable {

    int speed;
    int life;

    GameObject(int x, int y, String file, int width, int height, GameState gameState, int speed, int life) {
        super(x, y, file, width, height, gameState);
        this.speed = speed;
        this.life = life;
    }

    void move() {
        x -= speed;
    }

    void changeSpeed(int speed) {
        this.speed = speed;
    }

    void hurt(int strength) {
        life -= strength;
        if (life < 0)
            life = 0;
    }

    boolean isDeletable() {
        return life == 0;
    }

    void deleteObject() {

    }

    void update() {
        if (gameState.states > 1)
            move();
    }

    void planted() {

    }

    GameObject getCollidedZombie() {
        Iterator<Drawable> iterator = gameState.getDrawables().iterator();
        while (iterator.hasNext()) {
            Drawable drawable = iterator.next();
            if (drawable instanceof Zombie) {
                if (
                        (
                                (x < drawable.x + drawable.width && x >= drawable.x) ||
                                (x + width >= drawable.x && x + width <= drawable.x + drawable.width)
                        ) &&
                        (
                                (y > drawable.y && y <= drawable.y + drawable.height) ||
                               (y + height >= drawable.y && (y + height <= drawable.height + drawable.y))
                        )
                ) {
                    return (GameObject) drawable;
                }
            }
        }
        return null;
    }

    GameObject getCollidedPlant() {
        Iterator<Selectable> iterator = new ArrayList<Selectable>(gameState.selectables).iterator();
        while (iterator.hasNext()) {
            Selectable selectable = iterator.next();

            if (!selectable.isEmpty() &&
                    (
                            (x < selectable.x + selectable.currentPlant.width && x > selectable.currentPlant.x) ||
                            (x + width > selectable.currentPlant.x && x + width < selectable.currentPlant.x + selectable.currentPlant.width)
                    ) &&
                    (
                            (y > selectable.currentPlant.y && y < selectable.currentPlant.y + selectable.currentPlant.height) ||
                            (y + height > selectable.currentPlant.y && (y + height < selectable.currentPlant.height + selectable.currentPlant.y))
                    )
            ) {
                return selectable.currentPlant;
            }
        }

        return null;
    }
}
