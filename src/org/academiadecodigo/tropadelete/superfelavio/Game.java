package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Text;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.CatFactory;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;

import java.util.Iterator;
import java.util.LinkedList;

public class Game {

    public final int PADDING = 10;
    public final int groundHeight = 45;
    public static int GROUND_Y;
    public static int WALL_RIGHT;
    public static int WALL_LEFT;

    private Player felavio;
    private LinkedList<Cats> cats;
    private long nextSpawnTime;
    private Picture background;
    private Picture deathScreen;
    private CollisionDetector detector;
    private Text currentScore;
    private Text currentHealth;
    private int score;
    private int spawnDelay;

    private Sound gameSound;

    public Game() {
        this.cats = new LinkedList<Cats>();
        this.background = new Picture(PADDING, PADDING, "resources/ground.jpg");
        this.gameSound = new Sound ("/resources/SuperFelavioMusic.wav");
        this.deathScreen = new Picture(PADDING,PADDING,"resources/deathScreen.jpg");
        this.spawnDelay = 5000;
    }

    public void start() {

        Line ground = new Line(PADDING, background.getHeight() - groundHeight, background.getWidth(), background.getHeight() - groundHeight);
        GROUND_Y = ground.getY() - groundHeight;
        WALL_LEFT = background.getX();
        WALL_RIGHT = background.getWidth();
        this.felavio = new Player();
        currentScore = new Text(10,10, "Score: " + score);
        currentHealth = new Text(10, 30, "Health: " + felavio.getHealth());

        detector = new CollisionDetector(felavio, cats);

        background.draw();
        felavio.show();
        currentScore.draw();
        currentHealth.draw();

        gameSound.setLoop(100);

        new KeyboardListener(felavio);

        //start screen

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
            while (it.hasNext()){
                Cats kitty = it.next();
                if(kitty.isDead()){
                    kitty.hide();
                    it.remove();
                    score = score + 10;
                    updateScore();
                    continue;
                }
                kitty.moveX();
            }
            detector.collisionDetect();
        }

        deathScreen.draw();
        showScore();


    }

    private void spawner () {
        if(nextSpawnTime <= System.currentTimeMillis()){
            Cats cat1 =CatFactory.spawnCats(1, WALL_RIGHT - 50);
            Cats cat2 =CatFactory.spawnCats(1, WALL_LEFT);
            cats.add(cat1);
            cats.add(cat2);
            cat1.show();
            cat2.show();
            nextSpawnTime = System.currentTimeMillis() + spawnDelay;
            if(spawnDelay >= 2000 ){
                spawnDelay -= 100;
            }

        }

    }

    public void updateScore() {
        currentScore.delete();
        currentScore = new Text(10,10, "Score: " + score);
        currentScore.draw();
    }

    public void updateHealth() {
        currentHealth.delete();
        currentHealth = new Text(10,30, "Health: " + felavio.getHealth());
        currentHealth.draw();
    }

    public void showScore() {

        if (score == 0) {
            Text endScore = new Text(deathScreen.getWidth()/2 + 100,deathScreen.getHeight()/2, "YOU CAN'T EVEN KILL ONE CAT!?");
            endScore.grow(150,20);
            endScore.draw();
            gameSound.stop();
        }

        if(score > 0) {
            Text endScore = new Text(deathScreen.getWidth()/2 + 100, deathScreen.getHeight()/2, "YOU ONLY KILLED " + score / 10 + " CATS!?");
            endScore.grow(150, 20);
            endScore.draw();
            gameSound.stop();
        }
    }

}
