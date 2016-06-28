package game.bufferstrategy;

/**
 * Created by saeedehspg on 6/23/16.
 */

import java.io.InputStream;
import java.util.TimerTask;
import javazoom.jl.player.Player;

class Sound extends TimerTask {

    @Override
    public void run() {

        try {
            InputStream file = ClassLoader.getSystemResourceAsStream("sounds/level1.mp3");
            Player playMP3 = new Player(file);
            playMP3.play();
        } catch (Exception e) {
            System.out.println("Error while playing sound");
        }

    }
}