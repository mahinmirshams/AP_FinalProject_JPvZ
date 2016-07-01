/***
 * In The Name of Allah
 ***/
package game.bufferstrategy;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.*;

/**
 * A very simple structure for the main game loop.
 * THIS IS NOT PERFECT, but works for most situations.
 * Note that to make this work, none of the 2 methods
 * in the while loop (update() and render()) should be
 * long running! Both must execute very quickly, without
 * any waiting and blocking!
 * <p>
 * Detailed discussion on different game loop design
 * patterns is available in the following link:
 * http://gameprogrammingpatterns.com/game-loop.html
 *
 * @author Seyed Mohammad Ghaffarian
 */
class GameLoop implements Runnable {

    /**
     * Frame Per Second.
     * Higher is better, but any value above 24 is fine.
     */
    private static final int FPS = 30;


    private GameFrame canvas;
    private GameState state;


    GameLoop(GameFrame frame) {
        canvas = frame;
        state = new GameState();
    }

    /**
     * This must be called before the game loop starts.
     */
    void init() {
        // Perform all initializations ...
        state.currentLevel = new Level1(state);
        state.currentLevel.init();

        canvas.addKeyListener(state.getKeyListener());
        canvas.addMouseListener(state.getMouseListener());
        canvas.addMouseMotionListener(state.getMouseMotionListener());
        canvas.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Drawable clickedItem = getClickedItem(e.getX(), e.getY());
                Selectable clickedSelectable = getClickedSelectable(e.getX(), e.getY());

                if (clickedSelectable != null && state.selectedItem != null) {
                    if (clickedSelectable.isEmpty())
                        clickedSelectable.plant(state);
                }
                if (clickedItem != null) {
                    clickedItem.onClick(state);
                    if (clickedItem instanceof Sun) state.deleteDrawable(clickedItem);
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        //state.drawables.add(new LawnMover(270, 150,state));

        //1st 2nd levels pickers
//        state.drawables.add(new PeaShooterPicker(65, 57, state));
//        state.drawables.add(new SunFlowerPicker(130, 57, state));

//        Timer drawGrassTimer = new Timer();

//        final Grass grassRow1 = new Grass(390, 50, state);
//        final RollingGrass rollingGrass1 = new RollingGrass(390, 50, state);
//        final Grass grassRow2 = new Grass(390, 150, state);
//        final RollingGrass rollingGrass2 = new RollingGrass(390, 150, state);
//        final Grass grassRow3 = new Grass(390, 250, state);
//        final RollingGrass rollingGrass3 = new RollingGrass(390, 250, state);
//        final Grass grassRow4 = new Grass(390, 350, state);
//        final RollingGrass rollingGrass4 = new RollingGrass(390, 350, state);
//        final Grass grassRow5 = new Grass(390, 450, state);
//        final RollingGrass rollingGrass5 = new RollingGrass(390, 450, state);

//        state.drawables.add(grassRow1);
//        state.drawables.add(rollingGrass1);
////        state.drawables.add(grassRow2);
////        state.drawables.add(rollingGrass2);
//////        state.drawables.add(grassRow3);
//////        state.drawables.add(rollingGrass3);
////        state.drawables.add(grassRow4);
////        state.drawables.add(rollingGrass4);
//        state.drawables.add(grassRow5); //TODO:uncomment
//        state.drawables.add(rollingGrass5);


//        grassRow3.state = Grass.GrassState.Growing;
//        rollingGrass3.state = RollingGrass.RollingGrassState.Rolling;

//        if (grassRows == 1) {
//            grassRow1.selfDestruction();
//            rollingGrass1.selfDestruction();
//            grassRow2.selfDestruction();
//            rollingGrass2.selfDestruction();
//            grassRow4.selfDestruction();             //TODO:check this
//            rollingGrass4.selfDestruction();
//            grassRow5.selfDestruction();
//            rollingGrass5.selfDestruction();
//        }

//        if (grassRows == 3) {
//            grassRow1.selfDestruction();
//            rollingGrass1.selfDestruction();
//            grassRow5.selfDestruction();
//            rollingGrass5.selfDestruction();
//        }


//        if (grassRows > 1) {
//            drawGrassTimer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    grassRow2.state = Grass.GrassState.Growing;
//                    rollingGrass2.state = RollingGrass.RollingGrassState.Rolling;
//                    grassRow4.state = Grass.GrassState.Growing;
//                    rollingGrass4.state = RollingGrass.RollingGrassState.Rolling;
//
//                    grassRow1.selfDestruction();
//                    rollingGrass1.selfDestruction();
//                    grassRow5.selfDestruction();
//                    rollingGrass5.selfDestruction();
//
//                }
//            }, 2000L);
//        }
//
//        if (grassRows > 3) {
//            drawGrassTimer.schedule(new TimerTask() {
//                @Override
//                public void run() {
//                    grassRow1.state = Grass.GrassState.Growing;
//                    rollingGrass1.state = RollingGrass.RollingGrassState.Rolling;
//                    grassRow5.state = Grass.GrassState.Growing;
//                    rollingGrass5.state = RollingGrass.RollingGrassState.Rolling;
//                }
//            }, 3000L);
//        }
//
//        if(state.level==1) {
//           final Random rand = new Random();
//
//            int valueTimeReg = rand.nextInt(5000);
//            valueTimeReg += 5000;
//            int valueTimeBuck = rand.nextInt(5000);
//            valueTimeBuck += 16000;  // Random between 5 and 13 seconds
//            TimerTask regZombie = new TimerTask() {
//                @Override
//                public void run() {
//                    final int value = rand.nextInt(1);
//                    Zombie z = new RegularZombie(1100, zombieEntrance[value], state);
//                    state.drawables.add(z);
//                    zombieSifficiency++;
//                    if (zombieSifficiency == 2) {
//                        state.level++;
//                        grassRows = 3;
//                        update();
//                    }
//                }
//            };
//
//
//            Timer timer = new Timer();
//            timer.schedule(regZombie, 15000L, valueTimeReg);
//


        //   }

//        if(state.level==2) {
//            final Random rand = new Random();          //chera nemiad to in sharttttttttttttttttttttt
//
//            int valueTimeReg = rand.nextInt(5000);
//            valueTimeReg += 5000;
//            int valueTimeBuck = rand.nextInt(5000);
//            valueTimeBuck += 16000;  // Random between 5 and 13 seconds
//            TimerTask regZombie = new TimerTask() {
//                @Override
//                public void run() {
//                    final int value = rand.nextInt(3);
//                    Zombie z = new RegularZombie(1100, zombieEntrance[value], state);
//                    state.drawables.add(z);
//
//                }
//            };
//
//            TimerTask buckZombie = new TimerTask() {
//                @Override
//                public void run() {
//                    final int value = rand.nextInt(3);
//                    Zombie z = new BucketHeadZombie(1100, zombieEntrance[value], state);
//                    state.drawables.add(z);
//
//                }
//            };
//            Timer timer = new Timer();
//            timer.schedule(regZombie, 15000L, valueTimeReg);
//            Timer timer2 = new Timer();
//            timer2.schedule(buckZombie, 15000L, valueTimeBuck);
//
//            if (zombieSifficiency >= 5) {
//                state.level++;
//            }
//        }


        for (int j = 0; j < 5; j++)
            for (int i = 0; i < 9; i++)
                state.selectables.add(new Selectable(395 + (i * 75), 40 + (j * 105), state));
//        if(state.level>=1)
////        state.drawables.add(new LawnMover(270, 250, state));
//
//        if(state.level>=2) {
//            state.drawables.add(new LawnMover(270, 150, state));
//            state.drawables.add(new LawnMover(270, 350, state));
//        }
//
//        if (state.level >= 3) {
//            state.drawables.add(new LawnMover(270, 50, state));
//            state.drawables.add(new LawnMover(270, 450, state));
//        }


        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                makeSun();

            }

        };
        Timer timer = new Timer();
        timer.schedule(timerTask, 0L, 6000L);
    }



    private Drawable getClickedItem(int x, int y) {
        for (int i = state.getDrawables().size() - 1; i >= 0; i--) {
            Drawable drawable = state.getDrawables().get(i);
            if (
                    (x >= drawable.x && x <= drawable.x + drawable.width) &&
                            (y >= drawable.y && y <= drawable.y + drawable.height)
                    ) {
                return drawable;
            }
        }
        return null;
    }





    private Selectable getClickedSelectable(int x, int y) {
        for (Selectable selectable : state.selectables) {
            if (
                    (x >= selectable.x && x <= selectable.x + 70) &&
                            (y >= selectable.y && y <= selectable.y + 70)
                    ) {
                return selectable;
            }
        }
        return null;
    }

    private void makeSun() {
        if (state.states == 2) {
            Random rand = new Random();
            int value = rand.nextInt(state.selectables.size());
            state.addDrawables(new Sun(state, state.selectables.get(value)));
        }
    }

    @Override
    public void run() {
        boolean gameOver = false;
        while (!gameOver) {
            try {
                gameOver = state.gameOver;
                long start = System.currentTimeMillis();
                //
                state.update();
                state.currentLevel.update();
                canvas.render(state);

                long delay = (1000 / FPS) - (System.currentTimeMillis() - start);
                if (delay > 0)
                    Thread.sleep(delay);
            } catch (InterruptedException ignored) {
            }
        }
    }

    void update(){
        init();

       if(state.level>=2)
           state.addDrawables(new IcedPeaShooterPicker(195, 57, state));



       if(state.level>=5)
            state.addDrawables(new CherryBombPicker(325, 57, state));


      //  if (state.level>=3) grassRows = 5;




    }
}

