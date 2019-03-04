package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.Direction;
import org.academiadecodigo.tropadelete.superfelavio.Game;
import org.academiadecodigo.tropadelete.superfelavio.Sound;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.GameObject;

public class Cats extends GameObject {
    private static final int WIDTH = 40;
    private static final int HEIGHT = 20;

    private Sound catDeath;
    private Sound catSpawn;

    public Cats(int health, int startPoint,int speed, String rightPic, String leftpic) {
        super(health,
                speed,
                new Rectangle(startPoint, Game.GROUND_Y, WIDTH, HEIGHT),
                new Picture(startPoint, Game.GROUND_Y - 40, rightPic),
                new Picture(startPoint, Game.GROUND_Y - 40, leftpic));

        this.catDeath = new Sound("/resources/sound/catDeath.wav");
        this.catSpawn = new Sound("/resources/sound/catSpawn.wav");
        catSpawn.play(true);

        setCurrentX(Direction.LEFT);
    }

    @Override
    public void moveX() {


        if (super.getX() <= Game.WALL_LEFT || super.getWidth() >= Game.WALL_RIGHT) {
            super.setCurrentX(Direction.oppositeDirection(getCurrentX()));
            super.show();
        }
        super.moveX();
    }

    @Override
    public boolean isDead() {
        boolean isDead = super.isDead();
        if (isDead) {
            catDeath.play(true);
        }
        return isDead;
    }
}



