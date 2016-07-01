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

/**
 * Created by mahin mirshams on 7/1/2016.
 */
public class SelectMenu {

    public SelectMenu() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception ex) {
                }

                JFrame frame = new JFrame("SelectMenu");
                frame.setUndecorated(true);
                frame.setContentPane(new ContentPane());

                    if (supportsPerAlphaPixel()) {
                        setOpaque(frame, false);
                }
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        private BufferedImage offImage;
        private BufferedImage button2;
        private Ellipse2D offButton;
        private Ellipse2D button2_1;
        private boolean mouseIn;

        public ImagePane() {
            setOpaque(false);
            try {
                background = ImageIO.read(new File("/Users/Applestore/IdeaProjects/AP_FinalProject_JPvZ/src/images/SelectMenu.png"));
                offImage = ImageIO.read(new File("/Users/Applestore/IdeaProjects/AP_FinalProject_JPvZ/src/images/exitButton.png"));
                button2 = ImageIO.read(new File("/Users/Applestore/IdeaProjects/AP_FinalProject_JPvZ/src/images/returnToMainMenuButton.png"));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            offButton = new Ellipse2D.Float(110, 300, 25, 25);
            button2_1 = new Ellipse2D.Float(110, 400, 25, 25);
            MouseAdapter handler = new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                /*    if (e.getClickCount() == 1 && e.getButton() == MouseEvent.BUTTON1) {
                        if (offButton.contains(e.getPoint())) {
                            Window window = SwingUtilities.getWindowAncestor(ImagePane.this);
                            if (window != null) {
                                window.dispose();
                            }
                        }
                    }
                */}

                @Override
                public void mousePressed(MouseEvent mouseEvent) {
                    System.exit(1);
                }

                @Override
                public void mouseMoved(MouseEvent e) {
                    Cursor cursor = Cursor.getDefaultCursor();
                    if (offButton.contains(e.getPoint())) {
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
                if (mouseIn && offImage != null) {
                    g2d.drawImage(offImage, (int) offButton.getX(), (int) offButton.getY(), this);
                    g2d.drawImage(button2, (int) button2_1.getX(), (int) button2_1.getY(), this);
                }
                g2d.dispose();
            }
        }
    }
}
