package game.bufferstrategy;

class MenuButton extends Drawable {

    MenuButton(int x, int y, String file, int width, int height, GameState gameState) {
        super(x, y, file, width, height, gameState);
    }

    @Override
    void onClick() {
        super.onClick();
        new SelectMenu();
    }
}
