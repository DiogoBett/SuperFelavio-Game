package org.academiadecodigo.tropadelete.superfelavio.gameObjects;

import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Player extends GameObject {
    private static final int WIDTH = 20;
    private static final int HEIGHT = 40;
    private static final int SPEED = 10;


    private static final int HEALTH = 7;

    private boolean jump;


    public Player() {
        super(HEALTH, SPEED, new Rectangle(10, 750 - HEIGHT, WIDTH, HEIGHT));
        this.jump = false;
    }

    public void jump() {

    }

    public boolean isJump() {
        return jump;
    }


    //Power Ups are NOT MVP
}
