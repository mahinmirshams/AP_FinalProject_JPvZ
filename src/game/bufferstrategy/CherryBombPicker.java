package game.bufferstrategy;

/**
 * Created by mahin mirshams on 6/26/2016.
 */
class CherryBombPicker extends PlantsPicker {

    CherryBombPicker(int x, int y, GameState state) {
        super(x, y, "CherryBombPicker.jpg", "CherryBomb.png", state);
    }

    @Override
    int getValue() {
        return 0;
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        if (gameState.money >= getValue())
            gameState.selectedItem = new CherryBomb(0, 0, gameState);
    }
}
