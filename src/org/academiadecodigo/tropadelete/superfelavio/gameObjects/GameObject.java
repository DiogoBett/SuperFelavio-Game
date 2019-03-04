package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.pictures.Picture;
import org.academiadecodigo.tropadelete.superfelavio.Direction;
import org.academiadecodigo.tropadelete.superfelavio.Game;

public abstract class GameObject {
    protected int health;
    private Direction currentX;
    protected Direction currentY;
    protected Rectangle hitbox;
    protected Picture rightPic;
    private Picture leftPic;
    private int speed;
    protected int jumpHeight;


    public GameObject(int health, int speed, Rectangle hitbox, Picture rightPic, Picture leftPic) {
        this.health = health;
        this.currentX = null;
        this.currentY = null;
        this.speed = speed;
        this.hitbox = hitbox;
        this.jumpHeight = 0;
        this.rightPic = rightPic;
        this.leftPic = leftPic;

    }

    public void moveX() {

        if (currentX == Direction.RIGHT && getWidth() < Game.WALL_RIGHT) {
            hitbox.translate(speed, 0);
            rightPic.translate(speed, 0);
            leftPic.translate(speed, 0);
        }

        if (currentX == Direction.LEFT && getX() > Game.WALL_LEFT) {
            hitbox.translate(-speed, 0);
            rightPic.translate(-speed, 0);
            leftPic.translate(-speed, 0);
        }

    }

    public void moveY() {
        if (currentY == Direction.UP && hitbox.getY() >= jumpHeight) {
            hitbox.translate(0, -speed);
            rightPic.translate(0, -speed);
            leftPic.translate(0, -speed);
            return;
        }
        currentY = null;
        if (getHeight() <= Game.GROUND_Y) {
            hitbox.translate(0, speed);
            rightPic.translate(0, speed);
            leftPic.translate(0, speed);
        }

    }

    public void takeDamage() {
        if (health <= 0) {
            health = 0;
        }
        health--;
    }

    public boolean checkY(GameObject other) {

        //compares whether the top of the other object's hitbox is within this object's hitbox height
        boolean topY = getY() <= other.getY() && other.getY() <= getHeight();

        //compares whether the bottom of the other object's hitbox is within this object's hitbox height
        boolean bottomY = getY() <= other.getHeight() && other.getHeight() <= getHeight(); //

        return (topY || bottomY);
    }

    public boolean checkX(GameObject other) {

        boolean rightX = getX() <= other.getX() && other.getX() <= getWidth();
        boolean leftX = getX() <= other.getWidth() && other.getWidth() <= getWidth();
        return (rightX || leftX);
    }

    public void show() {
        if (currentX==null){
            return;
        }

        switch (currentX) {
            case RIGHT:
                rightPic.draw();
                leftPic.delete();
                break;
            case LEFT:
                leftPic.draw();
                rightPic.delete();
                break;
        }

    }

    public void hide() {
        rightPic.delete();
        leftPic.delete();
    }

    public boolean isDead() {
        return health <= 0;
    }

    public int getHealth() {
        return health;
    }

    public int getX() {
        return hitbox.getX();
    }

    public int getWidth() {
        return getX() + hitbox.getWidth();
    }

    public int getY() {
        return hitbox.getY();
    }

    public int getHeight() {
        return getY() + hitbox.getHeight();
    }

    public Direction getCurrentX() {
        return currentX;
    }

    public Direction getCurrentY() {
        return currentY;
    }

    public void setCurrentX(Direction currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(Direction currentY) {
        this.currentY = currentY;
    }

}
