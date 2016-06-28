package game.bufferstrategy;

<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
/**
 * Created by saeedehspg on 6/25/2016 AD.
 */
public class GameObject extends Drawable {
=======
import java.util.Iterator;

/**
 * Created by saeedehspg on 6/25/2016 AD.
 */
abstract class GameObject extends Drawable {
>>>>>>> new code

    int speed;
    int life;

<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
    public GameObject(int x, int y , String file, int width, int height, GameState gameState , int speed, int life){
        super(x,y,file,width,height,gameState);
        this.speed=speed;
        this.life=life;
    }

    void move (){
        x-=speed;
    }
     void changeSpeed(int speed){
         this.speed=speed;
     }
    void hurt(int strength){
        life -=strength;
        if (life<0)
            life=0;
    }
    boolean isDeletable(){
        return life==0;
    }

    void deleteObject(){

    }

    void update(){
        if (gameState.states>=2)
        move();
    }

    void planted(){

    }

    GameObject getCollidedObject(){
        for (Drawable drawable : gameState.drawables){
            if(drawable instanceof GameObject){
               if(x+width>=drawable.x && ((y>drawable.y && y<=drawable.y+drawable.height) || (y+height<=drawable.y))){
//                   return
               }
=======
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
        for (Iterator<Drawable> iterator = gameState.drawables.iterator(); iterator.hasNext(); ) {
            Drawable drawable = iterator.next();
            if (drawable instanceof GameObject) {
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
>>>>>>> new code
            }
        }
        return null;
    }

<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
=======
    GameObject getCollidedPlant() {
        for (Selectable selectable : gameState.selectables) {

            if (!selectable.isEmpty() &&
                    (
                            (x < selectable.x + selectable.currentPlant.width && x >= selectable.currentPlant.x) ||
                            (x + width >= selectable.currentPlant.x && x + width <= selectable.currentPlant.x + selectable.currentPlant.width)
                    ) &&
                    (
                            (y > selectable.currentPlant.y && y <= selectable.currentPlant.y + selectable.currentPlant.height) ||
                            (y + height >= selectable.currentPlant.y && (y + height <= selectable.currentPlant.height + selectable.currentPlant.y))
                    )
            ) {
                return selectable.currentPlant;
            }
        }

        return null;
    }
>>>>>>> new code
}
