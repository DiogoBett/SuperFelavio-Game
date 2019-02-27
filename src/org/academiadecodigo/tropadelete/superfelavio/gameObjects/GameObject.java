package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.tropadelete.superfelavio.Direction;

import java.awt.*;

public abstract class GameObject {
    protected int health;
    protected Direction currentDirection;
    protected Rectangle objectHitbox;
    private int speed;

    public GameObject(int health, int speed, Rectangle objectHitbox) {
        this.health = health;
        this.currentDirection = null;
        this.speed = speed;
        this.objectHitbox = objectHitbox;
    }

    public void move() {
        if (currentDirection == Direction.RIGHT) {
            objectHitbox.translate(speed, 0);
        }

        if (currentDirection == Direction.LEFT) {
            objectHitbox.translate(-speed, 0);
        }

        /*if (currentDirection == null) {
            objectHitbox.translate(0,0);
        }*/
    }

    public void takeDamage() {
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

    public void objectDraw() {
        objectHitbox.draw();
    }

    public void spawn(int PositionX, int PositionY) {
        objectHitbox.translate(PositionX, PositionY - objectHitbox.getY() - 10);
        objectHitbox.draw();
    }

    public int getX() {
        return objectHitbox.getX();
    }

    public int getWidth() {
        return getX() + objectHitbox.getWidth();
    }

    public int getY() {
        return objectHitbox.getY();
    }

    public int getHeight() {
        return getY() + objectHitbox.getHeight();
    }

    public boolean checkY(GameObject other) {

        //compares whether the top of the other object's hitbox is within this object's hitbox height
        boolean topY = getY() <= other.getY() && other.getY() <= getHeight();

        //compares whether the bottom of the other object's hitbox is within this object's hitbox height
        boolean bottomY = getY() <= other.getHeight() && other.getHeight() <= getHeight(); //

        return (topY || bottomY);
    }

    public boolean checkX(GameObject other) {

        boolean rightX = other.getX() <= getWidth() && other.getX() >= getX();
        boolean leftX = other.getWidth() >= getX() && other.getWidth() <= getX();
        return (rightX || leftX);
    }
}
