package game.bufferstrategy;

import java.awt.*;

/**
 * Created by saeedehspg on 6/21/2016 AD.
 */
public class Drawable {

    Image img;
    int x;
    int y;
    int width;
    int height;
    public Drawable(int x, int y , String file, int width, int height){
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        img = Toolkit.getDefaultToolkit().getImage("D:\\unversity\\2\\AP\\Assingment\\final project\\GameStructure\\out\\production\\GameStructure\\game\\bufferstrategy\\images\\"+file);

    }
    public void draw(Graphics2D g2d) throws InterruptedException {
        g2d.drawImage(img, x, y, width,height, null);
    }
}
