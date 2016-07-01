package game.bufferstrategy;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import static com.sun.awt.AWTUtilities.setWindowOpaque;

/**
 * Created by mahin mirshams on 7/1/2016.
 */
class SelectMenu  {
    MainMenu test  ;
    GameState state;
    private JFrame frame ;

    SelectMenu() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ignored) {}

                frame = new JFrame("SelectMenu");
                frame.setUndecorated(true);
                frame.setContentPane(new ContentPane());

                setWindowOpaque(frame, false);

                frame.setLayout(new BorderLayout());
                frame.add(new ImagePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                try {
                    frame.setIconImage(ImageIO.read(new File("D:\\unversity\\2\\AP\\Assingment\\final project\\GameStructure 2\\GameStructure\\src\\images\\zombieHead.png")));
                } catch (IOException exc) {
                    exc.printStackTrace();
                }
            }
        });
    }

    private class ContentPane extends JPanel {

        ContentPane() {
            setOpaque(false);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
        }
    }

    private class ImagePane extends JPanel {

        private BufferedImage background;
        private BufferedImage exitImage;
        private BufferedImage return2MenuImg;
        private BufferedImage continueImg;
        private Ellipse2D exitButton;
        private Ellipse2D return2MenuButton;
        private Ellipse2D continueButton;

        private Ellipse2D exitButton2;
        private Ellipse2D return2MenuButton2;
        private Ellipse2D continueButton2;

        private boolean mouseIn = false;

        ImagePane() {
            setOpaque(false);

                background = (BufferedImage) Main.loadImage("SelectMenu.png");
                exitImage = (BufferedImage) Main.loadImage("exitButton.png");
                return2MenuImg = (BufferedImage) Main.loadImage("returnToMainMenuButton.png");
                continueImg = (BufferedImage) Main.loadImage("button2.png");

            exitButton = new Ellipse2D.Float(110, 410, 200, 44);
            continueButton = new Ellipse2D.Float(110, 315, 200, 44);
            return2MenuButton = new Ellipse2D.Float(110, 265, 200, 44);


            exitButton2 = new Ellipse2D.Float(110, 405, 200, 44);
            continueButton2 = new Ellipse2D.Float(110, 310, 200, 44);
            return2MenuButton2 = new Ellipse2D.Float(110, 260, 200, 44);

            MouseAdapter handler = new MouseAdapter() {


                @Override
                public void mousePressed(MouseEvent e) {

                    Cursor cursor = Cursor.getDefaultCursor();
                    if (exitButton.contains(e.getPoint())) {
                        cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                        System.exit(1);
                    }
                    if (continueButton.contains(e.getPoint())) {//TODO : select the level and start from that
                        cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                        // GuideFrame guideFrame = new GuideFrame();
                        frame.dispose();


                    }
                    if (return2MenuButton.contains(e.getPoint())) {
                        cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                        test = new MainMenu("");

                        test.mainframe.dispose();
                        frame.dispose();
                        new MainMenu();


                    }
                    setCursor(cursor);

                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    Cursor cursor = Cursor.getDefaultCursor();
                    if (exitButton2.contains(e.getPoint())) {
                        cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                    }
                    if (continueButton2.contains(e.getPoint())) {
                        cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                    }
                    if (return2MenuButton2.contains(e.getPoint())) {
                        cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                    }
                    setCursor(cursor);
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    mouseIn = true;
                    repaint();
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    mouseIn = false;
                    repaint();
                }

            };
            addMouseListener(handler);
            addMouseMotionListener(handler);
        }

        @Override
        public Dimension getPreferredSize() {
            return background == null ? new Dimension(400, 400) : new Dimension(background.getWidth(), background.getHeight());
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (background != null) {
                Graphics2D g2d = (Graphics2D) g.create();
                int x = (getWidth() - background.getWidth()) / 2;
                int y = (getHeight() - background.getHeight()) / 2;
                g2d.drawImage(background, x, y, this);
                if (mouseIn && exitImage != null) {
                    g2d.drawImage(exitImage, (int) exitButton2.getX(), (int) exitButton2.getY(), this);
                    g2d.drawImage(return2MenuImg, (int) return2MenuButton2.getX(), (int)return2MenuButton2.getY(), this);
                    g2d.drawImage(continueImg, (int) continueButton2.getX(), (int) continueButton2.getY(), this);

                }

                if(!mouseIn){

                    g2d.drawImage(exitImage, (int) exitButton.getX(), (int) exitButton.getY(), this);
                    g2d.drawImage(return2MenuImg, (int) return2MenuButton.getX(), (int)return2MenuButton.getY(), this);
                    g2d.drawImage(continueImg, (int) continueButton.getX(), (int) continueButton.getY(), this);

                }
                g2d.dispose();
            }
        }
    }
}
