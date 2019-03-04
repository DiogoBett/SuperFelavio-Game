package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.CatFactory;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp.PowerUp;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp.PowerUpFactory;

import java.util.Iterator;
import java.util.LinkedList;

import static org.academiadecodigo.tropadelete.superfelavio.gameObjects.PowerUp.PowerUpFactory.spawnPowerUp;

public class Game {

    private final int PADDING = 10;
    private final int groundHeight = 45;
    private static int SCORE;
    public static int GROUND_Y;
    public static int WALL_RIGHT;
    public static int WALL_LEFT;


    private Player felavio;
    private LinkedList<Cats> cats;
    private LinkedList<PowerUp> powerUps;
    private long nextSpawnTime;
    private Picture background;
    private Picture deathScreen;
    private Picture startScreen;
    private CollisionDetector detector;
    private Text currentScore;
    private Text currentHealth;
    private int catCounter;
    private int spawnDelay;

    private Sound gameSound;

    public Game() {
        this.cats = new LinkedList<Cats>();
        this.powerUps = new LinkedList<>();
        this.background = new Picture(PADDING, PADDING, "resources/images/ground.jpg");
        this.gameSound = new Sound("/resources/sound/SuperFelavioMusic.wav");
        this.deathScreen = new Picture(PADDING, PADDING, "resources/images/deathScreen.jpg");
        this.startScreen = new Picture(PADDING, PADDING, "resources/images/startScreen.jpg");
        this.spawnDelay = 5000;
    }

    public void start() {

        Line ground = new Line(PADDING, background.getHeight() - groundHeight, background.getWidth(), background.getHeight() - groundHeight);
        GROUND_Y = ground.getY() - groundHeight;
        WALL_LEFT = background.getX();
        WALL_RIGHT = background.getWidth();
        this.felavio = new Player();
        currentScore = new Text(10, 10, "Score: " + SCORE);
        currentHealth = new Text(10, 30, "Health: " + felavio.getHealth());

        detector = new CollisionDetector(felavio, cats, powerUps);

        background.draw();
        felavio.show();
        currentScore.draw();
        currentHealth.draw();

        gameSound.setLoop(100);

        new KeyboardListener(felavio);

        pickStartScreen();

        startScreen.draw();

        while (felavio.getCurrentX() == null && felavio.getCurrentY() == null) {

        }

        felavio.setCurrentX(Direction.RIGHT);
        felavio.show();
        felavio.setCurrentX(null);
        startScreen.delete();
        run();

    }

    private void run() {
        nextSpawnTime = System.currentTimeMillis();
        while (!felavio.isDead()) {
            spawner();
            try {
                updateHealth();
                felavio.show();
                felavio.moveX();
                felavio.moveY();
                Thread.sleep(20);
            } catch (Exception e) {
                System.out.println("sleep failed");
            }


            Iterator<Cats> it = cats.iterator();
            while (it.hasNext()) {
                Cats kitty = it.next();
                if (kitty.isDead()) {
                    spawnPowerUp(kitty.getX());
                    kitty.hide();
                    it.remove();
                    catCounter++;
                    updateScore();
                    continue;
                }
                kitty.moveX();
            }
            detector.checkCollisions();
        }

        deathScreen.draw();
        showScore();

    }

    private void spawner() {
        if (cats.size() >= 15) {
            return;
        }
        if (nextSpawnTime >= System.currentTimeMillis()) {
            return;
        }
        Cats cat1 = CatFactory.spawnCats(WALL_RIGHT - 50);
        Cats cat2 = CatFactory.spawnCats(WALL_LEFT);
        cats.add(cat1);
        cats.add(cat2);
        cat1.show();
        cat2.show();
        nextSpawnTime = System.currentTimeMillis() + spawnDelay;
        if (spawnDelay >= 2000) {
            spawnDelay -= 100;
        }


    }

    private void spawnPowerUp(int position) {
        if (powerUps.size() >= 2) {
            return;
        }

        int spawnChance = (int) (Math.random() * 100);

        if (spawnChance < 25) {

            PowerUp powerUp = PowerUpFactory.spawnPowerUp(position);
            powerUps.add(powerUp);
            powerUp.show();
        }
    }

    public void updateScore() {
        currentScore.delete();
        currentScore = new Text(10, 10, "Score: " + SCORE);
        currentScore.draw();
    }

    public void updateHealth() {
        currentHealth.delete();
        currentHealth = new Text(10, 30, "Health: " + felavio.getHealth());
        currentHealth.draw();
    }

    public void showScore() {

        if (SCORE == 0) {
            Text gameScore = new Text(deathScreen.getWidth() / 2 + 200, deathScreen.getHeight() / 2, "SCORE: N00B");
            Text catCounterText = new Text(deathScreen.getWidth() / 2 + 200, deathScreen.getHeight() / 2 + 50, "YOU CAN'T EVEN KILL ONE CAT!?");
            gameScore.grow(150, 20);
            catCounterText.grow(150, 20);
            gameScore.draw();
            catCounterText.draw();
            gameSound.stop();
        }

        if (SCORE > 0) {
            Text gameScore = new Text(deathScreen.getWidth() / 2 + 200, deathScreen.getHeight() / 2, "FINAL SCORE: " + SCORE);
            Text catCounterText = new Text(deathScreen.getWidth() / 2 + 200, deathScreen.getHeight() / 2 + 50, "YOU ONLY KILLED " + catCounter + " CATS!?");
            gameScore.grow(150, 20);
            catCounterText.grow(150, 20);
            gameScore.draw();
            catCounterText.draw();
            gameSound.stop();
        }
    }

    public void pickStartScreen() {
        int randomStartScreen = (int) (Math.random() * 3);

        if (randomStartScreen == 0) {
            this.startScreen = new Picture(PADDING, PADDING, "resources/images/startScreen.jpg");
        }

        if (randomStartScreen == 1) {
            this.startScreen = new Picture(PADDING, PADDING, "resources/images/startScreenHat.jpg");
        }

        if (randomStartScreen == 2) {
            this.startScreen = new Picture(PADDING, PADDING, "resources/images/startScreenThug.jpg");
        }

    }

    public static void increaseScore(int increase) {
        SCORE = SCORE + increase;
    }

}
