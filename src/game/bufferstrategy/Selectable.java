package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/22/2016 AD.
 */
public class Selectable {
    int x;
    int y;
    private Drawable currentDrawable = null;
    public Selectable(int x, int y){
     this.x = x;
     this.y = y;
    }

    boolean isEmpty(){
        return currentDrawable == null;
    }

    boolean plant(Drawable drawable){
        if(!isEmpty())
            return false;
        currentDrawable = drawable;
        return true;
    }

}
