package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Shape;
import org.academiadecodigo.tropadelete.superfelavio.CollisionDetector;
import org.academiadecodigo.tropadelete.superfelavio.Direction;
import org.academiadecodigo.tropadelete.superfelavio.Game;

public abstract class GameObject {
    private int health;
    private Direction currentX;
    protected Direction currentY;
    protected Rectangle hitbox;
    private int speed;
    protected int jumpHeight;
    private Shape[] wall;


    public GameObject(int health, int speed, Rectangle hitbox) {
        this.health = health;
        this.currentX = null;
        this.currentY = null;
        this.speed = speed;
        this.hitbox = hitbox;
        this.jumpHeight = 0;
    }

    public void moveX() {
        if (currentX == Direction.RIGHT) {
            hitbox.translate(speed, 0);
        }

        if (currentX == Direction.LEFT) {
            hitbox.translate(-speed, 0);
        }

        /*if (currentX == null) {
            hitbox.translate(0,0);
        }*/
    }

    public void moveY() {
        if (currentY == Direction.UP && hitbox.getY() >= jumpHeight) {
            hitbox.translate(0, -speed);
            return;
        } else {
            currentY = Direction.DOWN;
        }

        if(currentY == Direction.DOWN && hitbox.getY() + hitbox.getHeight() <= Game.GROUND_Y){
            hitbox.translate(0,speed);
        }


    }

    public void takeDamage() {
        health--;
    }

    public void spawn(int PositionX, int PositionY) {
        hitbox.translate(PositionX, PositionY - getHeight());
        hitbox.draw();
        jumpHeight = getHeight();
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
        hitbox.draw();
    }

    public void hide() {
        hitbox.delete();
    }

    public void hittingtheWall(){

    }

    public boolean isDead() {
        return health >= 0;
    }

    public Rectangle getHitbox() {
        return hitbox;
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

    public int getHealth() {
        return health;
    }

    public Direction getCurrentX() {
        return currentX;
    }

    public void setCurrentX(Direction currentX) {
        this.currentX = currentX;
    }

    public void setCurrentY(Direction currentY) {
        this.currentY = currentY;
    }

}
