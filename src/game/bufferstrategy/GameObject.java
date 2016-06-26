package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/25/2016 AD.
 */
public class GameObject extends Drawable {

    int speed;
    int life;

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
            }
        }
        return null;
    }

}
