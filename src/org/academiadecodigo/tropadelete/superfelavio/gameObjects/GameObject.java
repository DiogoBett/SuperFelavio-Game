package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.superfelavio.Direction;

import java.awt.*;

public abstract class GameObject {
    protected int health;
    protected Direction currentDirection;
    protected Rectangle objectHitbox;

    public GameObject(int health){
        this.health = health;
        this.currentDirection = null;
    }

    public void move() {
        if (currentDirection == Direction.RIGHT) {
            objectHitbox.translate(10,0);
        }

        if (currentDirection == Direction.LEFT) {
            objectHitbox.translate(-10,0);
        }

        if (currentDirection == null) {
            objectHitbox.translate(0,0);
        }
    }

    public void takeDamage (){
        health--;
    }

    public int getHealth() {
        return health;
    }

    public Direction getCurrentDirection() {
        return currentDirection;
    }

    public void setCurrentDirection(Direction currentDirection) {
        this.currentDirection = currentDirection;
    }

    public Rectangle getobjectHitbox() {
        return objectHitbox;
    }
}
