package org.academiadecodigo.tropadelete.superfelavio;

import org.academiadecodigo.simplegraphics.graphics.Line;
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
    private CollisionDetector detector;

    public Game() {
        this.cats = new LinkedList<Cats>();
        this.felavio = felavio;

    }

    public void start() {


        this.background = new Picture(PADDING, PADDING, "resources/Ground.jpg");
        background.draw();
        Line ground = new Line(PADDING, background.getHeight() - groundHeight, background.getWidth(), background.getHeight() - groundHeight);
        GROUND_Y = ground.getY() - groundHeight;
        WALL_LEFT = background.getX();
        WALL_RIGHT = background.getWidth();
        this.felavio = new Player();
        detector = new CollisionDetector(felavio, cats);
        felavio.show();

        new KeyboardListener(felavio);






        run();
    }

    private void run() {
        nextSpawnTime = System.currentTimeMillis();
        while (true) {//!felavio.isDead()
            spawner();
            try {

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
                    continue;
                }
                kitty.moveX();
            }
            detector.collisionDetect();
        }
    }

    private void spawner () {
        if(nextSpawnTime <= System.currentTimeMillis()){
            Cats cat1 =CatFactory.spawnCats(1, WALL_RIGHT);
            Cats cat2 =CatFactory.spawnCats(1, WALL_LEFT);
            cats.add(cat1);
            cats.add(cat2);
            cat1.show();
            cat2.show();
            nextSpawnTime = System.currentTimeMillis()+5000;
        }

    }



}
