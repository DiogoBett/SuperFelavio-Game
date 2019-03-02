package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats.Cats;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.Player;

public class Game {
    public final int PADDING = 10;

    public final int groundHeight = 30;

    public static int GROUND_Y;
    public static int WALL_RIGHT;
    public static int WALL_LEFT;

    private Player felavio;
    private Cats[] cats;

    private Picture background;
    private CollisionDetector detector;

    public Game(Player felavio, int catNumber) {
        this.cats = new Cats[catNumber];
        this.felavio = felavio;
        detector = new CollisionDetector(felavio, cats);
    }

    public void start() {


        this.background = new Picture(PADDING, PADDING, "resources/Ground.png");
        background.draw();
        Line ground = new Line(PADDING, background.getHeight() - groundHeight, background.getWidth(), background.getHeight() - groundHeight);
        GROUND_Y = ground.getY() - groundHeight;
        WALL_LEFT = background.getX();
        WALL_RIGHT = background.getWidth();

        felavio.spawn(WALL_RIGHT/2, GROUND_Y);
        felavio.show();

        new KeyboardListener(felavio);

        for (int i = 0; i < cats.length; i++) {

            int random = (int) (Math.random() * 101);

            int catStartPoint = WALL_RIGHT;

            if (random < 50) {
                catStartPoint = WALL_LEFT;
            }

            cats[i] = new Cats(1, catStartPoint);
            cats[i].show();

            /*int random = (int) (Math.random() * (background.getWidth() - PLAYER_SPAWNZONE) + PLAYER_SPAWNZONE);
            cats[i].spawn(random, ground.getY() -  groundHeight);
            cats[i].show();*/
        }
        run();
    }

    private void run() {
        while (true) {//felavio.isDead()
            try {

                felavio.moveX();
                felavio.moveY();
                Thread.sleep(50);
            } catch (Exception e) {
                System.out.println("sleep failed");
            }


            for (int i = 0; i < cats.length; i++) {
                if(!cats[i].isDead()){
                cats[i].moveX();
                }

            }
            detector.collisionDetect();
        }
    }
}
