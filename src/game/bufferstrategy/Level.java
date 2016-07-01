package game.bufferstrategy;

import java.util.*;

/**
 * Created by saeedehspg on 6/29/16.
 */
class Level {
    private int[] zombieEntrance = {
            250,150,350,50,450
    };
    private HashMap<Integer, Zombie> generateZombies = new HashMap<Integer, Zombie>();
    private ArrayList<TimerTask> zombiesTimerTasks = new ArrayList<TimerTask>();
    private Timer zombiesTimer = new Timer();
    GameState state;

    Level(GameState state) {
        this.state = state;
    }

    void init() {
        for (final Integer delay: generateZombies.keySet()) {
            TimerTask spawnTimerTask = new TimerTask() {
                @Override
                public void run() {
                    state.addDrawables(generateZombies.get(delay));
                }
            };

            zombiesTimerTasks.add(spawnTimerTask);
            zombiesTimer.schedule(spawnTimerTask, delay + 15000 /* Level initial delay */);
        }
    }

    private void levelCompleted() {
        finishLevel();
        state.killedZombie = 0;
        state.money = 0;
        state.clearDrawables();
        for (Selectable selectable : state.selectables) {
            selectable.dig();
            selectable.setUnPlantable();
        }

        state.level++;
        state.massage = "مرحله بعد";
        Timer nextLevelTimer = new Timer();
        TimerTask nextLevelMessage = new TimerTask() {
            @Override
            public void run() {
                state.massage = "";
            }
        };
        nextLevelTimer.schedule(nextLevelMessage, 2000);


        switch (state.level) {
            case 2:
                state.currentLevel = new Level2(state);
                break;
            case 3:
                state.currentLevel = new Level3(state);
                break;
            case 4:
                state.currentLevel = new Level4(state);
                break;
            case 5:
                state.currentLevel = new Level5(state);
                break;
            default:
                state.gameOver = true;
                return;
        }
        state.currentLevel.init();
    }

    void drawGrasses(int grassRows) {
        Timer drawGrassTimer = new Timer();

        final Grass grassRow1 = new Grass(385, 50-5, state);
        final RollingGrass rollingGrass1 = new RollingGrass(385, 50, state);
        final Grass grassRow2 = new Grass(380, 150-5, state);
        final RollingGrass rollingGrass2 = new RollingGrass(380, 150, state);
        final Grass grassRow3 = new Grass(380, 250-5, state);
        final RollingGrass rollingGrass3 = new RollingGrass(380, 250, state);
        final Grass grassRow4 = new Grass(380, 350-5, state);
        final RollingGrass rollingGrass4 = new RollingGrass(380, 350, state);
        final Grass grassRow5 = new Grass(375, 450-5, state);
        final RollingGrass rollingGrass5 = new RollingGrass(375, 450, state);

        if (grassRows > 3) {
            state.addDrawables(grassRow1);
            state.addDrawables(rollingGrass1);
        }
        if (grassRows > 1) {
            state.addDrawables(grassRow2);
            state.addDrawables(rollingGrass2);
        }
        state.addDrawables(grassRow3);
        state.addDrawables(rollingGrass3);
        if (grassRows > 1) {
            state.addDrawables(grassRow4);
            state.addDrawables(rollingGrass4);

            state.addDrawables(new LawnMover(270, 150, state));
            state.addDrawables(new LawnMover(270, 350, state));
        }
        if (grassRows > 3) {
            state.addDrawables(grassRow5);
            state.addDrawables(rollingGrass5);

            state.addDrawables(new LawnMover(270, 50, state));
            state.addDrawables(new LawnMover(270, 450, state));
        }

        grassRow3.state = Grass.GrassState.Growing;
        rollingGrass3.state = RollingGrass.RollingGrassState.Rolling;

        state.addDrawables(new LawnMover(270, 250, state));

        if (grassRows > 1) {
            drawGrassTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    grassRow2.state = Grass.GrassState.Growing;
                    rollingGrass2.state = RollingGrass.RollingGrassState.Rolling;
                    grassRow4.state = Grass.GrassState.Growing;
                    rollingGrass4.state = RollingGrass.RollingGrassState.Rolling;
                }
            }, 2000L);
        }

        if (grassRows > 3) {
            drawGrassTimer.schedule(new TimerTask() {
                @Override
                public void run() {
                    grassRow1.state = Grass.GrassState.Growing;
                    rollingGrass1.state = RollingGrass.RollingGrassState.Rolling;
                    grassRow5.state = Grass.GrassState.Growing;
                    rollingGrass5.state = RollingGrass.RollingGrassState.Rolling;
                }
            }, 3000L);
        }
    }

    void update() {
        if (state.killedZombie >= generateZombies.size()) {
            levelCompleted();
        }
    }

    private void finishLevel(){
        for (TimerTask timerTask : zombiesTimerTasks) {
            timerTask.cancel();
        }
        zombiesTimer.purge();
        zombiesTimer.cancel();
    }

    enum ZombieType {
        Regular,
        BucketHead,
        PoleVaulting,
        CatapultBasketBall
    }

    void makeRandomZombiesOfType(ZombieType zombieType, int count, int grassRows) {
        final Random rand = new Random();
        int Delays = 0;

        for (int i = 0; i < count; i++) {
            int randomDelay = rand.nextInt(5000);
            randomDelay += 8000;

            Delays += randomDelay;

            Zombie zombie;

            switch (zombieType) {
                case Regular:
                    zombie = new RegularZombie(1100, zombieEntrance[rand.nextInt(grassRows)], state);
                    break;

                case BucketHead:
                    zombie = new BucketHeadZombie(1100, zombieEntrance[rand.nextInt(grassRows)], state);
                    break;

                case PoleVaulting:
                    zombie = new PoleVaultingZombie(1100, zombieEntrance[rand.nextInt(grassRows)], state);
                    break;

                case CatapultBasketBall:
                    zombie = new CatapultBasketBallZombie(1100, zombieEntrance[rand.nextInt(grassRows)], state);
                    break;
                default:
                    continue;
            }

            generateZombies.put(Delays, zombie);
        }
    }

    PlantsPicker setDefaultPicker(PlantsPicker plantsPicker) {
        state.pointedPicker = plantsPicker;
        plantsPicker.setPointing(true);
        return plantsPicker;
    }

}
