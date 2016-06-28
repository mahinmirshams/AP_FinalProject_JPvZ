<<<<<<< cebf1c9610a2bfe6f2e20cad6fecf3dd96acfc06
//package game.bufferstrategy;
//
///**
// * Created by Applestore on 6/23/16.
// */
// import java.io.FileInputStream;
//
//        import javazoom.jl.player.Player;
//
//public class Sound extends Thread {
//
//    private int num;
//
//    public Sound() {
//        // TODO Auto-generated constructor stub
//    }
//
//    @Override
//    public void run() {
//
//            // TODO Auto-generated method stub
//            try {
//                FileInputStream file = new FileInputStream("/Users/Applestore/IdeaProjects/GameStructure/src/John Lennon - Imagine.mp3");
//                Player playMP3 = new Player(file);
//                playMP3.play();
//            } catch (Exception e) {
//                System.out.println("not   sounddddddddddddddddddddddddddddddddddddddddddddddd");
//            }
//
//    }
//
//}
=======
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
>>>>>>> new code
