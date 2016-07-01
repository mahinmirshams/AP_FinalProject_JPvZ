package game.bufferstrategy;



public class MenuButton extends Drawable {

    public MenuButton(int x, int y, String file, int width, int height, GameState gameState) {
        super(x, y, file, width, height, gameState);
    }

    @Override
    void onClick(GameState gameState) {
        super.onClick(gameState);
        SelectMenu selectMenu = new SelectMenu();
    }
}
