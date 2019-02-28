package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.GameObject;

public class Cats extends GameObject {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private static final int SPEED = 5;

    public Cats(int health) {
        super(health, SPEED,new Rectangle(10, 10, WIDTH, HEIGHT));
    }

    @Override
    public void moveX() {


        //setCurrentX(Direction.RIGHT);

        super.moveX();
    }

}

