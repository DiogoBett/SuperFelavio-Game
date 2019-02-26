package org.academiadecodigo.tropadelete.superfelavio.gameObjects.Cats;

import org.academiadecodigo.tropadelete.superfelavio.Direction;
import org.academiadecodigo.tropadelete.superfelavio.gameObjects.GameObject;

public class Cats extends GameObject {

    public Cats(int health) {
        super(health);
    }

    @Override
    public void move() {

        int random = (int) (Math.random() * 1 + Direction.values().length);

        setCurrentDirection(Direction.values()[random]);

        super.move();
    }
}
