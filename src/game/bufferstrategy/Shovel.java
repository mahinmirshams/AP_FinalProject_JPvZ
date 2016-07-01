package game.bufferstrategy;

/**
 * Created by mahin mirshams on 7/1/2016.
 */
public class Shovel extends PlantsPicker {
    Shovel(int x, int y, GameState state) {
        super(x, y, "dig.png", "dig.png", state);
    }



    @Override
    int getValue() {
        return 0;
    }

    @Override
        void onClick() {
            super.onClick();

               gameState.digISOn = true;


    }
}
