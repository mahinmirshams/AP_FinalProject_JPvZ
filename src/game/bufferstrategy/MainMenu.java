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

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

/**
 * Created by mahin mirshams on 7/1/2016.
 */
public class MainMenu {
    static GameFrame mainframe ;
    public MainMenu(String s){

    }

        GameState state;
        JFrame frame ;


        public MainMenu() {
            EventQueue.invokeLater(new Runnable() {
                @Override
                public void run() {
                    try {
                        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    } catch (Exception ex) {
                    }
                    frame = new JFrame("SelectMenu");
                    frame.setUndecorated(true);
                    frame.setContentPane(new ContentPane());

                    if (supportsPerAlphaPixel()) {
                        setOpaque(frame, false);
                    }
                    frame.setLayout(new BorderLayout());
                    frame.add(new ImagePane());
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }
            });
        }

        public static boolean supportsPerAlphaPixel() {

            boolean support = false;

            try {

                support = true;

            } catch (Exception exp) {
            }

            return support;

        }

        public static void setOpaque(Window window, boolean opaque) {

            try {

                Class<?> awtUtilsClass = Class.forName("com.sun.awt.AWTUtilities");
                if (awtUtilsClass != null) {

                    Method method = awtUtilsClass.getMethod("setWindowOpaque", Window.class, boolean.class);
                    method.invoke(null, window, opaque);

                }

            } catch (Exception exp) {
            }

        }

        public class ContentPane extends JPanel {

            public ContentPane() {
                setOpaque(false);
            }

            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
            }
        }

        public class ImagePane extends JPanel {

            private BufferedImage background;

            private BufferedImage exitImage;
            private BufferedImage continueImg;
            private BufferedImage startImg;
            private BufferedImage guideImg;

            private Ellipse2D exitButton;
            private Ellipse2D continueButton;
            private Ellipse2D startButton;
            private Ellipse2D guideButton;



            private boolean mouseIn = false;

            public ImagePane() {
                setOpaque(false);

                    background = (BufferedImage) Main.loadImage("MainMenu.png");

                    exitImage = (BufferedImage) Main.loadImage("none.png");
                    continueImg = (BufferedImage) Main.loadImage("none.png");
                    startImg = (BufferedImage) Main.loadImage("none.png");
                    guideImg = (BufferedImage) Main.loadImage("none.png");


                exitButton = new Ellipse2D.Float(5, 480, 200,100);
                startButton = new Ellipse2D.Float(575, 330, 200, 100);
                continueButton = new Ellipse2D.Float(580, 180, 200, 100);
                guideButton = new Ellipse2D.Float(775, 610, 200, 44);



                MouseAdapter handler = new MouseAdapter() {


                    @Override
                    public void mousePressed(MouseEvent e) {

                        Cursor cursor = Cursor.getDefaultCursor();
                        if (exitButton.contains(e.getPoint())) {
                            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                            System.exit(1);
                        }


                        if (guideButton.contains(e.getPoint())) {
                            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                            GuideFrame guideFrame = new GuideFrame();
                        }

                        if (startButton.contains(e.getPoint())) {
                            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                            frame.dispose();
                            // After the player clicks 'PLAY' ...
                            EventQueue.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    mainframe = new GameFrame("Java Plants vs Zombies");
                                    mainframe.setLocationRelativeTo(null); // put frame at center of screen
                                    mainframe.setUndecorated(true);
                                    mainframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
                                    mainframe.setVisible(true);
                                    mainframe.initBufferStrategy();
                                    // Create and execute the game-loop
                                    GameLoop game = new GameLoop(mainframe);
                                    game.init();
                                    ThreadPool.execute(game);
                                    // and the game starts ...
                                }
                            });


                        }
                        if (continueButton.contains(e.getPoint())) {//TODO start from a specific level saved
                            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);



                        }
                        setCursor(cursor);

                    }

                    @Override
                    public void mouseMoved(MouseEvent e) {
                        Cursor cursor = Cursor.getDefaultCursor();
                        if (exitButton.contains(e.getPoint())) {
                            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                        }
                        if (startButton.contains(e.getPoint())) {
                            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);


                        }
                        if (guideButton.contains(e.getPoint())) {
                            cursor = Cursor.getPredefinedCursor(Cursor.HAND_CURSOR);
                        }
                        if (continueButton.contains(e.getPoint())) {//TODO select the level to start from
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

                        g2d.drawImage(exitImage, (int) exitButton.getX(), (int) exitButton.getY(), this);
                        g2d.drawImage(continueImg, (int) continueButton.getX(), (int)continueButton.getY(), this);
                        g2d.drawImage(startImg, (int) startButton.getX(), (int) startButton.getY(), this);
                        g2d.drawImage(guideImg, (int) guideButton.getX(), (int) guideButton.getY(), this);

                    }
                    g2d.dispose();
                }
            }
        }
    }
