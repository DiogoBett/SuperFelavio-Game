package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.superfelavio.Direction;
import org.academiadecodigo.tropadelete.superfelavio.Game;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.GameObject;

public class Cats extends GameObject {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 10;
    private static final int SPEED = 5;

    public Cats(int health) {
        super(health, SPEED,new Rectangle(10, 10, WIDTH, HEIGHT));
        setCurrentX(Direction.LEFT);
    }

    @Override
    public void moveX() {



        if(super.getX() <= Game.WALL_LEFT || super.getWidth() >= Game.WALL_RIGHT){
            super.setCurrentX(Direction.oppositeDirection(getCurrentX()));
        }
        super.moveX();
    }

}

